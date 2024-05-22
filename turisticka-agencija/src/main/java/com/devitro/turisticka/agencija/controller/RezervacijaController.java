package com.devitro.turisticka.agencija.controller;

import com.devitro.turisticka.agencija.entity.Klijent;
import com.devitro.turisticka.agencija.entity.Rezervacija;
import com.devitro.turisticka.agencija.entity.TuristickiPaket;
import com.devitro.turisticka.agencija.service.KlijentService;
import com.devitro.turisticka.agencija.service.KlijentServiceImpl;
import com.devitro.turisticka.agencija.service.RezervacijaService;
import com.devitro.turisticka.agencija.service.TuristickiPaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rezervacije")
public class RezervacijaController {

    //@Autowired
    private RezervacijaService rezervacijaService;
    private  KlijentService klijentService;
    private TuristickiPaketService turistickiPaketService;

    @Autowired
    public RezervacijaController(RezervacijaService rezervacijaService, KlijentService klijentService, TuristickiPaketService turistickiPaketService) {
        this.rezervacijaService = rezervacijaService;
        this.klijentService=klijentService;
        this.turistickiPaketService = turistickiPaketService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Rezervacija>> getAllRezervacija() {
        List<Rezervacija> rezervacijaList = rezervacijaService.getAllRezervacija();
        return new ResponseEntity<>(rezervacijaList, HttpStatus.OK);
    }


    /*@RequestMapping("/al")
    public List<Rezervacija> getAllRezervacija() {
        return rezervacijaService.getAllRezervacija();
    }

     */

    @GetMapping("/{id}")
    public ResponseEntity<Rezervacija> getRezervacijaById(@PathVariable Long id) {
        Rezervacija rezervacija = rezervacijaService.getRezervacijaById(id);
        if (rezervacija != null) {
            return new ResponseEntity<>(rezervacija, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Rezervacija> createRezervacija(@RequestBody Rezervacija rezervacija) {
        Klijent klijent = klijentService.getKlijentById(rezervacija.getKlijent().getId());
        TuristickiPaket turistickiPaket = turistickiPaketService.getTuristickiPaketById(rezervacija.getTuristickiPaket().getId());
        if (klijent != null) {
            rezervacija.setTuristickiPaket(turistickiPaket);
            rezervacija.setKlijent(klijent);
            Rezervacija createdRezervacija = rezervacijaService.createRezervacija(rezervacija);
            return new ResponseEntity<>(createdRezervacija, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rezervacija> updateRezervacija(@PathVariable Long id, @RequestBody Rezervacija rezervacija) {
        Klijent klijent = klijentService.getKlijentById(rezervacija.getKlijent().getId());
        TuristickiPaket turistickiPaket = turistickiPaketService.getTuristickiPaketById(rezervacija.getTuristickiPaket().getId());
        if (klijent != null && turistickiPaket != null) {
            rezervacija.setKlijent(klijent);
            rezervacija.setTuristickiPaket(turistickiPaket);
            Rezervacija updatedRezervacija = rezervacijaService.updateRezervacija(id, rezervacija);
            if (updatedRezervacija != null) {
                return new ResponseEntity<>(updatedRezervacija, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    /*
    public ResponseEntity<HttpStatus> deleteRezervacija(@PathVariable Long id) {
        rezervacijaService.deleteRezervacija(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

     */
    public ResponseEntity<HttpStatus> deleteRezervacija(@PathVariable Long id) {
        try {
            rezervacijaService.deleteRezervacija(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception if necessary
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
