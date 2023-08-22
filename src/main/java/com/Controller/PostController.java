package com.Controller;

import com.Model.Category;
import com.Model.Post;
import com.Service.Interface.ICategorySevice;
import com.Service.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ICategorySevice categorySevice;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categorySevice.getAll();
    }
    @GetMapping
    public ModelAndView home(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("blog");
        Page<Post> posts =  postService.getAll(PageRequest.of(page, 4, Sort.by("postDate").descending()));
        modelAndView.addObject("posts", posts);
        Post latestPost = postService.getLastPosted();
        modelAndView.addObject("post", latestPost);
        return modelAndView;
    }
@GetMapping("/category/{id}")
public ModelAndView getAllByCategory(@PathVariable int id , @RequestParam(defaultValue = "0") int page){
    ModelAndView modelAndView = new ModelAndView("blog");
    Page<Post> posts = postService.getAllByCategory(id,PageRequest.of(page, 4, Sort.by("postDate").descending()));
    modelAndView.addObject("posts", posts);
    Post latestPost = postService.getLastPosted();
    modelAndView.addObject("post", latestPost);
    return modelAndView;
}
    @GetMapping("/search")
    public ModelAndView getAllByName(@RequestParam String nameSearch, @RequestParam(defaultValue = "0")int page){
        ModelAndView modelAndView = new ModelAndView("blog");
        Page<Post> posts = postService.getAllByName(nameSearch,PageRequest.of(page, 4, Sort.by("postDate").descending()));
        modelAndView.addObject("posts", posts);
        Post latestPost = postService.getLastPosted();
        modelAndView.addObject("post", latestPost);
        return modelAndView;
    }
    @GetMapping("/about")
    public ModelAndView showAbout(){
        ModelAndView modelAndView = new ModelAndView("about");
        return modelAndView;
    }
    @GetMapping("/contact")
    public ModelAndView showContact(){
        ModelAndView modelAndView = new ModelAndView("contact");
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("detail");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        postService.delete(id);
        return "redirect:/posts";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post, @RequestParam int idCategory){
        postService.edit(new Post(post.getId(),post.getPostTitle(),post.getPostAbstract(),post.getAppendices(),post.getImageMain(),post.getImageSupport1(),post.getImageSupport2(),post.getImageSupport3(),post.getImageSupport4() , new Category(idCategory)));
        return "redirect:/posts";
    }
    @GetMapping("/add")
    public ModelAndView showAdd(){
        ModelAndView modelAndView = new ModelAndView("add");
        return modelAndView;
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Post post , @RequestParam int idCategory){
        postService.save(new Post(post.getPostTitle(), post.getPostAbstract(),post.getAppendices(),post.getImageMain(),post.getImageSupport1(),post.getImageSupport2(),post.getImageSupport3(),post.getImageSupport4() , new Category(idCategory)));
        return "redirect:/posts";
    }
}