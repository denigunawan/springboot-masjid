package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.Khotib;
import com.masjid.alhikmah.managementmasjid.repositories.KhotibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class KhotibService {

    @Autowired
    private KhotibRepository khotibRepository;


    public List<Khotib> getKhotib(){
        return khotibRepository.findAll();
    }

    @Transactional
    public Khotib save(Khotib khotib){
        return khotibRepository.save(khotib);
    }

    public Optional<Khotib> findById(String id){
        return khotibRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        khotibRepository.deleteById(id);
    }
}
