package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.MListTeenagerModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MListTeenagerRepository extends JpaRepository<MListTeenagerModels, String> {
}
