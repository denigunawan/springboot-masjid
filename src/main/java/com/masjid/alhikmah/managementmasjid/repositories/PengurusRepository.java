package com.masjid.alhikmah.managementmasjid.repositories;


import com.masjid.alhikmah.managementmasjid.models.master.Pengurus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengurusRepository extends JpaRepository<Pengurus, String> {
}
