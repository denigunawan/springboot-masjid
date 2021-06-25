package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.YatimDanDhuafa;
import com.masjid.alhikmah.managementmasjid.repositories.YatimDanDhuafaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class YatimDanDhuafaService {


    @Autowired
    private YatimDanDhuafaRepository yatimDanDhuafaRepository;

    public List<YatimDanDhuafa> getYatimDanDhuafa(){
        return yatimDanDhuafaRepository.findAll();
    }

    @Transactional
    public YatimDanDhuafa save(YatimDanDhuafa yatimDanDhuafa){
      return   yatimDanDhuafaRepository.save(yatimDanDhuafa);
    }

    public Optional<YatimDanDhuafa> findById(String id){
        return yatimDanDhuafaRepository.findById(id);
    }

    @Transactional
    public void delete(String id){
        yatimDanDhuafaRepository.deleteById(id);
    }
}
