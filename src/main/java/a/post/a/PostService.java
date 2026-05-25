package a.post.a;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<PostListResponseDto> getPostList(Pageable pageable) {
    	
        return postRepository.findPostList(pageable);
    }
    
    public Long create(CreatePostRequestDto request) {
    	Post post = new Post(
    			request.getTitle(),
    			request.getContent(),
    			request.getUser()
    		);
    	
    	return postRepository.save(post).getId();
    }
}
