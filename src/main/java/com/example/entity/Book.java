package com.example.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "书名不能为空")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "分类不能为空")
    @Column(nullable = false)
    private String category;

    @NotBlank(message = "作者不能为空")
    @Column(nullable = false)
    private String author;

    @NotNull(message = "出版日期不能为空")
    @PastOrPresent(message = "出版日期不能是未来日期")
    @Column(nullable = false)
    private LocalDate publicationDate;

    @NotBlank(message = "ISBN编码不能为空")
    @Column(nullable = false)
    private String isbn;

    public @NotBlank(message = "书名不能为空") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "书名不能为空") String title) {
        this.title = title;
    }

    public @NotBlank(message = "分类不能为空") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "分类不能为空") String category) {
        this.category = category;
    }

    public @NotBlank(message = "作者不能为空") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotBlank(message = "作者不能为空") String author) {
        this.author = author;
    }

    public @NotNull(message = "出版日期不能为空") LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(@NotNull(message = "出版日期不能为空") LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public @NotBlank(message = "ISBN编码不能为空") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank(message = "ISBN编码不能为空") String isbn) {
        this.isbn = isbn;
    }

}
