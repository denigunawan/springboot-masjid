package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MListMuazinModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListMuazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListMuazinServices {

    @Autowired
    private MListMuazinRepository listMuazin;


    public List<MListMuazinModels> getAll(){
        return listMuazin.findAll();
    }

    public void save(MListMuazinModels mListMuazinModels){
        listMuazin.save(mListMuazinModels);
    }

    public Optional<MListMuazinModels> findById(String muazin_id){
        return listMuazin.findById(muazin_id);
    }

    public void deleteById(String muazin_id){
        listMuazin.deleteById(muazin_id);
    }
}
