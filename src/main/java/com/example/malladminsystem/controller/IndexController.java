package com.example.malladminsystem.controller;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class IndexController {

    @GetMapping("/api/v1")
    public String getIndex() {
        return "index";
    }

    @GetMapping()
    public String redirectToIndex() {
        return "redirect:/api/v1";
    }
}
