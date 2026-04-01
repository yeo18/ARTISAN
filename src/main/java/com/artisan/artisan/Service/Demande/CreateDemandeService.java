package com.artisan.artisan.Service.Demande;

import com.artisan.artisan.Dto.DemandeCreateDto;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Repository.ClientRepository;
import com.artisan.artisan.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Demande execute(DemandeCreateDto dto) {
        Demande demande = new Demande();
        demande.setDate_rendez_vous(dto.getDate_rendez_vous());
        demande.setHeure(dto.getHeure());
        demande.setDescription_travail(dto.getDescription_travail());
        demande.setStatut_demande("NOUVELLE"); // ou "EN_ATTENTE"

        if (dto.getClientId() != null) {
            Client client = clientRepository.findById(dto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            demande.setClient(client);
        }

        return demandeRepository.save(demande);
    }
}
