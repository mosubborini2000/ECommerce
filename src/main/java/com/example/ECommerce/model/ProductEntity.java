package com.example.ECommerce.model;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
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
// لازم احطها مش نل
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    UserEntity user;

}
