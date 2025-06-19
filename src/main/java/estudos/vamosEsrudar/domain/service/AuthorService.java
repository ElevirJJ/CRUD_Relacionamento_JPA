package estudos.vamosEsrudar.domain.service;

import estudos.vamosEsrudar.domain.dto.RequestAuthor;
import estudos.vamosEsrudar.domain.entity.Author;
import estudos.vamosEsrudar.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRespository authorRespository;


    public void cadastro (RequestAuthor dados){
        var author = new Author(dados.nome(), dados.descricao());
        authorRespository.save(author);
    }

    public List<Author> list (){
       return authorRespository.findAll();
    }

    public Author searchPeloID (Long id){
        return authorRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID não existi"));
    }

    public void deleteID (Long id){
        authorRespository.deleteById(id);
    }


}
