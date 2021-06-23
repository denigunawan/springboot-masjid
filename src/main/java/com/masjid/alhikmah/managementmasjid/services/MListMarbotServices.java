package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MListMarbotModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListMarbotRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListMarbotServices {

    @Autowired
    private MListMarbotRepositry listMarbot;

    public List<MListMarbotModels> getAll(){
        return listMarbot.findAll();
    }

    public void save(MListMarbotModels mListMarbotModels){
        listMarbot.save(mListMarbotModels);
    }

    public Optional<MListMarbotModels> findById(String marbot_id){
        return listMarbot.findById(marbot_id);
    }

    public void deleteById(String marbot_id){
        listMarbot.deleteById(marbot_id);
    }

}
