package estudos.vamosEsrudar.controller;

import estudos.vamosEsrudar.domain.DataDetails.DataDetailsComment;
import estudos.vamosEsrudar.domain.dto.RequestComment;
import estudos.vamosEsrudar.domain.entity.Comment;
import estudos.vamosEsrudar.domain.service.CommentService;
import estudos.vamosEsrudar.repository.AuthorRespository;
import estudos.vamosEsrudar.repository.CommentRepository;
import estudos.vamosEsrudar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping
    public ResponseEntity cadastrar (@RequestBody RequestComment dados){
        commentService.cadastro(dados);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<Comment>> list (){
       var getList = commentService.list();
       return ResponseEntity.ok(getList);
    }

    @GetMapping("/{id}")
    public ResponseEntity <DataDetailsComment> buscarPorId (@PathVariable Long id){
        var getID = commentService.searchPeloID(id);
        return ResponseEntity.ok(new DataDetailsComment(getID));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteID (@PathVariable Long id){
        commentService.deleteID(id);
        return ResponseEntity.ok().build();
    }

}
