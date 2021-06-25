package com.masjid.alhikmah.managementmasjid.repositories;

import com.masjid.alhikmah.managementmasjid.models.master.Imam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImamRepository extends JpaRepository<Imam, String> {
}
