package estudos.vamosEsrudar.domain.DataDetails;

import estudos.vamosEsrudar.domain.entity.Author;

public record DataDetailsAuthor(Long id, String nome, String descricao) {

    public DataDetailsAuthor(Author author) {
        this(author.getId(), author.getNome(), author.getDescricao());
    }
}

