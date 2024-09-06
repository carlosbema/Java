package lessons.composition.postComment.entities;

import lessons.composition.postComment.entities.Comment
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String moment;
    private String title;
    private String content;
    private int likes;

    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String moment, String title, String content, int likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }
}
