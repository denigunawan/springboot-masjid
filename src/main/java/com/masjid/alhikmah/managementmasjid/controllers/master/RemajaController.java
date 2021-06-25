package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Remaja;
import com.masjid.alhikmah.managementmasjid.services.PengurusService;
import com.masjid.alhikmah.managementmasjid.services.RemajaService;
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
@RequestMapping("/remaja")

public class RemajaController {

    @Autowired
    private RemajaService remajaServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listremaja(ModelMap params) {
        params.addAttribute("listremaja", remajaServices.getRemaja());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/remaja/list";
    }

    @GetMapping("/form")
    public String formremaja(Remaja remaja, ModelMap params) {
        params.addAttribute("remaja", remaja);
        return "/pages/remaja/form";
    }

    @GetMapping("/form/{id}")
    public String formremajaById(@PathVariable("id") String nama_remaja, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Remaja> remaja = remajaServices.findById(nama_remaja);
        if (remaja != null) {
            params.addAttribute("remaja", remaja);
            return "/pages/remaja/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/remaja/list";
        }
    }

    @PostMapping("/submit")
    public String submitremaja(@Valid @ModelAttribute Remaja remaja,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        remaja.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        remaja.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/remaja/form";
        }

        remajaServices.save(remaja);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/remaja/list";

    }

    @GetMapping("/hapus/{id}")
    public String removeremajaId(@PathVariable("id") String nama_remaja) {
        remajaServices.delete(nama_remaja);
        return "redirect:/remaja/list";
    }
}
