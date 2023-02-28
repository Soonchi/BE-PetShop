package com.example.bepetshop.service;


import com.example.bepetshop.models.Product;
import com.example.bepetshop.models.request.AddProductRequest;
import com.example.bepetshop.models.request.EditProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product add(AddProductRequest request, MultipartFile image) throws IOException;

    Product update(EditProductRequest request, MultipartFile image) throws IOException;

    List<Product> getAll();

    boolean delete(long id);


    List<Product> getProductByCategoryName(long id);

    Product getProductById(long id);
}
