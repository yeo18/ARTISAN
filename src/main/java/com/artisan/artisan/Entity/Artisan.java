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
public class Artisan extends Utilisateur {
    @ManyToOne
    @JoinColumn(name = "metier_id")
    private Metier metier;
}
