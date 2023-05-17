package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository dr;

    //select
    public Long getQuantitiesSum() {
        Optional<Long> optQuantitySum = Optional.ofNullable(dr.quantitiesSum());
        return optQuantitySum.orElse(0L);
    }

    public Long getDonationCount() {
        return dr.count();
    }

    //insert and update
    public void insert(Donation donation) {
        dr.save(donation);
    }

    //delete
    public void delete(Long id) {
        dr.delete(dr.getById(id));
    }
}
