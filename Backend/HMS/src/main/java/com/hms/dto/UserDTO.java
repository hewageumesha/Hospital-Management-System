package com.hms.dto;

import com.hms.entity.User;
import com.hms.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Roles role;

    public User toEntity() {
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
