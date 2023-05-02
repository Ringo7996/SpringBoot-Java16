package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.jobhunt.model.Applicant;
import vn.techmaster.jobhunt.repository.ApplicantRepository;
import vn.techmaster.jobhunt.request.CreateApplicantRequest;
import vn.techmaster.jobhunt.response.CreateApplicantResponse;


@Controller
@RequestMapping("/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantRepository appRepo;

    @GetMapping
    public String getApplicant(Model model) {
        model.addAttribute("applicants", appRepo.getApplicants());
        return "applicants";
    }

    @GetMapping("/createnewapplicant")
    public String getNewApplicant(Model model) {
        model.addAttribute("createApplicantRequest", new CreateApplicantRequest());
        model.addAttribute("createApplicantResponse", null);
        return "createnewapplicant";
    }

    @PostMapping("/createnewapplicant")
    public String handleCreateApplicantForm(@ModelAttribute("createApplicantRequest") CreateApplicantRequest request, BindingResult bindingResult, Model model) {
        Applicant newApplicant = new Applicant(appRepo.getSize() + 1, request.getName(),request.getEmail(), request.getAddress());
        appRepo.setSize(appRepo.getSize() + 1);
        appRepo.getApplicants().put(newApplicant.getId(), newApplicant);//
        CreateApplicantResponse response = new CreateApplicantResponse(newApplicant.getId(),newApplicant.getName(),newApplicant.getEmail(), newApplicant.getAddress());

        model.addAttribute("createApplicantResponse",response);
        model.addAttribute("createApplicantRequest", new CreateApplicantRequest());
        return "createnewapplicant";
    }


}
