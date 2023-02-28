package com.example.bepetshop.service;


import com.example.bepetshop.models.Category;
import com.example.bepetshop.models.request.AddCategoryRequest;
import com.example.bepetshop.models.request.EditCategoryRequest;

import java.util.List;

public interface CategoryService {

    Category addCategory(AddCategoryRequest request);

    boolean deleteCategory(long id);

    Category editCategory(EditCategoryRequest request , long id);

    List<Category> listCate();

    Category getCategoryById(long id);


}
