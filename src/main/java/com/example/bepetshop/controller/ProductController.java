package com.example.bepetshop.controller;

import com.example.bepetshop.models.Product;
import com.example.bepetshop.models.request.AddProductRequest;
import com.example.bepetshop.models.request.EditProductRequest;
import com.example.bepetshop.models.response.AddProductResponse;
import com.example.bepetshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    private final ProductService productService;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddProductResponse>> getAllProduct(){
        var listProduct = productService.getAll().stream()
                .map(product -> modelMapper.map(product , AddProductResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> addProduct(@ModelAttribute AddProductRequest request, @RequestPart("file") MultipartFile image) throws IOException {
        var product = productService.add(request,image);
        var productResponse = modelMapper.map(product, AddProductResponse.class);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AddProductResponse> editProduct(@ModelAttribute EditProductRequest request, @RequestPart("file") MultipartFile image) throws IOException {
        var product = productService.update(request,image);
        var productResponse = modelMapper.map(product, AddProductResponse.class);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id){
        return productService.delete(id);
    }


    @GetMapping("/getProductByCaTegory/{id}")
    List<Product> getProductByCaTalog(@PathVariable("id") long id) {
        return productService.getProductByCategoryName(id);
    }

    @GetMapping("/getProductById/{id}")
    Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }
}
