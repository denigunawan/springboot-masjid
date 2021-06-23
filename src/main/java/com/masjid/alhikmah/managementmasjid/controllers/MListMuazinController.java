package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListMuazinModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListMuazinServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MListMuazinController {


    @Autowired
    private MListMuazinServices muazinServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("muazin")
    public String getmuazinList(Model model) {
        model.addAttribute("muazin", muazinServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "muazin";
    }

    @PostMapping("muazin/add")
    public String add(MListMuazinModels listmuazin) {
        muazinServices.save(listmuazin);
        return "redirect:/muazin";
    }

    @RequestMapping("muazin/findById")
    @ResponseBody
    public Optional<MListMuazinModels> findById(String muazin_id) {
        return muazinServices.findById(muazin_id);
    }

    @RequestMapping(value = "muazin/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListMuazinModels muazin_id) {
        muazinServices.save(muazin_id);
        return "redirect:/muazin";
    }

    @RequestMapping(value = "muazin/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String muazin_id) {
        muazinServices.deleteById(muazin_id);
        return "redirect:/muazin";
    }

}
