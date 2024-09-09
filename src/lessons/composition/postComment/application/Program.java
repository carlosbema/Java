package lessons.composition.postComment.application;

import lessons.composition.postComment.entities.Comment;
import lessons.composition.postComment.entities.Post;

import java.time.Instant;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Post post1 = new Post(Instant.now(), "Titulo 1", "Conteudo 1", 12);
        Comment comment1 = new Comment("Comentario 1");
        Comment comment2 = new Comment("Comentario 2");
        post1.addComments(comment1);
        post1.addComments(comment2);

        Post post2 = new Post(Instant.now(), "Titulo 2", "Conteudo 2", 42);
        Comment comment3 = new Comment("Comentario 3");
        Comment comment4 = new Comment("Comentario 4");
        post2.addComments(comment3);
        post2.addComments(comment4);
        System.out.println(post1 + "\n" + post2);
    }
}
