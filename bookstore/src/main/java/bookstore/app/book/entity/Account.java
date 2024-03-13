package bookstore.app.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Table(name = "account")
@Entity
public class Account {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGengerator")
    @SequenceGenerator(name = "sequenceGengerator")
    private Long id;

    @Column(name = "user_name")
    @Size(min = 8, max = 50)
    private String username;

    @Column(name = "password")
    @Size(min = 8, max = 50)
    private String password;

    @Column(name = "role")
    private String role;

//    @OneToMany(mappedBy = "account")
//    @JsonIgnoreProperties(value = {"book", "account"}, allowSetters = true)
//    private Set<Comment> comment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"account","orderTotal"}, allowSetters = true)
    private User user;

    public Account() {
    }

    public Long getId() {
        return this.id;
    }

    public @Size(min = 8, max = 50) String getUsername() {
        return this.username;
    }

    public @Size(min = 8, max = 50) String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

//    public Set<Comment> getComment() {
//        return this.comment;
//    }

    public User getUser() {
        return this.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(@Size(min = 8, max = 50) String username) {
        this.username = username;
    }

    public void setPassword(@Size(min = 8, max = 50) String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @JsonIgnoreProperties(value = {"book", "account"}, allowSetters = true)
//    public void setComment(Set<Comment> comment) {
//        this.comment = comment;
//    }

    public void setUser(User user) {
        this.user = user;
    }

}