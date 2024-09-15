package com.eCommerce.shopping_cart.dto;

import com.eCommerce.shopping_cart.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Blob;

@Data
public class ImageDto {
    private Long id;
    private String fileName;
    private String downloadUrl;
}
