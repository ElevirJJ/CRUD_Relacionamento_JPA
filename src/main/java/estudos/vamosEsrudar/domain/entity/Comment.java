package estudos.vamosEsrudar.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "comentario")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    @JsonBackReference
    private Post postagem;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Author autor;


    public Comment(String comentario, Post postagem, Author autor) {
        this.comentario = comentario;
        this.postagem = postagem;
        this.autor = autor;
    }

}
