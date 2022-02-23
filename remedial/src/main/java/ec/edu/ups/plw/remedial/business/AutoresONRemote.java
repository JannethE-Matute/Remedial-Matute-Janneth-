package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.plw.remedial.model.Autor;

@Remote
public interface AutoresONRemote {
	public void insertar(Autor a) throws Exception;
	public List<Autor> getAutores();
	public Autor buscarautor(String cedula) throws Exception;
	public void guardar(Autor a) throws Exception;
	public Autor getAutor(String titulo) throws Exception;
}
