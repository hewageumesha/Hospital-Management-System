package com.hms.dto;

import java.time.LocalDate;

import com.hms.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorDTO {
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    @Column(unique = true)
    private String licenseNo;
    private String specialization;
    private String department;
    private Integer experienceYears;

    public Doctor toEntity() {
        return new Doctor(this.id, this.name, this.email, this.dateOfBirth, this.phone, this.address, 
                          this.licenseNo, this.specialization, this.department, this.experienceYears);
    }
}
