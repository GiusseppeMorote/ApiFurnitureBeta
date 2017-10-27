package pe.cibertec.webapifurniture.dao;

import java.util.ArrayList;

import pe.cibertec.webapifurniture.beans.ProductoBean;

public interface ProductoDAO {
	
	public ArrayList<ProductoBean> listaProductosPorCategoria(String idCategoria) throws Exception;

}
