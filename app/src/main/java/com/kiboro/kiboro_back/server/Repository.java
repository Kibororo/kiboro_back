package com.kiboro.kiboro_back.server;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface Repository<E, ID> {

    E save(E o);

    List<E> saveAll(List<E> o);

    Optional<E> findById(ID id);

    Page<E> findAll(Pageable pageable);

    List<E> findAllById(List<ID> ids);

    void remove(E o);

    void removeById(ID id);
}