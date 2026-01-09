package com.hms.dto;

import com.hms.entity.Patient;
import com.hms.enums.BloodGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
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
public class PatientDTO {
    private Long id;
    @NotBlank(message="Name is mandatory!")
    private String name;
    @NotBlank(message="Email is mandatory!")
    @Email(message = "Email should be valid!")
    private String email;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    private BloodGroup bloodGroup;
    private String allergies;
    private String chronicDiseases;

    public Patient toEntity() {
        return new Patient(this.id, this.name, this.email, this.dateOfBirth, this.phone, this.address, this.bloodGroup, this.allergies, this.chronicDiseases);
    }
    
}
