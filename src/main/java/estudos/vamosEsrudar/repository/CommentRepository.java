package estudos.vamosEsrudar.repository;

import estudos.vamosEsrudar.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
