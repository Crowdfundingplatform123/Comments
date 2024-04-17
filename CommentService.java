import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        // Additional logic before adding a comment (if needed)
        return commentRepository.save(comment);
    }

    public void deleteComment(int id) {
        // Additional logic before deleting a comment (if needed)
        commentRepository.deleteById(id);
    }

    public Comment editComment(int id, Comment updatedComment) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Update only if the comment exists
        if (updatedComment.getContent() != null) {
            comment.setContent(updatedComment.getContent());
        }
        // Additional logic for other fields update if needed

        return commentRepository.save(comment);
    }
}
