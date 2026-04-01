package com.artisan.artisan.Controller.Artisan;

import com.artisan.artisan.Dto.FilterArtisansDto;
import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Service.Artisan.FilterArtisansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artisans/filter")
public class FilterArtisansController {

    @Autowired
    private FilterArtisansService filterArtisansService;

    @PostMapping
    public List<Artisan> filterArtisans(@RequestBody FilterArtisansDto dto) {
        return filterArtisansService.execute(dto);
    }
}
