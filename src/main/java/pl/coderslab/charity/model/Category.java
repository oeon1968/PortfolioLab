package pl.coderslab.charity.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull (message = "Pole nie może być pusta.")
    @NotBlank
    @Size(min=1, max=125, message = "Pole nie może zawierać więcej niż 125 znaków")
    private String name;
}
