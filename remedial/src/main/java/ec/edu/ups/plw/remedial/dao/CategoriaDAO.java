package ec.edu.ups.plw.remedial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.plw.remedial.model.Categoria;

@Stateless
public class CategoriaDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Categoria c) {
		em.persist(c);
	}
	
	public void update(Categoria c) {
		em.merge(c);
	}
	
	public Categoria read(String seccion) {
		Categoria c= em.find(Categoria.class, seccion);
		return c;
	}
	
	public void delete(int id) {
		Categoria c= em.find(Categoria.class, id);
		em.remove(c);
	}
	public List<Categoria> getList(){
		List<Categoria> listado=new ArrayList<Categoria>();
		String jpql="SELECT c FROM Categoria c";
		Query query= em.createQuery(jpql,Categoria.class);
		listado = query.getResultList();
		return listado;
	}
}

