package com.masjid.alhikmah.managementmasjid.controllers.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {


    @GetMapping("/")
    public String getDashboard(){
        return "/layout/dashboard";
    }
}
