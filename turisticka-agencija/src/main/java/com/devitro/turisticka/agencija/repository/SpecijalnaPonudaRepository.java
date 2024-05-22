package com.devitro.turisticka.agencija.repository;

import com.devitro.turisticka.agencija.entity.SpecijalnaPonuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecijalnaPonudaRepository extends JpaRepository<SpecijalnaPonuda,Long> {
}
