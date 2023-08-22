package com.Repository;

import com.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends PagingAndSortingRepository<Post , Integer> {
    @Query(value = "select p from Post p where p.postTitle like concat('%', :name, '%')")
    Page<Post> getAllByNameHQL(@Param("name") String name, Pageable pageable);

    Post findFirstByOrderByPostDateDesc();
    Page<Post> findAllByCategoryId(int categoryId , Pageable pageable);
}
