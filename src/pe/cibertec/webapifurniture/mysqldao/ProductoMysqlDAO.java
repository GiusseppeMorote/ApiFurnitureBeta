package pe.cibertec.webapifurniture.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import pe.cibertec.webapifurniture.beans.ProductoBean;
import pe.cibertec.webapifurniture.dao.ProductoDAO;

public class ProductoMysqlDAO implements ProductoDAO {


	@Override
	public ArrayList<ProductoBean> listaProductosPorCategoria(String idCategoria) throws Exception {
		ArrayList<ProductoBean> lista = new ArrayList<>();
		String base = "furniture";
		Connection cn = MysqlDAOFactory.obtenerConexion(base);
		String sql 
				= " select a.descripcionProducto,"
				+ " a.idTipo,"
				+ " b.descripcionTipo, "
				+ " c.descripcionCategoria "
				+ " from producto a "
				+ " inner join tipo b "
				+ " on a.idTipo=b.idTipo "
				+ " inner join categoria c "
				+ " on b.idCategoria=c.idCategoria "
				+ " where c.idCategoria=? ";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, idCategoria);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ProductoBean b = new ProductoBean();
			b.setDescripcionProducto(rs.getString(1));
			b.setIdTipo(rs.getString(2));
			b.setDescripcionTipo(rs.getString(3));
			b.setDescripcionCategoria(rs.getString(4));
			lista.add(b);
		}
		return lista;
	}

	public static void main(String[] args) throws Exception {
		ProductoMysqlDAO d = new ProductoMysqlDAO();
		for (int i = 0; i < d.listaProductosPorCategoria("2").size(); i++) {
			ProductoBean b = d.listaProductosPorCategoria("2").get(i);
			System.out.println(b.getDescripcionProducto()+"-"+b.getIdTipo()+"-"+b.getIdCategoria());
		}
	}
	
}
