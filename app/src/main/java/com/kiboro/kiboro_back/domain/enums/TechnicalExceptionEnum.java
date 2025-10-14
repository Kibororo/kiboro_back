package com.kiboro.kiboro_back.domain.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TechnicalExceptionEnum {
    NOT_FOUND("NOT_FOUND", "Élément introuvable.", HttpStatus.NOT_FOUND),
    BAD_REQUEST("BAD_REQUEST", "Champ(s) manquant(s).", HttpStatus.BAD_REQUEST),
    NO_SUCH_ELEMENT("NO_SUCH_ELEMENT", "Ce type n'existe pas", HttpStatus.METHOD_NOT_ALLOWED),
    PARTNER_ERROR("PARTNER_ERROR", "Une erreur est survenue lors de l'envoie du fichier", HttpStatus.INTERNAL_SERVER_ERROR),
    TOKEN_INVALID("TOKEN_INVALID", "Échec de le récupération de vos informations de connection", HttpStatus.UNAUTHORIZED),
    PDF_GENERATION("PDF_GENERATION", "Une erreur est survenue lors de la géneration du PDF", HttpStatus.INTERNAL_SERVER_ERROR),
    MAILING_TEMPLATING("MAILING_TEMPLATING", "Une erreur est survenue lors de la mise en place de l'email", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_SIZE("FILE_SIZE", "La taille du fichier ne doit pas dépasser 2Mb", HttpStatus.PAYLOAD_TOO_LARGE),
    MISSING_DELIVERY_PROOF("MISSING_DELIVERY_PROOF", "Preuve de livraison absente. Vous ne pouvez pas terminé cette course.", HttpStatus.BAD_REQUEST),
    TOKEN_EXPIRED("TOKEN_EXPIRED", "Votre session à expirer, veuillez vous reconnecter.", HttpStatus.UNAUTHORIZED),
    REF_NOT_FOUND("REF_NOT_FOUND", "Ce code postal n'est pas répertorié.", HttpStatus.BAD_REQUEST);

    private final String title;
    private final String message;
    private final HttpStatus status;

    TechnicalExceptionEnum(String title, String message, HttpStatus status) {
        this.title = title;
        this.message = message;
        this.status = status;
    }
}