package tn.iit.jee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
    public String showNewConventionForm(Model model) {
        Convention convention = new Convention();

        model.addAttribute("convention", convention);
        return "ajout_convention";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveConvention(@ModelAttribute("convention") Convention convention) {
        conventionService.save(convention);
        return "redirect:/";
    }

    @RequestMapping("/edit-convention/{id}")
    public ModelAndView showEditConventionForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_convention");
        Convention convention = conventionService.get(id);

       modelAndView.addObject("convention" , convention);
        return modelAndView;
    }

    @RequestMapping("/delete-convention/{id}")
    public String deleteConvention(@PathVariable(name = "id") Long id) {
        conventionService.delete(id);
        return "redirect:/";
    }

}
