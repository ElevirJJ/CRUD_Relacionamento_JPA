package estudos.vamosEsrudar.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "autor")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "autor" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Post> postagem;


    @OneToMany(mappedBy = "autor" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comentarios;

    public Author(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}
