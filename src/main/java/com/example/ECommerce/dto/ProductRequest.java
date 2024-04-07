package com.example.ECommerce.dto;
import com.sun.istack.NotNull;
import lombok.*;
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private @NotNull String name;
    private @NotNull String imageUrl;
    private @NotNull String price;
    private @NotNull String description;
    private @NotNull Long categoryId;

}
