package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.Rezervacija;
import com.devitro.turisticka.agencija.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class RezervacijaServiceImpl implements RezervacijaService {
    @Autowired
    private RezervacijaRepository rezervacijaRepository;

   public List<Rezervacija> getAllRezervacije() {
        return rezervacijaRepository.findAll();
    }

    public Rezervacija getRezervacijaById(Long id) {
        return rezervacijaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezervacija not found"));
    }

    public Rezervacija createRezervacija(Rezervacija rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    public Rezervacija updateRezervacija(Long id, Rezervacija rezervacijaDetails) {
        Rezervacija rezervacija = rezervacijaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezervacija not found"));
        rezervacija.setDatumRezervacije(rezervacijaDetails.getDatumRezervacije());

        return rezervacijaRepository.save(rezervacija);
    }
    public void deleteRezervacija(Long id) {
        Optional<Rezervacija> rezervacija = rezervacijaRepository.findById(id);
        if (rezervacija.isPresent()) {
            rezervacijaRepository.delete(rezervacija.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rezervacija not found");
        }
    }

    @Override
    public List<Rezervacija> getAllRezervacija() {
        return null;
    }
}
