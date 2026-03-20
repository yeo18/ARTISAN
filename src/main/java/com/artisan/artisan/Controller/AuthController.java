package com.artisan.artisan.Controller;

import com.artisan.artisan.Dto.ArtisanCreateDto;
import com.artisan.artisan.Dto.AuthResponseDto;
import com.artisan.artisan.Dto.ClientCreateDto;
import com.artisan.artisan.Dto.LoginRequestDto;
import com.artisan.artisan.Entity.Utilisateur;
import com.artisan.artisan.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/artisan")
    public ResponseEntity<AuthResponseDto> registerArtisan(@Valid @RequestBody ArtisanCreateDto dto) {
        return ResponseEntity.ok(authService.registerArtisan(dto));
    }

    @PostMapping("/register/client")
    public ResponseEntity<AuthResponseDto> registerClient(@Valid @RequestBody ClientCreateDto dto) {
        return ResponseEntity.ok(authService.registerClient(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @GetMapping("/me")
    public ResponseEntity<Utilisateur> getMe() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }
}
