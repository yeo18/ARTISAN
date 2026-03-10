package com.artisan.artisan.Service;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    /**
     * Récupère une demande par son ID. Si elle n'existe pas, une exception est levée.
     * C'est la méthode principale qui retourne l'objet complet.
     */
    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'id : " + id));
    }

    /**
     * Récupère uniquement la date de rendez-vous.
     */
    public LocalDate getDateRendezVous(Long id) {
        return getDemandeById(id).getDate_rendez_vous();
    }

    /**
     * Récupère le lien de la photo (peut être null).
     */
    public String getPhotoEndommage(Long id) {
        return getDemandeById(id).getPhoto_endommage();
    }

    /**
     * Récupère la description du travail.
     */
    public String getDescriptionTravail(Long id) {
        return getDemandeById(id).getDescription_travail();
    }

    /**
     * Récupère le statut de la demande.
     */
    public String getStatutDemande(Long id) {
        return getDemandeById(id).getStatut_demande();
    }

    /**
     * Récupère la date/heure (champ "heure").
     */
    public LocalDate getHeure(Long id) {
        return getDemandeById(id).getHeure();
    }

    /**
     * Récupère le client associé (si besoin).
     */
    public Client getClient(Long id) {
        return getDemandeById(id).getClient();
    }
}