package a.post.a;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePostRequestDto {
    private String title;
    private String content;
    private User user;
}
