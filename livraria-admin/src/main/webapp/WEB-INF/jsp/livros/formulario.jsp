<h1>Formulario</h1>

<form action="${linkTo[LivrosController].salva}" method="post">
  <h2>Formulário de cadastro de livros</h2>
  <ul>
    <li>Título: <br/>
        <input type="text" name="livro.titulo" /></li>

    <li>Descrição: <br/>
        <textarea name="livro.descricao"></textarea></li>

    <li>ISBN: <br/>
        <input type="text" name="livro.isbn" /></li>

    <li>Preço: <br/>
        <input type="text" name="livro.preco" /></li>

    <li>Data de publicação: <br/>
      <input type="text" name="livro.dataPublicacao" /></li>
  </ul>
  <input type="submit" value="Salvar" />
</form>