package com.trantan.learn.springboot.controller;

import com.trantan.learn.springboot.model.dtos.NewDTO;
import com.trantan.learn.springboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class NewAPIController {
    @Autowired
    private INewService iNewService;

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return iNewService.save(model);
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@PathVariable("id") Long id, @RequestBody NewDTO model){
        model.setId(id);
        return iNewService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody Set<Long> ids){
        iNewService.delete(ids);
    }
}
