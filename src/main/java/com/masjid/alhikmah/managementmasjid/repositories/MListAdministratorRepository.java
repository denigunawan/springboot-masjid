package com.masjid.alhikmah.managementmasjid.repositories;


import com.masjid.alhikmah.managementmasjid.models.MAdministratorModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MListAdministratorRepository extends JpaRepository<MAdministratorModels, String> {
}
