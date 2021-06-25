package com.masjid.alhikmah.managementmasjid.controllers.master;

import com.masjid.alhikmah.managementmasjid.models.master.Imam;
import com.masjid.alhikmah.managementmasjid.services.PengurusService;
import com.masjid.alhikmah.managementmasjid.services.ImamService;
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
@RequestMapping("/imam")
public class ImamController {

    @Autowired
    private ImamService imamServices;
    private PengurusService pengurusService;

    @GetMapping(value = {"/", "/list"})
    public String listimam(ModelMap params) {
        params.addAttribute("listimam", imamServices.getimam());
        params.addAttribute("listPengurus", pengurusService.getPengurus());
        return "/pages/imam/list";
    }

    @GetMapping("/form")
    public String formimam(Imam imam, ModelMap params) {
        params.addAttribute("imam", imam);
        return "/pages/imam/form";
    }

    @GetMapping("/form/{id}")
    public String formimamById(@PathVariable("id") String nama_imam, ModelMap params, RedirectAttributes redirectAttrs) {
        Optional<Imam> imam = imamServices.findById(nama_imam);
        if (imam != null) {
            params.addAttribute("imam", imam);
            return "/pages/imam/form";
        } else {
            redirectAttrs.addFlashAttribute("notAvailabel", "Data Tidak ditemukan");
            return "redirect:/imam/list";
        }
    }

    @PostMapping("/submit")
    public String submitimam(@Valid @ModelAttribute Imam imam,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        imam.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        imam.setCreatedBy("admin");

        if (bindingResult.hasErrors()) {
            return "pages/imam/form";
        }

        imamServices.save(imam);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/imam/list";

    }

    @GetMapping("/hapus/{id}")
    public String removeimamId(@PathVariable("id") String nama_imam) {
        imamServices.delete(nama_imam);
        return "redirect:/imam/list";
    }
}
