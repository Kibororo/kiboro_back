package com.kiboro.kiboro_back.api.dtos.Responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record UsersResponse(Long id, String username, String email, String firstName, String lastName) {

}
