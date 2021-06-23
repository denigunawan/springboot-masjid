package com.masjid.alhikmah.managementmasjid.controllers;

import com.masjid.alhikmah.managementmasjid.models.MListMarbotModels;
import com.masjid.alhikmah.managementmasjid.services.MListAdministratorServices;
import com.masjid.alhikmah.managementmasjid.services.MListMarbotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MListMarbotController {

    @Autowired
    private MListMarbotServices marbotServices;
    private MListAdministratorServices administratorServices;

    @GetMapping("marbot")
    public String getmarbotList(Model model) {
        model.addAttribute("marbot", marbotServices.getAll());
        model.addAttribute("administrator", administratorServices.getAdministrators());

        return "marbot";
    }

    @PostMapping("marbot/add")
    public String add(MListMarbotModels listmarbot) {
        marbotServices.save(listmarbot);
        return "redirect:/marbot";
    }

    @RequestMapping("marbot/findById")
    @ResponseBody
    public Optional<MListMarbotModels> findById(String marbot_id) {
        return marbotServices.findById(marbot_id);
    }

    @RequestMapping(value = "marbot/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(MListMarbotModels marbot_id) {
        marbotServices.save(marbot_id);
        return "redirect:/marbot";
    }

    @RequestMapping(value = "marbot/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(String marbot_id) {
        marbotServices.deleteById(marbot_id);
        return "redirect:/marbot";
    }
}
