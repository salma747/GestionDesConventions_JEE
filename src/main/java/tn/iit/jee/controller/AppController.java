package tn.iit.jee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
