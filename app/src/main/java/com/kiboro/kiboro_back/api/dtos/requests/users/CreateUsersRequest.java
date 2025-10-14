package com.kiboro.kiboro_back.api.dtos.requests.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUsersRequest(
 @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit contenir entre 3 et 50 caractères")
    String username,
    
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @Size(max = 100, message = "L'email ne peut pas dépasser 100 caractères")
    String email,
    
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, max = 255, message = "Le mot de passe doit contenir entre 6 et 255 caractères")
    String password,
    
    @Size(max = 50, message = "Le prénom ne peut pas dépasser 50 caractères")
    String firstName,
    
    @Size(max = 50, message = "Le nom ne peut pas dépasser 50 caractères")
    String lastName
){}