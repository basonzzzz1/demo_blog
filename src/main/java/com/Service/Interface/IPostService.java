package com.Service.Interface;

import com.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService extends IService<Post>{
    Page<Post> getAll(Pageable pageable);
    Page<Post> getAllByName(String name, Pageable pageable);
    Post getLastPosted();
    Page<Post> getAllByCategory(int id, Pageable pageable);
}
