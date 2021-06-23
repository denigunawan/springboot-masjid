package com.masjid.alhikmah.managementmasjid.repositories;


import com.masjid.alhikmah.managementmasjid.models.MListKhotibModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MListKhotibRepository extends JpaRepository<MListKhotibModels, String> {
}
