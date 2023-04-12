package codegym.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public @Data class User {
    @NotEmpty
    @Size(min = 2, max = 3)
    private String name;
    @Min(18)
    private Integer age;
    private String phone;
}
