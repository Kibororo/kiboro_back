package com.kiboro.kiboro_back.domain;

import org.springframework.stereotype.Service;

import com.kiboro.kiboro_back.api.dtos.requests.users.CreateUsersRequest;
import com.kiboro.kiboro_back.api.mapper.UsersMapper;
import com.kiboro.kiboro_back.domain.Exeptions.TechnicalException;
import com.kiboro.kiboro_back.domain.entity.Users;
import com.kiboro.kiboro_back.server.users.UsersAdapter;

import lombok.RequiredArgsConstructor;
import static com.kiboro.kiboro_back.domain.enums.TechnicalExceptionEnum.NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UsersService {

      private final UsersAdapter usersAdapter;
      private final UsersMapper usersMapper;

      
    public Users createUser( CreateUsersRequest createUserRequest) throws TechnicalException {
        Users user = usersAdapter.save(UsersMapper.toEntityFromCreateRequest(createUserRequest));
        return user;
    }

       public Users getOne(Long idUser) throws TechnicalException {
        return usersAdapter.findById(idUser)
                .orElseThrow(() -> new TechnicalException(NOT_FOUND));
    }


}
