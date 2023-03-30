package codegym.blogapp.service;

import codegym.blogapp.model.Category;

import java.util.List;

public interface CategoryService extends GeneralService<Category>{
    List<Category> findAll();
}
