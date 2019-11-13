package com.example.film.mapper;

import com.example.film.pojo.UsertestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsertestEntityRepository extends JpaRepository<UsertestEntity,Long> {

    UsertestEntity findByUid(int uid);
    //JPA 分页操作
    Page<UsertestEntity> findAll(Pageable pageable);
}
