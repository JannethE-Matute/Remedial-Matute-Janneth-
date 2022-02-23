package ec.edu.ups.plw.remedial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.plw.remedial.model.Libro;

@Stateless
public class LibroDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Libro l) {
		em.persist(l);
	}
	
	public void update(Libro l) {
		em.merge(l);
	}
	
	public Libro read(String titulo) {
		Libro l= em.find(Libro.class, titulo);
		return l;
	}
	
	
	public void delete(int id) {
		Libro l= em.find(Libro.class, id);
		em.remove(l);
	}
	public List<Libro> getList(){
		List<Libro> listado=new ArrayList<Libro>();
		String jpql="SELECT l FROM Libro l";
		Query query= em.createQuery(jpql,Libro.class);
		listado = query.getResultList();
		return listado;
	}
	public Libro readautores(String nombre) {
		Libro l= em.find(Libro.class, nombre);
		l.getCategoria().getSeccion();
		l.getAutor().size();
		return l;
	}
}
