package com.artisan.artisan.Controller.Artisan;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Service.Artisan.GetArtisanDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artisans/details")
public class GetArtisanDetailsController {

    @Autowired
    private GetArtisanDetailsService getArtisanDetailsService;

    @GetMapping("/{id}")
    public Artisan getArtisanDetails(@PathVariable Long id) {
        return getArtisanDetailsService.execute(id);
    }
}
