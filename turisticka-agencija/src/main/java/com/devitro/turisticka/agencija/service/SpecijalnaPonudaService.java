package com.devitro.turisticka.agencija.service;

import com.devitro.turisticka.agencija.entity.SpecijalnaPonuda;

import java.util.List;

public interface SpecijalnaPonudaService {
    List<SpecijalnaPonuda> getAllSpecijalnaPonuda();

    SpecijalnaPonuda getSpecijalnaPonudaById(Long id);

    SpecijalnaPonuda createSpecijalnaPonuda(SpecijalnaPonuda specijalnaPonuda);

    SpecijalnaPonuda updateSpecijalnaPonuda(Long id,SpecijalnaPonuda specijalnaPonuda);
    void deleteSpecijalnaPonuda(Long id);
}
