package estudos.vamosEsrudar.domain.DataDetails;

import estudos.vamosEsrudar.domain.entity.Post;

public record DataDetailsPost(String titulo, String texto, Long autorId) {

    public DataDetailsPost(Post post){
        this(post.getTitulo(), post.getTexto(), post.getAutor().getId());
    }
}
