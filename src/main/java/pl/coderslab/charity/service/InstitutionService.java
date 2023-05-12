package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionService {
    final private InstitutionRepository ir;

    public List<Institution> findAll() {
        return ir.findAll();
        //Paginacja !!!!
        // return ir.findAll(Pageable.ofSize(4)).getContent(); //zwraca pierwszą stronę o rozmiarze 4
    }
}
