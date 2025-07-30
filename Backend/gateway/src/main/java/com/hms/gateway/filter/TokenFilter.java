package main.java.com.hms.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config> {
    private static final String SECRET="2540a95c7cb5379d92aa8ab47599b5feb963b430b543b0de43b3b55a1b5c83ca5cd1b0eec4809a67bcc365d5f0e9e5e4642f681d093663406ffab01a39959194";

    public TokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> { 
            String path = exchange.getRequest().getPath().toString();
            if(path.equals("/user/login") || path.equals("/user/register")) {
                return chain.filter(exchange.mutate().request(r -> r.header("X-Secret-Key", "SECRET")).build());
            }

            HttpHeaders header = exchange.getRequest().getHeaders();

            if(!header.containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Authorization header is missing!");
            }

            String authHeader = header.getFirst(HttpHeaders.AUTHORIZATION);

            if(authHeader == null || !authHeader.startsWith("Bearer")) {
                throw new RuntimeException("Authorization header is invalid!");
            }

            String token = authHeader.substring(7);

            try {
                Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
                exchange = exchange.mutate().request.request(r -> r.header("X-Secret-Key", "SECRET")).build();
            } catch (Exception e) {
                throw new RuntimeException("Token is invalid!");
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {

    }
}

