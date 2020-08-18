package com.trantan.learn.springboot.service.impl;

import com.trantan.learn.springboot.converter.NewConverter;
import com.trantan.learn.springboot.model.dtos.NewDTO;
import com.trantan.learn.springboot.model.entities.CategoryEntity;
import com.trantan.learn.springboot.model.entities.NewEntity;
import com.trantan.learn.springboot.repository.CategoryRepository;
import com.trantan.learn.springboot.repository.NewRepository;
import com.trantan.learn.springboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class NewService implements INewService {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity;
        if (newDTO.getId() != null){
            NewEntity oldEntity = newRepository.findFirstById(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldEntity);
        }else {
            newEntity = newConverter.toEntity(newDTO);
        }

        CategoryEntity categoryEntity = categoryRepository.findFirstByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDto(newEntity);
    }

    @Override
    public void delete(Set<Long> ids) {
        newRepository.deleteAllByIdIn(ids);
    }


//    @Override
//    public NewDTO update(NewDTO newDTO) {
//        NewEntity oldNewEntity = newRepository.findFirstById(newDTO.getId());
//        if (oldNewEntity == null){
//            return (NewDTO) ResponseEntity.notFound();
//        }else {
//            CategoryEntity categoryEntity = categoryRepository.findFirstByCode(newDTO.getCategoryCode());
//            NewEntity newEntity = newConverter.toEntity(newDTO, oldNewEntity);
//            newEntity.setCategory(categoryEntity);
//            return newConverter.toDto(newEntity);
//        }
//    }
}
