package codegym.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(columnDefinition = "varchar(10000)")
    private String description;
    private String image;
}
