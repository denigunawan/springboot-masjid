package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.YatimDanDhuafa;
import com.masjid.alhikmah.managementmasjid.services.PengurusService;
import com.masjid.alhikmah.managementmasjid.services.YatimDanDhuafaService;
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
@RequestMapping("/yatimdanhuafa")
public class YatimDanDhuafaController {

    @Autowired
    private YatimDanDhuafaService yatimDanDhuafaServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listyatimDanDhuafa(ModelMap params) {
        params.addAttribute("listyatimDanDhuafa", yatimDanDhuafaServices.getYatimDanDhuafa());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/yatimDanDhuafa/list";
    }

    @GetMapping("/form")
    public String formyatimDanDhuafa(YatimDanDhuafa yatimDanDhuafa, ModelMap params) {
        params.addAttribute("yatimDanDhuafa", yatimDanDhuafa);
        return "/pages/yatimDanDhuafa/form";
    }

    @GetMapping("/form/{id}")
    public String formyatimDanDhuafaById(@PathVariable("id") String nama_yatimdandhuafa, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<YatimDanDhuafa> yatimDanDhuafa = yatimDanDhuafaServices.findById(nama_yatimdandhuafa);
        if (yatimDanDhuafa != null) {
            params.addAttribute("yatimDanDhuafa", yatimDanDhuafa);
            return "/pages/yatimDanDhuafa/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/yatimDanDhuafa/list";
        }
    }

    @PostMapping("/submit")
    public String submityatimDanDhuafa(@Valid @ModelAttribute YatimDanDhuafa yatimDanDhuafa,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        yatimDanDhuafa.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        yatimDanDhuafa.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/yatimDanDhuafa/form";
        }

        yatimDanDhuafaServices.save(yatimDanDhuafa);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/yatimDanDhuafa/list";

    }

    @GetMapping("/hapus/{id}")
    public String removeyatimDanDhuafaId(@PathVariable("id") String nama_yatimdandhuafa) {
        yatimDanDhuafaServices.delete(nama_yatimdandhuafa);
        return "redirect:/yatimDanDhuafa/list";
    }
}
