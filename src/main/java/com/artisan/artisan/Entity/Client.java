package com.artisan.artisan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity

public class Client extends Utilisateur {
    @OneToMany(mappedBy = "client")
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "client")
    private List<Demande> demandes;
}
