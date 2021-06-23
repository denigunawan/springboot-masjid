package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.MAdministratorModels;
import com.masjid.alhikmah.managementmasjid.repositories.MListAdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MListAdministratorServices {

    @Autowired
    private MListAdministratorRepository listAdmin;

    public List<MAdministratorModels> getAdministrators(){
        return listAdmin.findAll();
    }

    public void save(MAdministratorModels administrator){
        listAdmin.save(administrator);
    }

    public Optional<MAdministratorModels> findById(String administrator_id){
        return listAdmin.findById(administrator_id);
    }

    public void deleteAdministrator(String administrator_id){
        listAdmin.deleteById(administrator_id);
    }
}
