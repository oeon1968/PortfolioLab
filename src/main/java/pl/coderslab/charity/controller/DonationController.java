package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @ModelAttribute("categories")
    private List<Category> categoryList() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    private List<Institution> institutionList() {
        return institutionService.findAll();
    }

    @RequestMapping("/donation")
    public String newDonation(Model model) {

        model.addAttribute("donation", new Donation());
        return "/form";
    }

    @PostMapping("/donation")
    public String saveDonation(@Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "/donation";
        }
        donationService.insert(donation);
        return "redirect:/form-confirmation";
    }
}
