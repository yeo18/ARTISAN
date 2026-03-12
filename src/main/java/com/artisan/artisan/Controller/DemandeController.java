package com.artisan.artisan.Controller;

import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    // ✅ GARDE : demande complète
    @GetMapping("/{id}")
    public Demande getDemande(@PathVariable Long id) {
        return demandeService.getDemandeById(id);
    }

    // ✅ GARDE
    @GetMapping("/{id}/date-rendezvous")
    public LocalDate getDateRendezVous(@PathVariable Long id) {
        return demandeService.getDateRendezVous(id);
    }

    // ✅ GARDE
    @GetMapping("/{id}/description")
    public String getDescription(@PathVariable Long id) {
        return demandeService.getDescriptionTravail(id);
    }

    // ✅ GARDE
    @GetMapping("/{id}/statut")
    public String getStatut(@PathVariable Long id) {
        return demandeService.getStatutDemande(id);
    }

    // ✅ GARDE
    @GetMapping("/{id}/heure")
    public LocalDate getHeure(@PathVariable Long id) {
        return demandeService.getHeure(id);
    }

    // ❌ SUPPRIME : l'ancien @GetMapping("/{id}/photo") qui retournait String

    // ✅ AJOUTE : uploader une image (POST)
    @PostMapping("/{id}/photo")
    public ResponseEntity<String> uploadPhoto(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {

        demandeService.uploadPhoto(id, file);
        return ResponseEntity.ok("Image uploadée avec succès !");
    }

    // ✅ AJOUTE : récupérer et AFFICHER l'image (GET)
    // C'est cette route que tu tapes dans Postman pour VOIR l'image
    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) {
        byte[] imageBytes = demandeService.getPhoto(id);
        String contentType = demandeService.getPhotoContentType(id);

        if (imageBytes == null || imageBytes.length == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "image/jpeg")
                .body(imageBytes);
    }
}