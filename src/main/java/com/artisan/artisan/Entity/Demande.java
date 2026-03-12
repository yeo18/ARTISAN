package com.artisan.artisan.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ✅ CHANGE int → Long (cohérent avec le repo)

    private LocalDate date_rendez_vous;

    // ✅ SUPPRIME : private String photo_endommage;
    // ✅ AJOUTE : stockage image en base de données
    @Lob
    @Column(name = "photo_endommage", columnDefinition = "BYTEA")
    // BYTEA = type PostgreSQL pour binaire
    private byte[] photo_endommage;

    // ✅ AJOUTE : type MIME de l'image (ex: "image/jpeg", "image/png")
    private String photo_content_type;

    private String description_travail;
    private String statut_demande;
    private LocalDate heure;

    @ManyToOne
    private Client client;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate_rendez_vous() { return date_rendez_vous; }
    public void setDate_rendez_vous(LocalDate date_rendez_vous) { this.date_rendez_vous = date_rendez_vous; }

    public byte[] getPhoto_endommage() { return photo_endommage; }
    public void setPhoto_endommage(byte[] photo_endommage) { this.photo_endommage = photo_endommage; }

    public String getPhoto_content_type() { return photo_content_type; }
    public void setPhoto_content_type(String photo_content_type) { this.photo_content_type = photo_content_type; }

    public String getDescription_travail() { return description_travail; }
    public void setDescription_travail(String description_travail) { this.description_travail = description_travail; }

    public String getStatut_demande() { return statut_demande; }
    public void setStatut_demande(String statut_demande) { this.statut_demande = statut_demande; }

    public LocalDate getHeure() { return heure; }
    public void setHeure(LocalDate heure) { this.heure = heure; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}