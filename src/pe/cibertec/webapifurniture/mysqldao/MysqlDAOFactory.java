package pe.cibertec.webapifurniture.mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;

import pe.cibertec.webapifurniture.dao.CategoriaDAO;
import pe.cibertec.webapifurniture.dao.DAOFactory;
import pe.cibertec.webapifurniture.dao.ProductoDAO;

public class MysqlDAOFactory extends DAOFactory{
	static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public static Connection obtenerConexion(String nombre_bd){
        Connection conexion = null;
        if(nombre_bd.equals("furniture")){
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture", "root", "mysql");
            } catch (Exception e) {
                e.printStackTrace();
            }                              
        }
         return conexion;
    }

	@Override
	public CategoriaDAO getCategoria() {		
		return new CategoriaMysqlDAO();
	}

	@Override
	public ProductoDAO getProducto() {
		return new ProductoMysqlDAO();
	}
}
