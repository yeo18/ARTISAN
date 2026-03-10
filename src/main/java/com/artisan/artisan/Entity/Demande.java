package com.artisan.artisan.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate Date_rendez_vous;
    private String photo_endommage;
    private String Description_travail;
    private String Statut_demande;
    private LocalDate heure;

    @ManyToOne
    private Client client;

    public LocalDate getHeure() {
        return heure;
    }

    public void setHeure(LocalDate heure) {
        this.heure = heure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate_rendez_vous() {
        return Date_rendez_vous;
    }

    public void setDate_rendez_vous(LocalDate date_rendez_vous) {
        Date_rendez_vous = date_rendez_vous;
    }

    public String getPhoto_endommage() {
        return photo_endommage;
    }

    public void setPhoto_endommage(String photo_endommage) {
        this.photo_endommage = photo_endommage;
    }

    public String getDescription_travail() {
        return Description_travail;
    }

    public void setDescription_travail(String description_travail) {
        Description_travail = description_travail;
    }

    public String getStatut_demande() {
        return Statut_demande;
    }

    public void setStatut_demande(String statut_demande) {
        Statut_demande = statut_demande;
    }
}
