package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListBilalModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListBilalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MListBilalController {

    @Autowired
    private MListBilalServices bilalServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("bilal")
    public String getBilalList(Model model) {
        model.addAttribute("bilal", bilalServices.getBilal());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "bilal";
    }

    @PostMapping("bilal/add")
    public String add(MListBilalModels listBilal) {
        bilalServices.saveBilal(listBilal);
        return "redirect:/bilal";
    }

    @RequestMapping("bilal/findById")
    @ResponseBody
    public Optional<MListBilalModels> findById(String bilal_id) {
        return bilalServices.findById(bilal_id);
    }

    @RequestMapping(value = "bilal/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListBilalModels bilal_id) {
        bilalServices.saveBilal(bilal_id);
        return "redirect:/bilal";
    }

    @RequestMapping(value = "bilal/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String bilal_id) {
        bilalServices.delete(bilal_id);
        return "redirect:/bilal";
    }
}
