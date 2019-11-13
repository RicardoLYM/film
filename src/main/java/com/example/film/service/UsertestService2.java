package com.example.film.service;


import com.example.film.pojo.UsertestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 测试JPA方法
 */
public interface UsertestService2 {

    UsertestEntity findUserByUid(int uid);
    Page<UsertestEntity> findAll(Pageable pageable);
}
