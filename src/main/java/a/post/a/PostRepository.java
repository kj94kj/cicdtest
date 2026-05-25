package a.post.a;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
            select new a.post.a.PostListResponseDto(
                p.id,
                p.title,
                u.nickname
            )
            from Post p
            join p.user u
            order by p.id desc
            """)
    Page<PostListResponseDto> findPostList(Pageable pageable);
}
