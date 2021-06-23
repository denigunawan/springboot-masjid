package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MListKhotibModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListKhotibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListKhotibServices {

    @Autowired
    private MListKhotibRepository listKhotib;


    public List<MListKhotibModels> getAll(){
        return listKhotib.findAll();
    }

    public void save(MListKhotibModels mListKhotibModels){
        listKhotib.save(mListKhotibModels);
    }

    public Optional<MListKhotibModels> findById(String khotib_id){
        return listKhotib.findById(khotib_id);
    }


    public void deleteById(String khotib_id){
        listKhotib.deleteById(khotib_id);
    }
}
