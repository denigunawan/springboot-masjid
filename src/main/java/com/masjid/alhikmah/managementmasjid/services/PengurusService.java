package com.masjid.alhikmah.managementmasjid.services;

import com.masjid.alhikmah.managementmasjid.models.master.Pengurus;
import com.masjid.alhikmah.managementmasjid.repositories.PengurusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PengurusService {

    @Autowired
    private PengurusRepository pengurusRepository;

    public List<Pengurus> getPengurus() {
        return pengurusRepository.findAll();
    }

    @Transactional
    public Pengurus save(Pengurus pengurus) {
         return  pengurusRepository.save(pengurus);
    }

    public Optional<Pengurus> findById(String id) {
        return pengurusRepository.findById(id);
    }

    @Transactional
    public void delete(String id) {
        pengurusRepository.deleteById(id);
    }
}
