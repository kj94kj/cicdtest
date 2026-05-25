package a.post.a;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    public User() {
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}