<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Formulario</h1>
<ul class="errors">
  <c:forEach items="${errors}" var="error">
    <li>
      <!-- o campo em que ocorreu o erro, ou o tipo do erro -->
      ${error.category}:

      <!-- a mensagem de erro de validação -->
      ${error.message}
    </li>
  </c:forEach>
</ul>
<form action="${linkTo[LivrosController].salva }" method="post">
  <input type="hidden" name="livro.id" value="${livro.id }"/>
  <h2>Formulário de cadastro de livros</h2>
  <ul>
    <li>Título: <br/>
        <input type="text" name="livro.titulo"
                        value="${livro.titulo}"/></li>

    <li>Descrição: <br/>
        <textarea name="livro.descricao">${livro.descricao
        }</textarea></li>

    <li>ISBN: <br/>
        <input type="text" name="livro.isbn"
                        value="${livro.isbn}"/></li>

    <li>Preço: <br/>
        <input type="text" name="livro.preco"
                        value="${livro.preco}"/></li>

    <li>Data de publicação: <br/>
      <input type="text" name="livro.dataPublicacao"
                      value="${livro.dataPublicacao}"/>
    </li>
  </ul>
  <input type="submit" value="Salvar" />
</form>