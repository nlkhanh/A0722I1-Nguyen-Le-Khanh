package codegym.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public @Data class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 45, message = "{size.name}")
    private String firstName;
    @Size(min = 5, max = 45, message = "{size.name}")
    private String lastName;
    @Pattern(regexp = "0\\d{9,10}", message = "{pattern.phone}")
    private String phone;
    @NotNull (message = "{notNull.age}")
    @Min(value = 18, message = "{min.age}")
    private Integer age;
    @NotEmpty
    @Email(message = "{email.validate}")
    private String email;
}
