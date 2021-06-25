package com.masjid.alhikmah.managementmasjid.services;


import com.masjid.alhikmah.managementmasjid.models.master.Bilal;
import com.masjid.alhikmah.managementmasjid.repositories.BilalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BilalService {

    @Autowired
    private BilalRepository bilalRepository;

    public List<Bilal> getBilal(){
        return bilalRepository.findAll();
    }

    @Transactional
    public Bilal save(Bilal bilal) {
     return  bilalRepository.save(bilal);
    }

    public Optional<Bilal> findById(String id){
        return bilalRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        bilalRepository.deleteById(id);
    }
}
