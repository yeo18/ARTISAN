package com.artisan.artisan.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Client> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return clientService.findAll(page, size);
    }

    @GetMapping("/profile")
    public Client getProfile() {
        // Logic to get current client profile
        return null; 
    }
}
