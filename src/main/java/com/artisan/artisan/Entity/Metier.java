package com.artisan.artisan.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToMany(mappedBy = "metiers")
    private List<Artisan> artisans;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Artisan> getArtisans() {
        return artisans;
    }

    public void setArtisans(List<Artisan> artisans) {
        this.artisans = artisans;
    }
}
