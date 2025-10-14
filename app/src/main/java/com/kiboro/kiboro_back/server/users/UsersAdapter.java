package com.kiboro.kiboro_back.server.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kiboro.kiboro_back.domain.entity.Users;
import com.kiboro.kiboro_back.server.Repository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersAdapter implements Repository<Users, Long> {

    private final UsersRepository usersRepositoty;

    public Optional<Users> findByUsername(String username) {
        return usersRepositoty.findByUsername(username);
    }

    @Override
    public Users save(Users o) {
        return usersRepositoty.save(o);
    }

    @Override
    public List<Users> saveAll(List<Users> o) {
        return o.stream().map(this::save).toList();
    }

    @Override
    public Optional<Users> findById(Long aLong) {
        return usersRepositoty.findById(aLong);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return usersRepositoty.findAll(pageable);
    }

    @Override
    public List<Users> findAllById(List<Long> longs) {
        return usersRepositoty.findAllById(longs);
    }

    @Override
    public void remove(Users o) {
        usersRepositoty.delete(o);
    }

    @Override
    public void removeById(Long aLong) {
        usersRepositoty.deleteById(aLong);
    }

}