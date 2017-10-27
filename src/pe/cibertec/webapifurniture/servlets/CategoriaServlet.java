package pe.cibertec.webapifurniture.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import pe.cibertec.webapifurniture.beans.CategoriaBean;
import pe.cibertec.webapifurniture.services.CategoriaService;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getParameter("accion");
		System.out.println(metodo);
		if (metodo.equals("listadoCategoria")) {
			listadoCategoria(request, response);
		}

	}

	private void listadoCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		// imprimir los datos del servlet
		PrintWriter pw = response.getWriter();
		CategoriaService service = new CategoriaService();
		// lleno mi servicio en una lista
		ArrayList<CategoriaBean> lista = service.ListaCategorias();
		// llenando la lista en un arraylist de tipo de json
		// este json te pide un arraylist
		JSONArray jarray = new JSONArray(lista);
		pw.println(jarray);

	}

}
