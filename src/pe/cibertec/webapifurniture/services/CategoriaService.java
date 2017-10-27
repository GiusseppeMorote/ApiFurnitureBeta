package pe.cibertec.webapifurniture.services;

import java.util.ArrayList;

import pe.cibertec.webapifurniture.beans.CategoriaBean;
import pe.cibertec.webapifurniture.dao.CategoriaDAO;
import pe.cibertec.webapifurniture.dao.DAOFactory;

public class CategoriaService {

	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	CategoriaDAO objCategoria=factory.getCategoria();
	
	public ArrayList<CategoriaBean> ListaCategorias() {
		ArrayList<CategoriaBean>listado=new ArrayList<>();
		try {
			listado = objCategoria.ListaCategorias();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error en CategoriaService () ==>"+e.getMessage());
			e.getLocalizedMessage();
		}
		
		return listado;
	}
	
}
