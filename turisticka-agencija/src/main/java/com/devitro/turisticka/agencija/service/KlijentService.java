package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.Klijent;

import java.util.List;

public interface KlijentService {
    List<Klijent> getAllKlijenti();

    Klijent getKlijentById(Long id);

    Klijent createKlijent(Klijent klijent);

    Klijent updateKlijent(Long id, Klijent klijentDetails);

    void deleteKlijent(Long id);
}
