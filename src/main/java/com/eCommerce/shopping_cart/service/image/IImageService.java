package com.eCommerce.shopping_cart.service.image;

import com.eCommerce.shopping_cart.dto.ImageDto;
import com.eCommerce.shopping_cart.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> file, Long productId);

    void updateImage(MultipartFile file, Long imageId);

}
