package pe.cibertec.webapifurniture.beans;

import java.io.Serializable;

public class CategoriaBean implements Serializable{
	
	private String codigo;
	private String descripcon;
	private int estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcon() {
		return descripcon;
	}
	public void setDescripcon(String descripcon) {
		this.descripcon = descripcon;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
