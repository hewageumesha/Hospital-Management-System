package com.hms.entity;

import java.time.LocalDate;

import com.hms.dto.DoctorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

    public DoctorDTO toDto() {
        return new DoctorDTO(this.id, this.name, this.email, this.dateOfBirth, this.phone, this.address, 
                             this.licenseNo, this.specialization, this.department, this.experienceYears);
    }
}
