package com.artisan.artisan.Controller.Demande;

import com.artisan.artisan.Dto.DemandeCreateDto;
import com.artisan.artisan.Entity.Demande;
import com.artisan.artisan.Service.Demande.CreateDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demandes/create")
public class CreateDemandeController {

    @Autowired
    private CreateDemandeService createDemandeService;

    @PostMapping
    public ResponseEntity<Demande> createDemande(@RequestBody DemandeCreateDto dto) {
        return ResponseEntity.ok(createDemandeService.execute(dto));
    }
}
