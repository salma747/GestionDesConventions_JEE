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
import tn.iit.jee.models.Participant;
import tn.iit.jee.services.ConventionService;
import tn.iit.jee.services.ParticipantService;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ConventionService conventionService;

    @Autowired
    private ParticipantService participantService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Convention> listConventions = conventionService.listAll();
        model.addAttribute("listConventions", listConventions);
        model.addAttribute("participantService", participantService);

        return "index";
    }

    @RequestMapping("/new-convention")
    public String showNewConventionForm(Model model) {
        Convention convention = new Convention();
        model.addAttribute("convention", convention);
        return "new-convention";
    }

    @RequestMapping(value = "/save-convention", method = RequestMethod.POST)
    public String saveConvention(@ModelAttribute("convention") Convention convention) {
        conventionService.save(convention);
        return "redirect:/";
    }

    @RequestMapping("/update-convention/{id}")
    public ModelAndView showUpdateConventionForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update-convention");
        Convention convention = conventionService.get(id);

       modelAndView.addObject("convention" , convention);
        return modelAndView;
    }

    @RequestMapping("/delete-convention/{id}")
    public String deleteConvention(@PathVariable(name = "id") Long id) {
        conventionService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/new-participant")
    public String showNewParticipantForm(Model model) {
        Participant participant = new Participant();
        model.addAttribute("participant", participant);
        return "new-participant";
    }

    @RequestMapping(value = "/save-participant", method = RequestMethod.POST)
    public String saveParticipant(@ModelAttribute("participant") Participant participant) {
        participantService.save(participant);
        return "redirect:/";
    }

}
