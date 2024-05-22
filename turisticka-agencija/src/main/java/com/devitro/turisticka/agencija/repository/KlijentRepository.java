package com.devitro.turisticka.agencija.repository;

import com.devitro.turisticka.agencija.entity.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlijentRepository extends JpaRepository<Klijent,Long> {
}
