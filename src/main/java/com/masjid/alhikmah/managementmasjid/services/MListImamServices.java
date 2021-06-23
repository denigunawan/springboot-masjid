package com.masjid.alhikmah.managementmasjid.services;


import com.masjid.alhikmah.managementmasjid.models.MListImamModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListImamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListImamServices {

    @Autowired
    private MListImamRepository listImam;

    public List<MListImamModels> getAll(){
        return listImam.findAll();
    }

    public void save(MListImamModels mListImamModels){
        listImam.save(mListImamModels);
    }

    public Optional<MListImamModels> findById(String imam_id){
        return  listImam.findById(imam_id);
    }

    public void deleteById(String imam_id){
        listImam.deleteById(imam_id);
    }

}
