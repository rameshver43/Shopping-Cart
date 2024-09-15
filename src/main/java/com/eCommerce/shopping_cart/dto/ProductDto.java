package com.eCommerce.shopping_cart.dto;

import com.eCommerce.shopping_cart.model.Category;
import com.eCommerce.shopping_cart.model.Image;
import com.eCommerce.shopping_cart.model.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
    private List<ImageDto> images;
}
