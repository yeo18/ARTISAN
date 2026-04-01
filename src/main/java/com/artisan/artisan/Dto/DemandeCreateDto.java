package com.artisan.artisan.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DemandeCreateDto {
    private LocalDate date_rendez_vous;
    private LocalDate heure;
    private String description_travail;
    private Long clientId;
}
