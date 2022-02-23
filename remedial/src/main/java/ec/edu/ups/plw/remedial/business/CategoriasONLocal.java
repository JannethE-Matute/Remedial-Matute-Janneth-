package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.plw.remedial.model.Categoria;

@Local
public interface CategoriasONLocal {
	public void insertar(Categoria c) throws Exception;
	public List<Categoria> getCategorias();
	public Categoria buscarcategoria(String seccion) throws Exception;
	public void guardar(Categoria c) throws Exception;
	public Categoria getCategoria(String seccion) throws Exception;
}
