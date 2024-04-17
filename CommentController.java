import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        // Additional validation or pre-processing logic can be added here
        return commentService.addComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        // Additional logic before deleting a comment (if needed)
        commentService.deleteComment(id);
    }

    @PutMapping("/{id}")
    public Comment editComment(@PathVariable int id, @RequestBody Comment comment) {
        // Additional validation or pre-processing logic can be added here
        return commentService.editComment(id, comment);
    }
}
