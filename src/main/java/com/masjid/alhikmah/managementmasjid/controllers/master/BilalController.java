package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Bilal;
import com.masjid.alhikmah.managementmasjid.services.BilalService;
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
@RequestMapping("/bilal")
public class BilalController {

    @Autowired
    private BilalService bilalServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listBilal(ModelMap params) {
        params.addAttribute("listBilal", bilalServices.getBilal());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/bilal/list";
    }

    @GetMapping("/form")
    public String formBilal(Bilal bilal, ModelMap params) {
        params.addAttribute("bilal", bilal);
        return "/pages/bilal/form";
    }

    @GetMapping("/form/{id}")
    public String formBilalById(@PathVariable("id") String nama_bilal, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Bilal> bilal = bilalServices.findById(nama_bilal);
        if (bilal != null) {
            params.addAttribute("bilal", bilal);
            return "/pages/bilal/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/bilal/list";
        }
    }

    @PostMapping("/submit")
    public String submitBilal(@Valid @ModelAttribute Bilal bilal,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        bilal.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        bilal.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/bilal/form";
        }

        bilalServices.save(bilal);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/bilal/list";

    }

    @GetMapping("/hapus/{id}")
    public String removeBilalId(@PathVariable("id") String nama_bilal) {
        bilalServices.delete(nama_bilal);
        return "redirect:/bilal/list";
    }

}
