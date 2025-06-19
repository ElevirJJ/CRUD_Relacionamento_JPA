package estudos.vamosEsrudar.controller;


import estudos.vamosEsrudar.domain.dto.RequestAuthor;
import estudos.vamosEsrudar.domain.entity.Author;
import estudos.vamosEsrudar.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity cadastrar (@RequestBody @Validated RequestAuthor dados){
        authorService.cadastro(dados);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<Author>> list(){
        var autores = authorService.list();

        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestAuthor.DataDetailsAuthor> buscarPorId(@PathVariable Long id) {
        var autor = authorService.searchPeloID(id);
        return ResponseEntity.ok(new RequestAuthor.DataDetailsAuthor(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteID (@PathVariable Long id){
        authorService.deleteID(id);
        return ResponseEntity.ok().build();
    }


}
