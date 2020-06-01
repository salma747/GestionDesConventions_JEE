package tn.iit.jee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tn.iit.jee.models.Convention;
import tn.iit.jee.services.ConventionService;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ConventionService conventionService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Convention> listConventions = conventionService.listAll();
        model.addAttribute("listConventions", listConventions);

        return "index";
    }

    @RequestMapping("/new-convention")
    public String shownewConventionForm(Model model) {
        Convention convention = new Convention();

        model.addAttribute("convention", convention);
        return "ajout_convention";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveConvention(@ModelAttribute("convention") Convention convention) {
        conventionService.save(convention);
        return "redirect:/";
    }

}
