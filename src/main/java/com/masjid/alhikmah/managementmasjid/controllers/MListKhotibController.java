package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListKhotibModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListKhotibServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MListKhotibController {

    @Autowired
    private MListKhotibServices khotibServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("khotib")
    public String getkhotibList(Model model) {
        model.addAttribute("khotib", khotibServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "khotib";
    }

    @PostMapping("khotib/add")
    public String add(MListKhotibModels listkhotib) {
        khotibServices.save(listkhotib);
        return "redirect:/khotib";
    }

    @RequestMapping("khotib/findById")
    @ResponseBody
    public Optional<MListKhotibModels> findById(String khotib_id) {
        return khotibServices.findById(khotib_id);
    }

    @RequestMapping(value = "khotib/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListKhotibModels khotib_id) {
        khotibServices.save(khotib_id);
        return "redirect:/khotib";
    }

    @RequestMapping(value = "khotib/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String khotib_id) {
        khotibServices.deleteById(khotib_id);
        return "redirect:/khotib";
    }
}
