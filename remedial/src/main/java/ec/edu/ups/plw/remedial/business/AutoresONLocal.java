package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.plw.remedial.model.Autor;

@Local
public interface AutoresONLocal {
	public void insertar(Autor a) throws Exception;
	public List<Autor> getAutores();
	public Autor buscarautor(String cedula) throws Exception;
	public void guardar(Autor a) throws Exception;
	public Autor getAutor(String cedula) throws Exception;
}
