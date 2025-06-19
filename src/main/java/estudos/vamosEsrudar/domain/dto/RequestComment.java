package estudos.vamosEsrudar.domain.dto;

import estudos.vamosEsrudar.domain.entity.Comment;

public record RequestComment(String comentario, Long postagemId, Long autorId) {
    public record DataDetailsComment (String comentario, Long postagemId, Long autorId){
        public DataDetailsComment (Comment comment){
            this(comment.getComentario(), comment.getPostagem().getId(), comment.getAutor().getId());
        }
    }
}
