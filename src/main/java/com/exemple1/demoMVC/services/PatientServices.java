package com.exemple1.demoMVC.services;

import com.exemple1.demoMVC.entities.Patient;
import org.springframework.data.domain.Page;

public interface PatientServices {

    public Page<Patient> patients(String keyword,int page, int size);
    public Patient save(Patient patient);

    void Delete(Long id);

    Patient findById(Long id);
}
