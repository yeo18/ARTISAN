package com.artisan.artisan.Service.Artisan;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetArtisanDetailsService {

    @Autowired
    private ArtisanRepository artisanRepository;

    public Artisan execute(Long id) {
        return artisanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artisan non trouvé"));
    }
}
