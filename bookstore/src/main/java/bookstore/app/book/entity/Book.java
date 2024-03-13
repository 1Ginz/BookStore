package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "not blank book title")
    private String title;

    @Column(name = "author")
    @NotBlank(message = "not blank book author")
    private String author;


    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "img_cover", nullable = true)
    private String imgCover;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties(value = {"books"},allowSetters = true)
    private Category category;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = {"book","user"})
    private Set<Comment> comments;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = {"book","orderTotal"})
    private Set<OrderDetail> orderDetails;

    @Transient
    public String getImgCover(){
//        if(this.imgCover == null) return null;
//        return "/data/book/" + this.id + "/" + this.imgCover;
        return this.imgCover;
    }

}
