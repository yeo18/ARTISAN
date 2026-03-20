package com.artisan.artisan.Dto;

import com.artisan.artisan.Entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
    private Utilisateur user;
}
