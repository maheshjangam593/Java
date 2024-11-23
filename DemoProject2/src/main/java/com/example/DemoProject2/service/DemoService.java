package com.example.DemoProject2.service;

import com.example.DemoProject2.entity.Demo;
import com.example.DemoProject2.entity.DemoDto;
import com.example.DemoProject2.entity.Employe;
import com.example.DemoProject2.exception.DemoNotFoundException;
import com.example.DemoProject2.repo.DemoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepo demoRepo;

    @Autowired
    private ModelMapper modelMapper;

    public DemoDto addDemo(DemoDto demoDto)
    {
        Demo demo = modelMapper.map(demoDto, Demo.class);
        Demo demo1 = demoRepo.save(demo);
        return modelMapper.map(demo1,DemoDto.class);
    }
    public DemoDto getDemo(Integer id)
    {
       // Demo demo = modelMapper.map(demoDto, Demo.class);
        Demo demo = demoRepo.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
        return modelMapper.map(demo,DemoDto.class);
    }

}
