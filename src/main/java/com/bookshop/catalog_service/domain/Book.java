package com.bookshop.catalog_service.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Book(
        @Id
        Long id,
        @NotBlank(message = "The book ISBN must be specified.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,
        @NotBlank(message = "The title must be defined.")
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        @Positive(
                message = "The book price must be greater than zero."
        )
        Double price,
        @Version
        int version
) {
    public static Book of(
            String isbn, String title, String author, Double price
    ) {
        return new Book(
                null, isbn, title, author, price, 0
        );
    }
}
