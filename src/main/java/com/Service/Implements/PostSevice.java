package com.Service.Implements;

import com.Model.Post;
import com.Repository.PostRepository;
import com.Service.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostSevice implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> getAllByName(String name, Pageable pageable){
        return postRepository.getAllByNameHQL(name, pageable);
    }

    @Override
    public Post getLastPosted() {
        return postRepository.findFirstByOrderByPostDateDesc();
    }

    @Override
    public Page<Post> getAllByCategory(int id, Pageable pageable) {
        return postRepository.findAllByCategoryId(id,pageable);
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    public void save(Post post){
     postRepository.save(post);
    }
    public void edit(Post post){
        postRepository.save(post);
    }

    @Override
    public void delete(int id) {
       postRepository.deleteById(id);
    }

    public Post findById(int id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            return new Post();
        }
    }

}