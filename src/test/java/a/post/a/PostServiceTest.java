package a.post.a;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import a.post.a.CreatePostRequestDto;
import a.post.a.Post;
import a.post.a.PostRepository;
import a.post.a.PostService;
import a.post.a.User;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Test
    void 게시글_생성() {
    	
    	User user = new User();

    	ReflectionTestUtils.setField(user, "nickname", "testuser");
    	
    	userRepository.save(user);

        CreatePostRequestDto request = new CreatePostRequestDto();

        ReflectionTestUtils.setField(request, "title", "hello");
        ReflectionTestUtils.setField(request, "content", "world");
        ReflectionTestUtils.setField(request, "user", user);

        Long id = postService.create(request);

        Post post = postRepository.findById(id).orElseThrow();

        assertThat(post.getTitle()).isEqualTo("hello");
    }
}

