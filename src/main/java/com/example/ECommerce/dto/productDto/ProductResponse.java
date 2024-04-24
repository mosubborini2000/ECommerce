package com.example.ECommerce.dto.productDto;

import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String imageUrl;
    private String price;
    private String description;
    private Long categoryId;

}
