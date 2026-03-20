package com.artisan.artisan.Service;

import com.artisan.artisan.Dto.ArtisanCreateDto;
import com.artisan.artisan.Dto.AuthResponseDto;
import com.artisan.artisan.Dto.ClientCreateDto;
import com.artisan.artisan.Dto.LoginRequestDto;
import com.artisan.artisan.Entity.Artisan;
import com.artisan.artisan.Entity.Client;
import com.artisan.artisan.Entity.Utilisateur;
import com.artisan.artisan.Repository.UtilisateurRepository;
import com.artisan.artisan.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ArtisanService artisanService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponseDto registerArtisan(ArtisanCreateDto dto) {
        Artisan artisan = artisanService.create(dto);
        String token = jwtUtil.generateToken(artisan.getEmail());
        return new AuthResponseDto(token, artisan);
    }

    public AuthResponseDto registerClient(ClientCreateDto dto) {
        Client client = clientService.create(dto);
        String token = jwtUtil.generateToken(client.getEmail());
        return new AuthResponseDto(token, client);
    }

    public AuthResponseDto login(LoginRequestDto dto) {
        Utilisateur user = utilisateurRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Identifiants incorrects"));

        if (!passwordEncoder.matches(dto.getMotpasse(), user.getMotpasse())) {
            throw new RuntimeException("Identifiants incorrects");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponseDto(token, user);
    }

    public Utilisateur getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return utilisateurRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
}
