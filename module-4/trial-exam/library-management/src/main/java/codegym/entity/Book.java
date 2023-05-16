package codegym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "author", length = 45)
    private String author;

    @Column(name = "detail", length = 1000)
    private String detail;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    private Set<BorrowCard> borrowCards = new LinkedHashSet<>();

    public void degreeQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }

    public void increaseQuantity() {
            this.quantity++;
    }
}