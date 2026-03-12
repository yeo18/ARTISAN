package com.artisan.artisan.Service;

import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    // ✅ GARDE : récupérer demande complète
    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'id : " + id));
    }

    // ✅ GARDE
    public LocalDate getDateRendezVous(Long id) {
        return getDemandeById(id).getDate_rendez_vous();
    }

    // ✅ GARDE
    public String getDescriptionTravail(Long id) {
        return getDemandeById(id).getDescription_travail();
    }

    // ✅ GARDE
    public String getStatutDemande(Long id) {
        return getDemandeById(id).getStatut_demande();
    }

    // ✅ GARDE
    public LocalDate getHeure(Long id) {
        return getDemandeById(id).getHeure();
    }

    // ❌ SUPPRIME : getPhotoEndommage() qui retournait String

    // ✅ AJOUTE : uploader une image et la sauvegarder en base
    public Demande uploadPhoto(Long id, MultipartFile file) throws IOException {
        Demande demande = getDemandeById(id);
        demande.setPhoto_endommage(file.getBytes());          // convertit en byte[]
        demande.setPhoto_content_type(file.getContentType()); // ex: "image/jpeg"
        return demandeRepository.save(demande);
    }

    // ✅ AJOUTE : récupérer les bytes de l'image
    public byte[] getPhoto(Long id) {
        return getDemandeById(id).getPhoto_endommage();
    }

    // ✅ AJOUTE : récupérer le type MIME de l'image
    public String getPhotoContentType(Long id) {
        return getDemandeById(id).getPhoto_content_type();
    }
}