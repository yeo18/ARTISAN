package com.artisan.artisan.Repository;
import com.artisan.artisan.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
}
