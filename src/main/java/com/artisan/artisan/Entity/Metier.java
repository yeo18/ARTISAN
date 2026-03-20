package com.artisan.artisan.Entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "metier")
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
