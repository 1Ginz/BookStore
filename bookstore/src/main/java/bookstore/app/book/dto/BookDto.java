package bookstore.app.book.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class BookDto {
    private Long id;

    private String title;

    private String author;

    private CategoryDto category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private Double price;

    private String imgCover;


    public BookDto() {
    }


    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public CategoryDto getCategory() {
        return this.category;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getImgCover() {
        return this.imgCover;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }




    public String toString() {
        return "BookDto(id=" + this.getId() + ", title=" + this.getTitle() + ", author=" + this.getAuthor() + ", category=" + this.getCategory() + ", releaseDate=" + this.getReleaseDate() + ", price=" + this.getPrice() + ", imgCover=" + this.getImgCover() + ")";
    }
}