package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository dr;

    //select
    public Long getQuantitiesSum() {
        return dr.quantitiesSum();
    }

    public Long getDonationCount() {
        return dr.count();
    }

    //insert and update
    public void insert(Donation donation) {
        /* jak zostanie uzupełniona tabela donations_categories? */
        dr.save(donation);
    }

    //delete
    public void delete(Long id) {
        dr.delete(dr.getById(id));
    }
}
