package estudos.vamosEsrudar.domain.dto;

import estudos.vamosEsrudar.domain.entity.Author;

public record RequestAuthor(String nome, String descricao) {

    public record DataDetailsAuthor(String nome, String descricao) {
        public DataDetailsAuthor(Author author) {
            this(author.getNome(), author.getDescricao());
        }
    }

}

