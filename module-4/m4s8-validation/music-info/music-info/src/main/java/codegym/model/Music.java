package codegym.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public @Data class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{notEmpty}")
    @Size(max = 800, message = "{size.max.name}")
    @Pattern(regexp = "[A-Za-z0-9 ]*", message = "{pattern.name}")
    private String name;
    @NotEmpty (message = "{notEmpty}")
    @Size(max = 300, message = "{size.max.author}")
    @Pattern(regexp = "[A-Za-z0-9 ]*", message = "{pattern.author}")
    private String author;
    @NotEmpty (message = "{notEmpty}")
    @Size(max = 1000, message = "{size.max.type}")
    @Pattern(regexp = "[A-Za-z0-9, ]*", message = "{pattern.type}")
    private String type;
}
