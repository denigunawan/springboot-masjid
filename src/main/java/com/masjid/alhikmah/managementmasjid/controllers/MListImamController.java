package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListImamModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListImamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class MListImamController {

    @Autowired
    private MListImamServices imamServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("imam")
    public String getImamList(Model model) {
        model.addAttribute("imam", imamServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "imam";
    }

    @PostMapping("imam/add")
    public String add(MListImamModels listimam) {
        imamServices.save(listimam);
        return "redirect:/imam";
    }

    @RequestMapping("imam/findById")
    @ResponseBody
    public Optional<MListImamModels> findById(String imam_id) {
        return imamServices.findById(imam_id);
    }

    @RequestMapping(value = "imam/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListImamModels imam_id) {
        imamServices.save(imam_id);
        return "redirect:/imam";
    }

    @RequestMapping(value = "imam/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String imam_id) {
        imamServices.deleteById(imam_id);
        return "redirect:/imam";
    }
}
