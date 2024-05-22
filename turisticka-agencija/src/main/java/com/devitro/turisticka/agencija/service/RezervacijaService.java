package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.Rezervacija;

import java.util.List;

public interface RezervacijaService {
    //List<Rezervacija> getAllRezervacije();
    Rezervacija getRezervacijaById(Long id);
    Rezervacija createRezervacija(Rezervacija rezervacija);
    Rezervacija updateRezervacija(Long id, Rezervacija rezervacijaDetails);
    void deleteRezervacija(Long id);

    List<Rezervacija> getAllRezervacija();
}
