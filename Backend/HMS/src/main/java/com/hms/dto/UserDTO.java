package com.hms.dto;

import com.hms.entity.User;
import com.hms.enums.Roles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message="Name is mandatory!")
    private String name;
    @NotBlank(message="Email is mandatory!")
    @Email(message = "Email should be valid!")
    private String email;
    @NotBlank(message="Password is mandatory!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$", message = "Password should contain at least 1 uppercase, 1 lowercase, 1 digit, and 1 special character with minimum 8 characters.")   
    private String password;
    private Roles role;
    private Long profileId;

    public User toEntity() {
        return new User(this.id, this.name, this.email, this.password, this.role, this.profileId);
    }
}
