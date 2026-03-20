package com.artisan.artisan.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Service.ArtisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artisans")
public class ArtisanController {

    @Autowired
    private ArtisanService artisanService;

    @GetMapping
    public Page<Artisan> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return artisanService.findAll(page, size);
    }

    @GetMapping("/{email}")
    public Artisan getOne(@PathVariable String email) {
        return artisanService.findOne(email);
    }

    @PreAuthorize("hasRole('ARTISAN')")
    @PutMapping("/profile")
    public Artisan updateProfile(@RequestBody Artisan artisan) {
        // Implementation logic for updating profile would go here
        return artisan; 
    }
}
