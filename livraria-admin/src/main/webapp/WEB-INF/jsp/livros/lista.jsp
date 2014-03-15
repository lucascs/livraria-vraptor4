<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Lista de Livros</h3>
<ul>
<c:forEach items="${baz}" var="livro">
    <li>${livro.titulo} - ${livro.descricao}
        <a href="${linkTo[LivrosController].edita}?isbn=${livro.isbn}">Modificar</a></li>
</c:forEach>
</ul>