package com.megacom.testhttp.repos;

import com.megacom.testhttp.models.Addres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Addres, Long> {
}
