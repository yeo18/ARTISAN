package com.artisan.artisan.Entity;

import jakarta.persistence.OneToMany;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
public class Administrateur {
    @OneToMany
    private List<Commentaire> commentaires;

    @OneToMany
    private List<Demande> demandes;
}
