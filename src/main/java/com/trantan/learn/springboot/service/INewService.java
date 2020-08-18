package com.trantan.learn.springboot.service;

import com.trantan.learn.springboot.model.dtos.NewDTO;

import java.util.List;
import java.util.Set;

public interface INewService {
    NewDTO save(NewDTO newDTO);
//    NewDTO update(NewDTO newDTO);
    void delete(Set<Long> ids);
}
