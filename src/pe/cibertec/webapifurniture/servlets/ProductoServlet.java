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

import pe.cibertec.webapifurniture.beans.ProductoBean;
import pe.cibertec.webapifurniture.services.ProductoService;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String metodo = request.getParameter("accion");
		System.out.println(metodo);
		if (metodo.equals("listadoProductoPorCategoria")) {
			listadoProductoPorCategoria(request, response);
		}
	}

	private void listadoProductoPorCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		String idCategoria = request.getParameter("idCategoria");
		System.out.println("qqqq =>"+idCategoria);
		ProductoService service = new ProductoService();
		ArrayList<ProductoBean> lista = service.listaProductosPorCategoria(idCategoria);
		JSONArray jarray = new JSONArray(lista);
		pw.println(jarray);
	}

}
