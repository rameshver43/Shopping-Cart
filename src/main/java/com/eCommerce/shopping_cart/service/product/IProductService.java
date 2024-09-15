package com.eCommerce.shopping_cart.service.product;

import com.eCommerce.shopping_cart.dto.ProductDto;
import com.eCommerce.shopping_cart.model.Product;
import com.eCommerce.shopping_cart.request.AddProductRequest;
import com.eCommerce.shopping_cart.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto covertToDto(Product product);
}
