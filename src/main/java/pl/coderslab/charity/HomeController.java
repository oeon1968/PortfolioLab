package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final  InstitutionService institutionService;
    private final DonationService donationService;
    @RequestMapping("/")
    //@ResponseBody
    public String homeAction(Model model){

        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donations", donationService.getDonationCount());
        model.addAttribute("quantity", donationService.getQuantitiesSum());


        return "index";
    }
}
