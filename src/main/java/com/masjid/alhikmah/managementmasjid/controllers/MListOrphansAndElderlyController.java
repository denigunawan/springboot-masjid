package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListOrphansAndElderlyModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListOrphansAndElderlyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MListOrphansAndElderlyController {

    @Autowired
    private MListOrphansAndElderlyServices orphansServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("orphans")
    public String getorphansList(Model model) {
        model.addAttribute("orphans", orphansServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "orphans";
    }

    @PostMapping("orphans/add")
    public String add(MListOrphansAndElderlyModels listOrphans) {
        orphansServices.save(listOrphans);
        return "redirect:/orphans";
    }

    @RequestMapping("orphans/findById")
    @ResponseBody
    public Optional<MListOrphansAndElderlyModels> findById(String oae_id) {
        return orphansServices.findById(oae_id);
    }

    @RequestMapping(value = "orphans/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListOrphansAndElderlyModels oae_id) {
        orphansServices.save(oae_id);
        return "redirect:/orphans";
    }

    @RequestMapping(value = "orphans/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String oae_id) {
        orphansServices.deleteById(oae_id);
        return "redirect:/orphans";
    }

}
