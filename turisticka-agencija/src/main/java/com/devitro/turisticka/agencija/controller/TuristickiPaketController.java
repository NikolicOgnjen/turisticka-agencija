package com.devitro.turisticka.agencija.controller;

import com.devitro.turisticka.agencija.entity.TuristickiPaket;
import com.devitro.turisticka.agencija.service.TuristickiPaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turistickiPaket")
public class TuristickiPaketController {
    @Autowired
    private TuristickiPaketService turistickiPaketService;

    @RequestMapping("/all")
    public ResponseEntity<List<TuristickiPaket>> getAllTuristickiPaket() {
        List<TuristickiPaket> turistickiPaketList = turistickiPaketService.getAllTuristickiPaket();
        return new ResponseEntity<>(turistickiPaketList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuristickiPaket> getTuristickiPaketById(@PathVariable Long id) {
        TuristickiPaket turistickiPaket = turistickiPaketService.getTuristickiPaketById(id);
        return new ResponseEntity<>(turistickiPaket, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TuristickiPaket> createTuristickiPaket(@RequestBody TuristickiPaket turistickiPaket) {
        TuristickiPaket createdTuristickiPaket = turistickiPaketService.createTuristickiPaket(turistickiPaket);
        return new ResponseEntity<>(createdTuristickiPaket, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TuristickiPaket> updateTuristickiPaket(@PathVariable Long id, @RequestBody TuristickiPaket turistickiPaket) {
        TuristickiPaket updatedTuristickiPaket = turistickiPaketService.updateTuristickiPaket(id, turistickiPaket);
        if (updatedTuristickiPaket != null) {
            return new ResponseEntity<>(updatedTuristickiPaket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTuristickiPaket(@PathVariable Long id) {
        turistickiPaketService.deleteTuristickiPaket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<TuristickiPaket>> getFilteredTuristickiPaketi(
            @RequestParam(required = false) String destinacija,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice
    ) {
        List<TuristickiPaket> turistickiPaketi = turistickiPaketService.getFilteredTuristickiPaketi(destinacija, startDate, endDate, minPrice, maxPrice);
        return new ResponseEntity<>(turistickiPaketi, HttpStatus.OK);
    }


}
