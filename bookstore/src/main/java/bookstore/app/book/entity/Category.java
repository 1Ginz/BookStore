package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"category","comments","orderDetails"},allowSetters = true)
    private Set<Book> books;


}
