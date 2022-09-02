package com.megacom.testhttp.repos;

import com.megacom.testhttp.models.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepo extends JpaRepository<Geo, Long> {
}
