package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.MListBilalModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MListBilalRepository extends JpaRepository<MListBilalModels, String> {
}
