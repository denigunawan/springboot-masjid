package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Khotib;
import com.masjid.alhikmah.managementmasjid.services.KhotibService;
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
@RequestMapping("/khotib")
public class KhotibController {

    @Autowired
    private KhotibService khotibServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listkhotib(ModelMap params) {
        params.addAttribute("listkhotib", khotibServices.getKhotib());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/khotib/list";
    }

    @GetMapping("/form")
    public String formkhotib(Khotib khotib, ModelMap params) {
        params.addAttribute("khotib", khotib);
        return "/pages/khotib/form";
    }

    @GetMapping("/form/{id}")
    public String formkhotibById(@PathVariable("id") String nama_khotib, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Khotib> khotib = khotibServices.findById(nama_khotib);
        if (khotib != null) {
            params.addAttribute("khotib", khotib);
            return "/pages/khotib/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/khotib/list";
        }
    }

    @PostMapping("/submit")
    public String submitkhotib(@Valid @ModelAttribute Khotib khotib,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        khotib.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        khotib.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/khotib/form";
        }

        khotibServices.save(khotib);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/khotib/list";

    }

    @GetMapping("/hapus/{id}")
    public String removekhotibId(@PathVariable("id") String nama_khotib) {
        khotibServices.delete(nama_khotib);
        return "redirect:/khotib/list";
    }
}
