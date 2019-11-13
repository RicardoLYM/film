package com.example.film.service;

import com.example.film.mapper.UsertestEntityRepository;
import com.example.film.pojo.UsertestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsertestService2Impl implements UsertestService2 {

    @Autowired
    UsertestEntityRepository usertestEntityRepository;

    @Override
    public UsertestEntity findUserByUid(int uid) {
        return usertestEntityRepository.findByUid(uid);
    }

    @Override
    public Page<UsertestEntity> findAll(Pageable pageable) {
        return usertestEntityRepository.findAll(pageable);
    }
}
