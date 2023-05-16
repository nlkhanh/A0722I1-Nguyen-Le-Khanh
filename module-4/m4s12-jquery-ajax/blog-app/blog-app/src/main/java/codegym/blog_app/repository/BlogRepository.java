package codegym.blog_app.repository;

import codegym.blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByAuthorContainingOrContentContainingOrCategoryContaining(String author, String content, String category);

    @Query(value = "select * from blog inner join category on blog.category_id = category.id where blog.author like concat('%', :search, '%') or blog.content like concat('%', :search, '%') or category.name like concat('%', :search, '%') order by blog.id desc", nativeQuery = true)
    List<Blog> findAllBySearch(@Param("search") String search);
}
