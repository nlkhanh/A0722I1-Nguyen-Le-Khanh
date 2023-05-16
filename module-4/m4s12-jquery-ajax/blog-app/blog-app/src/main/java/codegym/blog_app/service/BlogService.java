package codegym.blog_app.service;

import codegym.blog_app.model.Blog;

import java.util.List;

public interface BlogService extends GeneralService<Blog> {
    List<Blog> findSearch(String search);
    List<Blog> findSearchDataSpring(String author, String content, String category);
}
