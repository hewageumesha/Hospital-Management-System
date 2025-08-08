package com.hms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hms.entity.Patient;


public interface PatientRepository extends CrudRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}
