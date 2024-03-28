package com.example.ECommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotNull String name;
    private @NotNull String imageUrl;
    private @NotNull String price;
    private @NotNull String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    CategoryEntity category;
}
