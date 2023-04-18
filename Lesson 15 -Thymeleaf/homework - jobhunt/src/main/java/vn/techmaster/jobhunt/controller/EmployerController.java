package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepository;
import vn.techmaster.jobhunt.request.CreateEmployerRequest;
import vn.techmaster.jobhunt.response.CreateEmployerResponse;

@Controller
@RequestMapping("/employers")
public class EmployerController {
    @Autowired
    private EmployerRepository emplRepo;

    @GetMapping
    public String getEmployers(Model model) {
        model.addAttribute("employers", emplRepo.getEmployers());
        return "employers";
    }

    @GetMapping("/createnewemployer")
    public String getNewEmployers(Model model) {
        model.addAttribute("createEmployerRequest", new CreateEmployerRequest());
        model.addAttribute("createEmployerResponse", null);
        return "createnewemployer";
    }

    @PostMapping("/createnewemployer")
    public String handleCreateEmployerForm(@ModelAttribute("createEmployerRequest") CreateEmployerRequest request, BindingResult bindingResult, Model model) {
        Employer newEmployer = new Employer(emplRepo.getSize() + 1, request.getName(),request.getEmail(), request.getAddress());
        emplRepo.setSize(emplRepo.getSize() + 1);
        emplRepo.getEmployers().put(newEmployer.getId(), newEmployer);//
        CreateEmployerResponse response = new CreateEmployerResponse(newEmployer.getId(),newEmployer.getName(),newEmployer.getEmail(), newEmployer.getAddress());

        model.addAttribute("createEmployerResponse",response);
        model.addAttribute("createEmployerRequest", new CreateEmployerRequest());
        return "createnewemployer";
    }


}
