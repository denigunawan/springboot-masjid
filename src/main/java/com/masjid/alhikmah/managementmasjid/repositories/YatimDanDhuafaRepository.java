package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.master.YatimDanDhuafa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YatimDanDhuafaRepository extends JpaRepository<YatimDanDhuafa, String> {
}
