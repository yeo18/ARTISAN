package com.artisan.artisan.Repository;

import com.artisan.artisan.Entity.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    Optional<Artisan>findByEmail(String email);
    java.util.List<Artisan> findByMetierId(Long metierId);
    java.util.List<Artisan> findByCommuneIgnoreCase(String commune);
    java.util.List<Artisan> findByMetierIdAndCommuneIgnoreCase(Long metierId, String commune);
}
