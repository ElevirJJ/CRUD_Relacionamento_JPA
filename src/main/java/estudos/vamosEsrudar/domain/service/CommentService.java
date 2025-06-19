package estudos.vamosEsrudar.domain.service;

import estudos.vamosEsrudar.domain.dto.RequestComment;
import estudos.vamosEsrudar.domain.entity.Comment;
import estudos.vamosEsrudar.repository.AuthorRespository;
import estudos.vamosEsrudar.repository.CommentRepository;
import estudos.vamosEsrudar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private AuthorRespository authorRespository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;


    public void cadastro (RequestComment dados){
        var autor = authorRespository.findById(dados.autorId())
                .orElseThrow(() -> new RuntimeException("autor não encontrado"));

        var post = postRepository.findById(dados.postagemId())
                .orElseThrow(() -> new RuntimeException("poste não encontrador"));

        commentRepository.save(new Comment(dados.comentario(), post, autor));
    }

    public List<Comment> list (){
       return commentRepository.findAll();
    }

    public Comment searchPeloID (Long id){
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não existi"));
    }

    public void deleteID (Long id){
        commentRepository.deleteById(id);
    }
}
