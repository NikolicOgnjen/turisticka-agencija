package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.TuristickiPaket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TuristickiPaketService {
    List<TuristickiPaket> getAllTuristickiPaket();

    TuristickiPaket getTuristickiPaketById(Long id);

    TuristickiPaket createTuristickiPaket(TuristickiPaket turistickaAgencija);

    TuristickiPaket updateTuristickaiPaket(Long id, TuristickiPaket turistickaAgencija);

    TuristickiPaket updateTuristickiPaket(Long id, TuristickiPaket turistickiPaket);

    void deleteTuristickiPaket(Long id);

    List<TuristickiPaket> getFilteredTuristickiPaketi(String destinacija, LocalDate startDate, LocalDate endDate, BigDecimal minPrice, BigDecimal maxPrice);
}
