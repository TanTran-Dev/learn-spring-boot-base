package com.trantan.learn.springboot.converter;

import com.trantan.learn.springboot.model.dtos.NewDTO;
import com.trantan.learn.springboot.model.entities.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewEntity toEntity(NewDTO newDTO){
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setContent(newDTO.getContent());
        newEntity.setShortDescription(newDTO.getShortDescription());
        newEntity.setThumbnail(newDTO.getThumbnail());

        return newEntity;
    }

    public NewDTO toDto(NewEntity newEntity){
        NewDTO newDTO = new NewDTO();
        if (newEntity.getId() != null){
            newDTO.setId(newEntity.getId());
        }
        newDTO.setTitle(newEntity.getTitle());
        newDTO.setContent(newEntity.getContent());
        newDTO.setShortDescription(newEntity.getShortDescription());
        newDTO.setThumbnail(newEntity.getThumbnail());
        newDTO.setCreatedDate(newEntity.getCreatedDate());
        newDTO.setCreatedBy(newEntity.getCreatedBy());
        newDTO.setModifiedDate(newEntity.getModifiedDate());
        newDTO.setModifiedBy(newEntity.getModifiedBy());
        return newDTO;
    }

    public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity){
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setContent(newDTO.getContent());
        newEntity.setShortDescription(newDTO.getShortDescription());
        newEntity.setThumbnail(newDTO.getThumbnail());

        return newEntity;
    }
}
