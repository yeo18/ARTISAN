package com.artisan.artisan.Controller.Artisan;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Service.Artisan.GetAllArtisansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artisans/all")
public class GetAllArtisansController {

    @Autowired
    private GetAllArtisansService getAllArtisansService;

    @GetMapping
    public List<Artisan> getAllArtisans() {
        return getAllArtisansService.execute();
    }
}
