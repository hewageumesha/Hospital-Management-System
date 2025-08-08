package com.hms.service;

import com.hms.dto.DoctorDTO;
import com.hms.exception.HMSException;

public interface DoctorService {
    public Long addDoctor(DoctorDTO doctorDTO) throws HMSException;
    public DoctorDTO getDoctorById(Long id) throws HMSException;
}
