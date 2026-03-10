package com.artisan.artisan.Controller;

import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    // 1. Récupérer la demande complète (tous les champs)
    @GetMapping("/{id}")
    public Demande getDemande(@PathVariable Long id) {
        return demandeService.getDemandeById(id);
    }

    // 2. Récupérer uniquement la date de rendez-vous
    @GetMapping("/{id}/date-rendezvous")
    public LocalDate getDateRendezVous(@PathVariable Long id) {
        return demandeService.getDateRendezVous(id);
    }

    // 3. Récupérer uniquement le lien de la photo (peut être null)
    @GetMapping("/{id}/photo")
    public Map<String, String> getPhoto(@PathVariable Long id) {
        String photo = demandeService.getPhotoEndommage(id);
        Map<String, String> response = new HashMap<>();
        response.put("photo_endommage", photo); // si photo est null, la valeur sera null dans le JSON
        return response;
    }

    // 4. Récupérer la description
    @GetMapping("/{id}/description")
    public String getDescription(@PathVariable Long id) {
        return demandeService.getDescriptionTravail(id);
    }

    // 5. Récupérer le statut
    @GetMapping("/{id}/statut")
    public String getStatut(@PathVariable Long id) {
        return demandeService.getStatutDemande(id);
    }

    // 6. Récupérer la date/heure (champ "heure")
    @GetMapping("/{id}/heure")
    public LocalDate getHeure(@PathVariable Long id) {
        return demandeService.getHeure(id);
    }

    // 7. Récupérer plusieurs champs à la fois (par exemple date et photo)
    @GetMapping("/{id}/infos")
    public Map<String, Object> getInfos(@PathVariable Long id) {
        Demande demande = demandeService.getDemandeById(id);
        Map<String, Object> infos = new HashMap<>();
        infos.put("date_rendez_vous", demande.getDate_rendez_vous());
        infos.put("photo_endommage", demande.getPhoto_endommage());
        infos.put("heure", demande.getHeure());
        // Tu peux ajouter d'autres champs si besoin
        return infos;
    }
}