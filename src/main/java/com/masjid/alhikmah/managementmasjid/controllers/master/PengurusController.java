package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Pengurus;
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
@RequestMapping("/pengurus")
public class PengurusController {

    @Autowired
    private PengurusService pengurusService;

    @GetMapping(value = { "/", "/list" })
    public String listPengurus(ModelMap params) {
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/pengurus/list";
    }

    @GetMapping("/form")
    public String formPengurus(Pengurus pengurus, ModelMap params) {
        params.addAttribute("pengurus", pengurus);
        return "/pages/pengurus/form";
    }

    @GetMapping("/form/{id}")
    public String formPengurusById(@PathVariable("id") String nama_pengurus, ModelMap params,
            RedirectAttributes redirectAttrs) {
        Optional<Pengurus> pengurus = pengurusService.findById(nama_pengurus);
        if (pengurus != null) {
            params.addAttribute("pengurus", pengurus);
            return "/pages/pengurus/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/pengurus/list";
        }
    }

    @PostMapping("/submit")
    public String submitPengurus(@Valid @ModelAttribute Pengurus pengurus, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        pengurus.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        pengurus.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/pengurus/form";
        }

        pengurusService.save(pengurus);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/pengurus/list";

    }

    @GetMapping("/hapus/{id}")
    public String removePengurusId(@PathVariable("id") String nama_pengurus) {
        pengurusService.delete(nama_pengurus);
        return "redirect:/pengurus/list";
    }

}
