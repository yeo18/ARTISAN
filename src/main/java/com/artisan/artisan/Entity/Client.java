package com.artisan.artisan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

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

public class Client extends Utilisateur {
    @OneToMany(mappedBy = "client")
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "client")
    private List<Demande> demandes;
}
