package com.artisan.artisan.Service;

import com.artisan.artisan.Dto.ClientCreateDto;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private  ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Client create(ClientCreateDto createDto) {
        if (clientRepository.findByEmail(createDto.getEmail()).isPresent()) {
            throw new RuntimeException("Un client avec cet email existe déjà");
        }
        Client newClient = new Client();
        newClient.setEmail(createDto.getEmail());
        newClient.setNom(createDto.getNom());
        newClient.setPrenom(createDto.getPrenom());
        newClient.setLocalisation(createDto.getLocalisation());
        String hash = passwordEncoder.encode(createDto.getMotpasse());
        newClient.setMotpasse(hash);
        return this.clientRepository.save(newClient);
    }
     Client findOne(String email) {

        return this.clientRepository.findByEmail(email).orElse(null);
    }

    public Page<Client> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return this.clientRepository.findAll(pageable);
    }



}