package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.model.Comment;
import tn.esprit.esponline.model.Post;
import tn.esprit.esponline.model.User;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
