package estudos.vamosEsrudar.repository;

import estudos.vamosEsrudar.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRespository extends JpaRepository <Author, Long> {
}
