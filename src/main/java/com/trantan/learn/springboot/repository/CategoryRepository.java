package com.trantan.learn.springboot.repository;

import com.trantan.learn.springboot.model.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findFirstByCode(String code);
}
