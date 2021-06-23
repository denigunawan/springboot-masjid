package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.MListOrphansAndElderlyModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MListOrphansAndElderlyRepository extends JpaRepository<MListOrphansAndElderlyModels, String> {
}
