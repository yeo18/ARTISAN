package com.artisan.artisan.Repository;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Entity.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Client, Long> {
}
