package pl.coderslab.charity.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "donations")
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 0)
    private Integer quantity;
    @ManyToMany
    @JoinTable(name = "donations_categories")
    private List<Category> categories = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

}
