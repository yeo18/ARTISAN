package com.artisan.artisan.Repository;

import com.artisan.artisan.Entity.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
}
