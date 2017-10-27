package pe.cibertec.webapifurniture.services;

import java.util.ArrayList;

import pe.cibertec.webapifurniture.beans.ProductoBean;
import pe.cibertec.webapifurniture.dao.DAOFactory;
import pe.cibertec.webapifurniture.dao.ProductoDAO;

public class ProductoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProductoDAO d = factory.getProducto();
	
	public ArrayList<ProductoBean> listaProductosPorCategoria(String idCategoria){
		ArrayList<ProductoBean> l = new ArrayList<>();
		try {
			l = d.listaProductosPorCategoria(idCategoria);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}

}
