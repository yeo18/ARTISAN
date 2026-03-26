package com.artisan.artisan.Service;

import com.artisan.artisan.Dto.ArtisanCreateDto;
import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Repository.ArtisanRepository;
import com.artisan.artisan.Repository.MetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ArtisanService {

    @Autowired
    private ArtisanRepository artisanRepository;

    @Autowired
    private MetierRepository metierRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Artisan create(ArtisanCreateDto artisanCreateDto) {
        if (artisanRepository.findByEmail(artisanCreateDto.getEmail()).isPresent()) {
            throw new RuntimeException("Un artisan avec cet email existe déjà");
        }
        Artisan artisan = new Artisan();
        artisan.setNom(artisanCreateDto.getNom());
        artisan.setPrenom(artisanCreateDto.getPrenom());
        artisan.setEmail(artisanCreateDto.getEmail());
        artisan.setMotpasse(passwordEncoder.encode(artisanCreateDto.getMotpasse()));
        artisan.setLocalisation(artisanCreateDto.getLocalisation());
        artisan.setCommune(artisanCreateDto.getCommune());

        if (artisanCreateDto.getMetierId() != null) {
            artisan.setMetier(metierRepository.findById(artisanCreateDto.getMetierId()).orElse(null));
        }

        return this.artisanRepository.save(artisan);
    }

    public Artisan findOne(String email) {
        return this.artisanRepository.findByEmail(email).orElse(null);
    }

    public Page<Artisan> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.artisanRepository.findAll(pageable);
    }
}
