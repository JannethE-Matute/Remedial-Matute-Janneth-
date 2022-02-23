package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.plw.remedial.dao.LibroDAO;
import ec.edu.ups.plw.remedial.model.Libro;

@Stateless
public class LibroON implements LibrosONLocal, LibrosONRemote{
	@Inject
	private LibroDAO daoLibro;
	
	public void insertar(Libro l) throws Exception{
		
		daoLibro.insert(l);	
	}
	public void actualizarLibro(Libro libro) throws Exception {
		daoLibro.update(libro);
	}
	public List<Libro> getLibros(){
		return daoLibro.getList();
	}
	
	public Libro buscarlibro(String titulo) throws Exception{
		return daoLibro.read(titulo);
	}
	public void guardar(Libro l) throws Exception {
		if (daoLibro.read(l.getTitulo()) == null)
			daoLibro.insert(l);
		else
			daoLibro.update(l);
	}
	public Libro getLibro(String titulo) throws Exception {
		return daoLibro.read(titulo);
	}
}
