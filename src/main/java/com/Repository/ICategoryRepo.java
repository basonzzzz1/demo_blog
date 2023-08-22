package com.Repository;


import com.Model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category,Integer> {
}