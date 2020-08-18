package com.trantan.learn.springboot.repository;

import com.trantan.learn.springboot.model.entities.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long>{
    NewEntity findFirstById(Long id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Long> ids);
}
