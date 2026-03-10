package com.artisan.artisan.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Artisan extends Utilisateur {
    @ManyToMany
    private List<Metier> metiers;
}
