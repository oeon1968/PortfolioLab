package pl.coderslab.charity.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "donations")
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    @NotNull
    private Integer quantity;
    @NotEmpty
    @ManyToMany
    @JoinTable(name = "donations_categories")
    private Set<Category> categories = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "institution_id")
    @NotNull
    private Institution institution;
    @NotBlank(message = "Pole nie może być pusta.")
    @Size(min=1, max=255, message = "Pole nie może zawierać więcej niż 255 znaków")
    private String street;
    @NotBlank
    @Size(min=1, max=255, message = "Pole nie może zawierać więcej niż 255 znaków")
    private String city;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    @NotBlank
    private String zipCode;
    @NotNull(message = "Pole nie może być puste.")
    @Future(message = "Proszę podać przyszłą datę.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

}
