package com.devitro.turisticka.agencija.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TuristickiPaket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinacija;

    @Column(nullable = false)
    private String opis;

    @Column(nullable = false)
    private LocalDate datumPutovanja;

    @Column(nullable = false)
    private BigDecimal cena;

    @Column(nullable = false)
    private boolean dostupnost;
    // TuristickiPaket.java
    //@ManyToOne
    //private SpecijalnaPonuda specijalnaPonuda;
    @ManyToOne
    @JoinColumn(name = "specijalna_ponuda_id")
    private SpecijalnaPonuda specijalnaPonuda;

    @OneToMany(mappedBy = "turistickiPaket", cascade = CascadeType.ALL)
    private List<Rezervacija> rezervacije;

    // Getteri i setteri

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDatumPutovanja() {
        return datumPutovanja;
    }

    public void setDatumPutovanja(LocalDate datumPutovanja) {
        this.datumPutovanja = datumPutovanja;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

}
