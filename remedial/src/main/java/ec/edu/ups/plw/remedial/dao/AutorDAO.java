package ec.edu.ups.plw.remedial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.plw.remedial.model.Autor;

@Stateless
public class AutorDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Autor a) {
		em.persist(a);
	}
	
	public void update(Autor a) {
		em.merge(a);
	}
	
	public Autor read(String cedula) {
		Autor a= em.find(Autor.class, cedula);
		return a;
	}
	
	public void delete(int id) {
		Autor a= em.find(Autor.class, id);
		em.remove(a);
	}
	public List<Autor> getList(){
		List<Autor> listado=new ArrayList<Autor>();
		String jpql="SELECT a FROM Autor a";
		Query query= em.createQuery(jpql,Autor.class);
		listado = query.getResultList();
		return listado;
	}
}


