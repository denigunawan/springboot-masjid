package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Muazin;
import com.masjid.alhikmah.managementmasjid.services.MuazinService;
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
@RequestMapping("/muazin")
public class MuazinController {


    @Autowired
    private MuazinService muazinServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listmuazin(ModelMap params) {
        params.addAttribute("listmuazin", muazinServices.getMuazin());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/muazin/list";
    }

    @GetMapping("/form")
    public String formmuazin(Muazin muazin, ModelMap params) {
        params.addAttribute("muazin", muazin);
        return "/pages/muazin/form";
    }

    @GetMapping("/form/{id}")
    public String formmuazinById(@PathVariable("id") String nama_muazin, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Muazin> muazin = muazinServices.findById(nama_muazin);
        if (muazin != null) {
            params.addAttribute("muazin", muazin);
            return "/pages/muazin/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/muazin/list";
        }
    }

    @PostMapping("/submit")
    public String submitmuazin(@Valid @ModelAttribute Muazin muazin,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        muazin.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        muazin.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/muazin/form";
        }

        muazinServices.save(muazin);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/muazin/list";

    }

    @GetMapping("/hapus/{id}")
    public String removemuazinId(@PathVariable("id") String nama_muazin) {
        muazinServices.delete(nama_muazin);
        return "redirect:/muazin/list";
    }
}
