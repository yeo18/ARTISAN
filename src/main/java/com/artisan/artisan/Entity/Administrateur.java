package com.artisan.artisan.Entity;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Administrateur {
    @OneToMany
    private List<Commentaire> commentaires;

    @OneToMany
    private List<Demande> demandes;
}
