package com.artisan.artisan.Repository;

import com.artisan.artisan.Entity.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetierRepository extends JpaRepository<Metier, Integer> {
}
