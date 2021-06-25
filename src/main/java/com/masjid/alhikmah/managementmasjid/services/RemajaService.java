package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.Remaja;
import com.masjid.alhikmah.managementmasjid.repositories.RemajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RemajaService {

    @Autowired
    private RemajaRepository remajaRepository;


    public List<Remaja> getRemaja(){
        return remajaRepository.findAll();
    }

    @Transactional
    public Remaja save(Remaja remaja){
       return remajaRepository.save(remaja);
    }

    public Optional<Remaja> findById(String id){
        return remajaRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        remajaRepository.deleteById(id);
    }

}
