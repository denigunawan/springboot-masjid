package com.masjid.alhikmah.managementmasjid.repositories;


import com.masjid.alhikmah.managementmasjid.models.MListMuazinModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MListMuazinRepository extends JpaRepository<MListMuazinModels, String> {
}
