package com.masjid.alhikmah.managementmasjid.services;


import com.masjid.alhikmah.managementmasjid.models.master.Imam;
import com.masjid.alhikmah.managementmasjid.repositories.ImamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ImamService {

    @Autowired
    private ImamRepository imamRepository;

    public List<Imam> getimam(){
        return imamRepository.findAll();
    }

    @Transactional
    public Imam save(Imam imam){
      return   imamRepository.save(imam);
    }

    public Optional<Imam> findById(String id){
        return imamRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        imamRepository.deleteById(id);
    }

}
