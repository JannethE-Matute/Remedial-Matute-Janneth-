package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.plw.remedial.dao.CategoriaDAO;
import ec.edu.ups.plw.remedial.model.Categoria;

@Stateless
public class CategoriaON implements CategoriasONLocal, CategoriasONRemote{
	@Inject
	private CategoriaDAO daoCategoria;
	
	public void insertar(Categoria c) throws Exception{
		
		daoCategoria.insert(c);	
	}
	public void actualizarCategoria(Categoria categoria) throws Exception {
		daoCategoria.update(categoria);
	}
	public List<Categoria> getCategorias(){
		return daoCategoria.getList();
	}
	
	public Categoria buscarcategoria(String seccion) throws Exception{
		return daoCategoria.read(seccion);
	}
	public void guardar(Categoria c) throws Exception {
		if (daoCategoria.read(c.getSeccion()) == null)
			daoCategoria.insert(c);
		else
			daoCategoria.update(c);
	}
	public Categoria getCategoria(String seccion) throws Exception {
		return daoCategoria.read(seccion);
	}
}
