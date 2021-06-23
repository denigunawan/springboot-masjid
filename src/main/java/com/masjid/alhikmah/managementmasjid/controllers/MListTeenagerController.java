package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListTeenagerModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListTeenagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MListTeenagerController {

    @Autowired
    private MListTeenagerServices teenagerServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("teenager")
    public String getTeenagerList(Model model) {
        model.addAttribute("teenager", teenagerServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "teenager";
    }

    @PostMapping("teenager/add")
    public String add(MListTeenagerModels listTeenager) {
        teenagerServices.save(listTeenager);
        return "redirect:/teenager";
    }

    @RequestMapping("teenager/findById")
    @ResponseBody
    public Optional<MListTeenagerModels> findById(String teenager_id) {
        return teenagerServices.findById(teenager_id);
    }

    @RequestMapping(value = "teenager/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListTeenagerModels teenager_id) {
        teenagerServices.save(teenager_id);
        return "redirect:/teenager";
    }

    @RequestMapping(value = "teenager/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String teenager_id) {
        teenagerServices.deleteById(teenager_id);
        return "redirect:/teenager";
    }
}
