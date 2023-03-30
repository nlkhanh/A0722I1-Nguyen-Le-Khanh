package codegym.blogapp.service;

import codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends GeneralService<Blog>{
    Page<Blog> findByTitleContainingOrderByPublicDate(String title, Pageable pageable);
}
