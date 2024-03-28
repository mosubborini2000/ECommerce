package com.example.ECommerce.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
