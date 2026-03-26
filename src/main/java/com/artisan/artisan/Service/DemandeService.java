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

    // ✅ AJOUTE CETTE METHODE
    public Demande saveDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée avec l'id : " + id));
    }

    public LocalDate getDateRendezVous(Long id) {
        return getDemandeById(id).getDate_rendez_vous();
    }

    public String getDescriptionTravail(Long id) {
        return getDemandeById(id).getDescription_travail();
    }

    public String getStatutDemande(Long id) {
        return getDemandeById(id).getStatut_demande();
    }

    public LocalDate getHeure(Long id) {
        return getDemandeById(id).getHeure();
    }

    public Demande uploadPhoto(Long id, MultipartFile file) throws IOException {
        Demande demande = getDemandeById(id);
        demande.setPhoto_endommage(file.getBytes());
        demande.setPhoto_content_type(file.getContentType());
        return demandeRepository.save(demande);
    }

    public byte[] getPhoto(Long id) {
        return getDemandeById(id).getPhoto_endommage();
    }

    public String getPhotoContentType(Long id) {
        return getDemandeById(id).getPhoto_content_type();
    }
}