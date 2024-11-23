package com.example.DemoProject2.controller;

import com.example.DemoProject2.entity.DemoDto;
import com.example.DemoProject2.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/addDemo")
    public DemoDto addDemo(@RequestBody DemoDto demoDto)
    {
        return demoService.addDemo(demoDto);
    }
    @GetMapping ("/getDemo/{id}")
    public DemoDto addDemo(@PathVariable Integer id)
    {
        return demoService.getDemo(id);

    }
}
