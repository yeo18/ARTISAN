package com.artisan.artisan.Service.Artisan;

import com.artisan.artisan.Dto.FilterArtisansDto;
import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilterArtisansService {

    @Autowired
    private ArtisanRepository artisanRepository;

    public List<Artisan> execute(FilterArtisansDto dto) {
        if (dto.getMetierId() != null && dto.getCommune() != null && !dto.getCommune().trim().isEmpty()) {
            return artisanRepository.findByMetierIdAndCommuneIgnoreCase(dto.getMetierId(), dto.getCommune().trim());
        } else if (dto.getMetierId() != null) {
            return artisanRepository.findByMetierId(dto.getMetierId());
        } else if (dto.getCommune() != null && !dto.getCommune().trim().isEmpty()) {
            return artisanRepository.findByCommuneIgnoreCase(dto.getCommune().trim());
        }
        return artisanRepository.findAll();
    }
}
