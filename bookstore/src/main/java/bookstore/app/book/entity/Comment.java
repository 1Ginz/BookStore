package bookstore.app.book.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "content")
    @Lob
    private String content;

    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"comments", "category","orderDetails"}, allowSetters = true)
    private Book book;

//    @ManyToOne
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = {"user", "comments"}, allowSetters = true)
//    private Account account;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"comments","account","orderTotal","checkouts"}, allowSetters = true)
    private User user;


}
