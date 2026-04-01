package com.artisan.artisan.Service.Artisan;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllArtisansService {

    @Autowired
    private ArtisanRepository artisanRepository;

    public List<Artisan> execute() {
        return artisanRepository.findAll();
    }
}
