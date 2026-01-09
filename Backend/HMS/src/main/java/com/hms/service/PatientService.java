package com.hms.service;

import com.hms.dto.PatientDTO;
import com.hms.exception.HMSException;

public interface PatientService {
    public Long addPatient(PatientDTO patientDTO) throws HMSException;
    public PatientDTO getPatientById(Long id) throws HMSException;
}
