package com.artisan.artisan.Repository;
import com.artisan.artisan.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
