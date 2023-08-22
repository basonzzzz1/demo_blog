package com.Service.Implements;

import com.Model.Category;
import com.Repository.ICategoryRepo;
import com.Service.Interface.ICategorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategorySevice {

    @Autowired
    ICategoryRepo iCategoryRepo;


    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).get();
    }
}