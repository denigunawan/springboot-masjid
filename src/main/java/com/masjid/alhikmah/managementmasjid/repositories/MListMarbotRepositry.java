package com.masjid.alhikmah.managementmasjid.repositories;


import com.masjid.alhikmah.managementmasjid.models.MListMarbotModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MListMarbotRepositry extends JpaRepository<MListMarbotModels, String> {
}
