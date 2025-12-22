📚 Estudos sobre Relacionamentos no JPA com Spring Boot
Este projeto foi desenvolvido com o objetivo de estudar e praticar os principais tipos de relacionamentos entre entidades no JPA (Java Persistence API), utilizando o Spring Boot como base para criação de APIs 

🎯 Objetivos
Compreender e implementar os relacionamentos:

🔁 @OneToMany / @ManyToOne

🔗 @ManyToMany

🔒 @OneToOne (em casos práticos)

Entender o comportamento de:

CascadeType

orphanRemoval

fetch (EAGER vs LAZY)

Resolver problemas comuns:

Loop de serialização no JSON (@JsonManagedReference e @JsonBackReference)

Estruturação correta de DTOs para retorno de dados

Criação de endpoints com retorno aninhado (autor → postagens → comentários)

🛠️ Tecnologias Utilizadas
Java 23

Spring Boot

Spring Data JPA

Lombok

MySQL

Insomnia (para testes de API)

📌 Entidades principais
Author: autor de postagens e comentários

Post: postagens criadas por autores

Comment: comentários vinculados a posts e autores

✅ Funcionalidades
Cadastro, listagem, busca por ID e remoção de autores, postagens e comentários

Relacionamentos bidirecionais com carregamento adequado dos dados

Uso de DTOs para retornar respostas claras e sem redundância

✅ Insomia - Json

entity autor:

{
	"nome": "",
	"descricao": ""
}

entity postagem:

{
  "titulo": "",
  "texto": "",
  "autorId": 1
}

entity comentarios:

{
	"comentario": "",
	"postagemId" : 1,
	"autorId" : 1
}



