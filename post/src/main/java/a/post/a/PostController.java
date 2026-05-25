package a.post.a;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Page<PostListResponseDto> getPosts(Pageable pageable) {
        return postService.getPostList(pageable);
    }
    
    @PostMapping("/posts")
    public Long create(@RequestBody CreatePostRequestDto request) {
    	return postService.create(request);
    }
}



