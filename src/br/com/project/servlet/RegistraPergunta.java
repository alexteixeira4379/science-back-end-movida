package br.com.project.servlet;

import java.io.IOException;
import br.com.project.beans.Pergunta;
import br.com.project.beans.PerguntaCategoria;

import br.com.project.dao.*;
import br.com.project.bo.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Registra
 */
@WebServlet("/registrapergunta")
public class RegistraPergunta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistraPergunta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PerguntaCategoria c = new PerguntaCategoria();
		c.setTudo(1, "Teste");
		String titulo = request.getParameter("receberTitulo");

		String pergunta = request.getParameter("receberPergunta");
		String resposta = request.getParameter("receberResposta");
		int id = request.getParameter("receberid");
		Pergunta p = new Pergunta();
		p.setTudo(id, c, titulo, pergunta, resposta);
		
		if (PerguntaBO.novo(p)) {
			request.setAttribute("message",
					"Inserido com sucesso, se precisar cadastrar" + " mais um usu�rio, preencha os dados abaixo: <br>"
							+ "<a href=index.jsp>Clique para voltar para a index</a>");
		} else {
			request.setAttribute("message", "Problema na inser��o.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("inserir.jsp");
		dispatcher.forward(request, response);
	}
}
