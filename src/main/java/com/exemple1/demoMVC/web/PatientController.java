package com.exemple1.demoMVC.web;


import com.exemple1.demoMVC.entities.Patient;
import com.exemple1.demoMVC.services.PatientServicesImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientServicesImp patientServices;
    //@GetMapping("/index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "15") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){

        Page<Patient> patientList = patientServices.patients("%"+keyword+"%",page,size);
        model.addAttribute("patientList",patientList.getContent());
        model.addAttribute("pages",new int[patientList.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return"ListPatient";
    }

    @GetMapping("/delete")
    public String Delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "keyword" , defaultValue = "")  String keyword,
                         @RequestParam(name = "page" , defaultValue = "0")  int page){
        patientServices.Delete(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/formPatient")
    public String FormPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @GetMapping("/editForm")
    public String EditPatient(Model model,@RequestParam (name = "id") Long id){
        Patient patient = patientServices.findById(id);
        model.addAttribute("patient",patient);
        return "editForm";
    }
    @PostMapping("/savePatient")
    public String savePatient(@Valid Patient p, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "formPatient";
        }
        patientServices.save(p);
        return "redirect:/index?keyword="+p.getName();
    }

}
