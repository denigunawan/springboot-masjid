package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.Marbot;
import com.masjid.alhikmah.managementmasjid.repositories.MarbotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MarbotService {

    @Autowired
    private MarbotRepository marbotRepository;

    public List<Marbot> getMarbot(){
        return marbotRepository.findAll();
    }

    @Transactional
    public Marbot save(Marbot marbot){
      return    marbotRepository.save(marbot);
    }

    public Optional<Marbot> findById(String id){
        return marbotRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        marbotRepository.deleteById(id);
    }


}
