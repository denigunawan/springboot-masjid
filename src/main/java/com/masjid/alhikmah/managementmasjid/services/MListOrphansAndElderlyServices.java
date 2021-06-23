package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MListOrphansAndElderlyModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListOrphansAndElderlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListOrphansAndElderlyServices {


    @Autowired
    private MListOrphansAndElderlyRepository listOAE;

    public List<MListOrphansAndElderlyModels> getAll(){
        return listOAE.findAll();
    }

    public void save(MListOrphansAndElderlyModels listOrphansAndElderlyModels){
        listOAE.save(listOrphansAndElderlyModels);
    }

    public Optional<MListOrphansAndElderlyModels> findById(String oae_id){
        return listOAE.findById(oae_id);
    }


    public void deleteById(String oae_id){
        listOAE.deleteById(oae_id);
    }
}
