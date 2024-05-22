package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.Klijent;
import com.devitro.turisticka.agencija.repository.KlijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class KlijentServiceImpl implements KlijentService{


    @Autowired
    private KlijentRepository klijentRepository;

    public List<Klijent> getAllKlijenti() {
        return klijentRepository.findAll();
    }

    public Klijent getKlijentById(Long id) {
        return klijentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Klijent not found"));
    }

    public Klijent createKlijent(Klijent klijent) {
        return klijentRepository.save(klijent);
    }

    public Klijent updateKlijent(Long id, Klijent klijentDetails) {
        Klijent klijent = klijentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Klijent not found"));
        klijent.setIme(klijentDetails.getIme());
        klijent.setPrezime(klijentDetails.getPrezime());
        klijent.setEmail(klijentDetails.getEmail());
        klijent.setAdresa(klijentDetails.getAdresa());

        return klijentRepository.save(klijent);
    }


    public void deleteKlijent(Long id) {
        Optional<Klijent> klijent = klijentRepository.findById(id);
        if (klijent.isPresent()) {
            klijentRepository.delete(klijent.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Klijent not found");
        }
    }
}