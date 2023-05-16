package codegym.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "author", length = 45)
    private String author;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    @JsonBackReference
    private Set<BorrowCard> borrowCards = new LinkedHashSet<>();

    public void degreeQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
}