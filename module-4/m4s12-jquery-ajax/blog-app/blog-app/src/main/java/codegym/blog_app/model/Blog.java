package codegym.blog_app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    @Column(columnDefinition = "varchar(1000)")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
