package ec.edu.ups.plw.remedial.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.plw.remedial.dao.AutorDAO;
import ec.edu.ups.plw.remedial.model.Autor;

@Stateless
public class AutorON implements AutoresONLocal, AutoresONRemote{
	@Inject
	private AutorDAO daoAutor;
	
	public void insertar(Autor a) throws Exception{
		
		daoAutor.insert(a);	
	}
	public void actualizarAutor(Autor autor) throws Exception {
		daoAutor.update(autor);
	}
	public List<Autor> getAutores(){
		return daoAutor.getList();
	}
	
	public Autor buscarautor(String cedula) throws Exception{
		return daoAutor.read(cedula);
	}
	public void guardar(Autor a) throws Exception {
		if (daoAutor.read(a.getCedula()) == null)
			daoAutor.insert(a);
		else
			daoAutor.update(a);
	}
	public Autor getAutor(String cedula) throws Exception {
		return daoAutor.read(cedula);
	}
}
