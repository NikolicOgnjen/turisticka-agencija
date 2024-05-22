package com.devitro.turisticka.agencija.repository;

import com.devitro.turisticka.agencija.entity.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long> {
}
