package pe.cibertec.webapifurniture.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pe.cibertec.webapifurniture.beans.CategoriaBean;
import pe.cibertec.webapifurniture.dao.CategoriaDAO;

public class CategoriaMysqlDAO implements CategoriaDAO{

	@Override
	public ArrayList<CategoriaBean> ListaCategorias() {
		ArrayList<CategoriaBean>listado=new ArrayList<>();
		CategoriaBean bean= null;
		String base = "furniture";
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "SELECT codigoCategoria,descripcionCategoria,estadoCategoria FROM categoria";
			connection=MysqlDAOFactory.obtenerConexion(base);
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				bean=new CategoriaBean();
				bean.setCodigo(rs.getString(1));
				bean.setDescripcon(rs.getString(2));
				bean.setEstado(rs.getInt(3));
				listado.add(bean);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error en CategoriaMysqlDAO() ==> "+e.getMessage());
			e.getLocalizedMessage();
		} finally {
			
		}
		
		return listado;
	}
	
	public static void main(String[] args) {
		CategoriaMysqlDAO metodo = new CategoriaMysqlDAO();
		
		for (int i = 0; i < metodo.ListaCategorias().size(); i++) {
			CategoriaBean cateoria= metodo.ListaCategorias().get(i);
			System.out.println(cateoria.getCodigo() + " "+cateoria.getDescripcon()+ " "+cateoria.getEstado());
			
		}
	}
	

}
