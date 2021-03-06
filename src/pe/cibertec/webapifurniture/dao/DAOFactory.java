package pe.cibertec.webapifurniture.dao;

import pe.cibertec.webapifurniture.mysqldao.MysqlDAOFactory;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	// public static final int ORACLE = 2;
	// public static final int DB2 = 3;
	// public static final int SQLSERVER = 4;
	// public static final int XML = 5;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MysqlDAOFactory();
		/*
		 * case SQLSERVER: return new SqlserverDAOFactory();
		 */
		/*
		 * case ORACLE: return new OracleDAOFactory(); case DB2: return new
		 * Db2DAOFactory(); case SQLSERVER: return new SqlServerDAOFactory();
		 * case XML: return new XmlDAOFactory();
		 */
		default:
			return null;
		}
	}
	
	public abstract CategoriaDAO getCategoria();
	public abstract ProductoDAO getProducto();
}