package a.post.a;

public class PostListResponseDto {

    private Long postId;
    private String title;
    private String writerNickname;

    public PostListResponseDto(Long postId,
                               String title,
                               String writerNickname) {

        this.postId = postId;
        this.title = title;
        this.writerNickname = writerNickname;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getWriterNickname() {
        return writerNickname;
    }
}