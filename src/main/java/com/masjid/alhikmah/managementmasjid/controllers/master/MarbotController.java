package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Marbot;
import com.masjid.alhikmah.managementmasjid.services.MarbotService;
import com.masjid.alhikmah.managementmasjid.services.PengurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/marbot")
public class MarbotController {

    @Autowired
    private MarbotService marbotServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listmarbot(ModelMap params) {
        params.addAttribute("listmarbot", marbotServices.getMarbot());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/marbot/list";
    }

    @GetMapping("/form")
    public String formmarbot(Marbot marbot, ModelMap params) {
        params.addAttribute("marbot", marbot);
        return "/pages/marbot/form";
    }

    @GetMapping("/form/{id}")
    public String formmarbotById(@PathVariable("id") String nama_marbot, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Marbot> marbot = marbotServices.findById(nama_marbot);
        if (marbot != null) {
            params.addAttribute("marbot", marbot);
            return "/pages/marbot/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/marbot/list";
        }
    }

    @PostMapping("/submit")
    public String submitmarbot(@Valid @ModelAttribute Marbot marbot,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        marbot.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        marbot.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/marbot/form";
        }

        marbotServices.save(marbot);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/marbot/list";

    }

    @GetMapping("/hapus/{id}")
    public String removemarbotId(@PathVariable("id") String nama_marbot) {
        marbotServices.delete(nama_marbot);
        return "redirect:/marbot/list";
    }
}
