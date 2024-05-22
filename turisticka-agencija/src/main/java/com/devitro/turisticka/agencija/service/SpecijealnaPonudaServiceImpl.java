package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.SpecijalnaPonuda;
import com.devitro.turisticka.agencija.repository.SpecijalnaPonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SpecijealnaPonudaServiceImpl implements SpecijalnaPonudaService{
    @Autowired
    private SpecijalnaPonudaRepository specijalnaPonudaRepository;

    @Override
    public List<SpecijalnaPonuda> getAllSpecijalnaPonuda() {
        return specijalnaPonudaRepository.findAll();
    }

    @Override
    public SpecijalnaPonuda getSpecijalnaPonudaById(Long id) {
        return specijalnaPonudaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Specijalna ponuda not found"));
    }

    @Override
    public SpecijalnaPonuda createSpecijalnaPonuda(SpecijalnaPonuda specijalnaPonuda) {
        return specijalnaPonudaRepository.save(specijalnaPonuda);
    }

    @Override
    public SpecijalnaPonuda updateSpecijalnaPonuda(Long id, SpecijalnaPonuda specijalnaPonuda) {
        SpecijalnaPonuda existingSpecijalnaPonuda = specijalnaPonudaRepository.findById(id).orElse(null);
        if (existingSpecijalnaPonuda != null) {
            existingSpecijalnaPonuda.setNaziv(specijalnaPonuda.getNaziv());
            existingSpecijalnaPonuda.setPopust(specijalnaPonuda.getPopust());
            // Dodajte ostale atribute koje želite ažurirati
            return specijalnaPonudaRepository.save(existingSpecijalnaPonuda);
        } else {
            return null;
        }
    }

    @Override
    public void deleteSpecijalnaPonuda(Long id) {
        specijalnaPonudaRepository.deleteById(id);
    }
}
