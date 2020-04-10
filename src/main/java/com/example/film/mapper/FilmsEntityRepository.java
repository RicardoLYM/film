package com.example.film.mapper;

import com.example.film.pojo.FilmsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsEntityRepository extends JpaRepository<FilmsEntity,Long> {

    //JPA分页操作
    @Override
    Page<FilmsEntity> findAll(Pageable pageable);
}
