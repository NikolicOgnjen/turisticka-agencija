    package com.devitro.turisticka.agencija.entity;

    import jakarta.persistence.*;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @Table(name = "specijalna_ponuda")
    public class SpecijalnaPonuda {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String naziv;

        @Column(nullable = false)
        private BigDecimal popust;

        @Column(nullable = false)
        private LocalDateTime datumPocetka;

        @Column(nullable = false)
        private LocalDateTime datumZavrsetka;

        @Column(nullable = false)
        private boolean aktivna;

        //@OneToMany(mappedBy = "specijalnaPonuda", cascade = CascadeType.ALL)
        //private Set<TuristickiPaket> turistickiPaketi= new HashSet<>() ;
        @OneToMany(mappedBy = "specijalnaPonuda", cascade = CascadeType.ALL)
        private Set<TuristickiPaket> turistickiPaketi = new HashSet<>();




        public SpecijalnaPonuda() {
        }

        public SpecijalnaPonuda(String naziv, BigDecimal popust, LocalDateTime datumPocetka, LocalDateTime datumZavrsetka) {
            this.naziv = naziv;
            this.popust = popust;
            this.datumPocetka = datumPocetka;
            this.datumZavrsetka = datumZavrsetka;
            this.aktivna = true;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNaziv() {
            return naziv;
        }

        public void setNaziv(String naziv) {
            this.naziv = naziv;
        }

        public BigDecimal getPopust() {
            return popust;
        }

        public void setPopust(BigDecimal popust) {
            this.popust = popust;
        }

        public LocalDateTime getDatumPocetka() {
            return datumPocetka;
        }

        public void setDatumPocetka(LocalDateTime datumPocetka) {
            this.datumPocetka = datumPocetka;
        }

        public LocalDateTime getDatumZavrsetka() {
            return datumZavrsetka;
        }

        public void setDatumZavrsetka(LocalDateTime datumZavrsetka) {
            this.datumZavrsetka = datumZavrsetka;
        }

        public boolean isAktivna() {
            return datumZavrsetka.isAfter(LocalDateTime.now()) && datumPocetka.isBefore(LocalDateTime.now());
        }

        public void setAktivna(boolean aktivna) {
            this.aktivna = aktivna;
        }

        public Set<TuristickiPaket> getTuristickiPaketi() {
            return turistickiPaketi;
        }

        public void setTuristickiPaketi(Set<TuristickiPaket> turistickiPaketi) {
            this.turistickiPaketi = turistickiPaketi;
        }
    }

