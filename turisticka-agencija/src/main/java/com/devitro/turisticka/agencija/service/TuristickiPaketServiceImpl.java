package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.TuristickiPaket;
import com.devitro.turisticka.agencija.repository.TuristickiPaketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TuristickiPaketServiceImpl implements TuristickiPaketService {
    @Autowired
    private TuristickiPaketRepository turistickiPaketRepository;


    public List<TuristickiPaket> getFilteredTuristickiPaketi(String destinacija, LocalDate startDate, LocalDate endDate, BigDecimal minPrice, BigDecimal maxPrice) {
        return turistickiPaketRepository.findByFilter(destinacija, startDate, endDate, minPrice, maxPrice);
    }

    @Override
    public List<TuristickiPaket> getAllTuristickiPaket() {
        return turistickiPaketRepository.findAll();
    }

    @Override
    public TuristickiPaket getTuristickiPaketById(Long id) {
        return turistickiPaketRepository.findById(id).orElse(null);
    }

    @Override
    public TuristickiPaket createTuristickiPaket(TuristickiPaket turistickiPaket) {
        return turistickiPaketRepository.save(turistickiPaket);
    }

    @Override
    public TuristickiPaket updateTuristickaiPaket(Long id, TuristickiPaket turistickaAgencija) {
        return null;
    }

    @Override
    public TuristickiPaket updateTuristickiPaket(Long id, TuristickiPaket turistickiPaket) {
        TuristickiPaket existingTuristickiPaket = turistickiPaketRepository.findById(id).orElse(null);
        if (existingTuristickiPaket != null) {
            //existingTuristickiPaket.setNaziv(turistickiPaket.getNaziv());
            existingTuristickiPaket.setOpis(turistickiPaket.getOpis());
            // Dodajte ostale atribute koje želite ažurirati
            return turistickiPaketRepository.save(existingTuristickiPaket);
        } else {
            return null;
        }

    }

    @Override
    public void deleteTuristickiPaket(Long id) {
        turistickiPaketRepository.deleteById(id);
    }
}