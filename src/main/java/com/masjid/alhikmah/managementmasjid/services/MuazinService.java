package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.Muazin;
import com.masjid.alhikmah.managementmasjid.repositories.MuazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MuazinService {

    @Autowired
    private MuazinRepository muazinRepository;

    public List<Muazin> getMuazin(){
        return muazinRepository.findAll();
    }

    public Muazin save(Muazin muazin){
       return muazinRepository.save(muazin);
    }

    public Optional<Muazin> findById(String id){
        return muazinRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        muazinRepository.deleteById(id);
    }

}
