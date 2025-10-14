package com.kiboro.kiboro_back.api.mapper;


import org.mapstruct.Mapper;

import com.kiboro.kiboro_back.api.dtos.Responses.UsersResponse;
import com.kiboro.kiboro_back.api.dtos.requests.users.CreateUsersRequest;
import com.kiboro.kiboro_back.domain.entity.Users;

@Mapper(componentModel = "spring")
public interface  UsersMapper {

    UsersResponse toResponse(Users user);

    Users toEntityFromCreateRequest(CreateUsersRequest createUsersRequest);

}
