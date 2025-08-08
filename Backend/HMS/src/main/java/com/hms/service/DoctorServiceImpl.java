package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dto.DoctorDTO;
import com.hms.exception.HMSException;
import com.hms.repository.DoctorRepository;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Long addDoctor(DoctorDTO doctorDTO) throws HMSException {
        if((doctorDTO.getEmail() !=null && doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent()) || (doctorDTO.getLicenseNo() != null && doctorRepository.findByLicenseNo(doctorDTO.getLicenseNo()).isPresent())) {
            throw new HMSException("DOCTOR_ALREADY_EXISTS");
        }
        return doctorRepository.save(doctorDTO.toEntity()).getId();
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HMSException {
        return doctorRepository.findById(id).orElseThrow(() -> new HMSException("DOCTOR_NOT_FOUND")).toDto();
    }
    
}
