package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.MListImamModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MListImamRepository extends JpaRepository<MListImamModels, String> {
}
