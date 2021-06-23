package com.masjid.alhikmah.managementmasjid.services;


import com.masjid.alhikmah.managementmasjid.models.MListBilalModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListBilalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListBilalServices {

    @Autowired
    private MListBilalRepository listBilal;

    public List<MListBilalModels> getBilal(){
        return listBilal.findAll();
    }

    public void saveBilal(MListBilalModels save){
        listBilal.save(save);
    }

    public Optional<MListBilalModels> findById(String bilal_id){
        return listBilal.findById(bilal_id);
    }

    public void delete(String bilal_id){
        listBilal.deleteById(bilal_id);
    }
}
