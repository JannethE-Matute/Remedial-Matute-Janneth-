package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.plw.remedial.model.Libro;

@Remote
public interface LibrosONRemote {
	public void insertar(Libro l) throws Exception;
	public List<Libro> getLibros();
	public Libro buscarlibro(String titulo) throws Exception;
	public void guardar(Libro l) throws Exception;
	public Libro getLibro(String titulo) throws Exception;
}
