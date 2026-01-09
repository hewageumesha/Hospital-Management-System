package com.hms.entity;

import java.time.LocalDate;

import com.hms.dto.PatientDTO;
import com.hms.enums.BloodGroup;

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
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    private BloodGroup bloodGroup;
    private String allergies;
    private String chronicDiseases;

    public PatientDTO toDto() {
        return new PatientDTO(this.id, this.name, this.email, this.dateOfBirth, this.phone, this.address, this.bloodGroup, this.allergies, this.chronicDiseases);
    }
}
