package com.example.ECommerce.dto;
import com.sun.istack.NotNull;
import lombok.*;
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    private @NotNull String categoryName;
    private @NotNull String description;
    private @NotNull String imageUrl;
}
