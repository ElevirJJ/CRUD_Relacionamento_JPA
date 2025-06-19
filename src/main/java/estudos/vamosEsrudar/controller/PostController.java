package estudos.vamosEsrudar.controller;

import estudos.vamosEsrudar.domain.DataDetails.DataDetailsPost;
import estudos.vamosEsrudar.domain.dto.RequestPost;
import estudos.vamosEsrudar.domain.entity.Post;
import estudos.vamosEsrudar.domain.service.PostService;
import estudos.vamosEsrudar.repository.AuthorRespository;
import estudos.vamosEsrudar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostController {


    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody RequestPost dados) {
        postService.cadastro(dados);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<Post>> list (){
        var getList = postService.list();

        return ResponseEntity.ok(getList);
    }

    @GetMapping("/{id}")
    public ResponseEntity <DataDetailsPost> getID(@PathVariable Long id){
        var dados = postService.searchPeloID(id);
        return ResponseEntity.ok(new DataDetailsPost(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete (@PathVariable Long id){
        postService.deleteID(id);
        return ResponseEntity.ok().build();
    }


}
