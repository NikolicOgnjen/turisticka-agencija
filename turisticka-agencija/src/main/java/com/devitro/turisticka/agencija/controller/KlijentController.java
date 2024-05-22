package com.devitro.turisticka.agencija.controller;

import com.devitro.turisticka.agencija.entity.Klijent;
import com.devitro.turisticka.agencija.service.KlijentService;
import com.devitro.turisticka.agencija.service.KlijentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klijent")
public class KlijentController {
    @Autowired
    private KlijentService klijentService;

    @RequestMapping("/all")
    public ResponseEntity<List<Klijent>> getAllKlijenti() {
        List<Klijent> klijenti = klijentService.getAllKlijenti();
        return new ResponseEntity<>(klijenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klijent> getKlijentById(@PathVariable Long id) {
        Klijent klijent = klijentService.getKlijentById(id);
        return klijent != null ? new ResponseEntity<>(klijent, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Klijent> createKlijent(@RequestBody Klijent klijent) {
        Klijent createdKlijent = klijentService.createKlijent(klijent);
        return new ResponseEntity<>(createdKlijent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Klijent> updateKlijent(@PathVariable Long id, @RequestBody Klijent klijent) {
        Klijent updatedKlijent = klijentService.updateKlijent(id, klijent);
        return updatedKlijent != null ? new ResponseEntity<>(updatedKlijent, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKlijent(@PathVariable Long id) {
        klijentService.deleteKlijent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

