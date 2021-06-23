package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MListTeenagerModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListTeenagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListTeenagerServices {

    @Autowired
    private MListTeenagerRepository listTeenager;

    public List<MListTeenagerModels> getAll(){
        return listTeenager.findAll();
    }

    public void save(MListTeenagerModels mListTeenagerModels){
        listTeenager.save(mListTeenagerModels);
    }

    public Optional<MListTeenagerModels> findById(String teenager_id){
        return listTeenager.findById(teenager_id);
    }

    public void deleteById(String teenagers_id){
        listTeenager.deleteById(teenagers_id);
    }

}
