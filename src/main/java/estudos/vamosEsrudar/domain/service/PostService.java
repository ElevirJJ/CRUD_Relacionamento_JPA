package estudos.vamosEsrudar.domain.service;

import estudos.vamosEsrudar.domain.dto.RequestPost;
import estudos.vamosEsrudar.domain.entity.Post;
import estudos.vamosEsrudar.repository.AuthorRespository;
import estudos.vamosEsrudar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRespository authorRespository;

    public void cadastro (RequestPost dados){
        var autor = authorRespository.findById(dados.autorId())
                .orElseThrow(() -> new RuntimeException("autor não encontrado"));

        postRepository.save(new Post(dados.titulo(), dados.texto(), autor));

    }

    public List<Post> list (){
       return postRepository.findAll();
    }

    public Post searchPeloID (Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não existi"));
    }

    public void deleteID (Long id){
        postRepository.deleteById(id);
    }

}
