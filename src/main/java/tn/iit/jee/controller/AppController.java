package tn.iit.jee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.iit.jee.models.Convention;
import tn.iit.jee.models.Participant;
import tn.iit.jee.models.ResearchForm;
import tn.iit.jee.models.User;
import tn.iit.jee.services.ConventionService;
import tn.iit.jee.services.ParticipantService;
import tn.iit.jee.services.TypeService;
import tn.iit.jee.services.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ConventionService conventionService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private TypeService typeService;
    public static List<Convention> conventionList = new ArrayList<>();
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/conventions")
    public String viewHomePage(Model model, ResearchForm researchForm) {
        if(researchForm.getObjet()==null)
            researchForm.setObjet("");
        if (researchForm.getType() == 0 && researchForm.getObjet().equals(""))  {
            conventionList = conventionService.listAll();
        } else if (researchForm.getType() != 0 && researchForm.getObjet().equals("") && researchForm.getType()!=0) {
            conventionList = conventionService.getConventionsByType(researchForm.getType());
        } else if (researchForm.getType() == 0) {
            conventionList = conventionService.getConventionsByObjet(researchForm.getObjet());
        }
        else {
            conventionList = conventionService.getConventionsByTypeAndObjet(researchForm.getType(),
                    researchForm.getObjet());
        }
        model.addAttribute("conventionList", conventionList);
        model.addAttribute("formatter", formatter);
        model.addAttribute("participantService", participantService);
        model.addAttribute("typeService", typeService);
        model.addAttribute("researchForm", researchForm);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.findByEmail(auth.getName());
        model.addAttribute("user", user);
        return "conventions";
    }

    @RequestMapping("/new-convention")
    public String showNewConventionForm(Model model) {
        Convention convention = new Convention();
        model.addAttribute("convention", convention);
        model.addAttribute("participantService", participantService);
        model.addAttribute("typeService", typeService);
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
        modelAndView.addObject("participantService", participantService);
        modelAndView.addObject("typeService", typeService);
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

    @RequestMapping("/pdf")
    public String pdfView(Model model) {
        model.addAttribute("formatter", formatter);
        model.addAttribute("participantService", participantService);
        model.addAttribute("typeService", typeService);
        model.addAttribute("conventionList", conventionList);
        return "pdf";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }




}
