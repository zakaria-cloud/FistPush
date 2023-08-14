package com.exemple1.demoMVC.services;

import com.exemple1.demoMVC.entities.Patient;
import com.exemple1.demoMVC.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class PatientServicesImp implements PatientServices{

    private PatientRepository patientRepository;
    @Override
    public Page<Patient> patients(String Keyword,int page, int size) {
        //return patientRepository.findAll(PageRequest.of(page,size));
        return patientRepository.Search(Keyword,PageRequest.of(page,size));
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void Delete(Long id) {
         patientRepository.deleteById(id);
    }
    @Override
    public Patient  findById(Long id) {
         return  patientRepository.findById(id).get();
    }
}
