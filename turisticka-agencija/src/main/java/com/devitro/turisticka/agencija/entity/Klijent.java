package com.devitro.turisticka.agencija.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "klijent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String adresa;

    @OneToMany(mappedBy = "klijent", cascade = CascadeType.ALL)
    //private List<Rezervacija> rezervacije;
    private Set<Rezervacija> rezervacije = new HashSet<>();
    //TODO ovde mozda treba list

    public Klijent() {
    }

    public Klijent(String ime, String prezime, String email, String adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
        for (Rezervacija rezervacija : this.rezervacije) {
            rezervacija.setKlijent(this);
        }
    }

    public void addRezervacija(Rezervacija rezervacija) {
        rezervacije.add(rezervacija);
        rezervacija.setKlijent(this);
    }

    public void removeRezervacija(Rezervacija rezervacija) {
        rezervacije.remove(rezervacija);
        rezervacija.setKlijent(null);
    }

    @Override
    public String toString() {
        return "Klijent{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}