package com.devitro.turisticka.agencija.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "rezervacija")
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "klijent_id", nullable = false)
    private Klijent klijent;
    @ManyToOne
    @JoinColumn(name = "turisticki_paket_id")
    private TuristickiPaket turistickiPaket;


    //@ManyToOne
    //private TuristickiPaket turistickiPaket;

    private LocalDate datumRezervacije;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public TuristickiPaket getTuristickiPaket() {
        return turistickiPaket;
    }

    public void setTuristickiPaket(TuristickiPaket turistickiPaket) {
        this.turistickiPaket = turistickiPaket;
    }

    public LocalDate getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(LocalDate datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }
}

