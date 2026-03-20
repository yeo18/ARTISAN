package com.artisan.artisan.Repository;

import com.artisan.artisan.Entity.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    Optional<Artisan>findByEmail(String email);
}
