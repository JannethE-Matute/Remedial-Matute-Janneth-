package ec.edu.ups.plw.remedial.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.plw.remedial.business.LibrosONLocal;
import ec.edu.ups.plw.remedial.model.Libro;

@Named
@RequestScoped
public class LibrosBean {
	
	@Inject
	private LibrosONLocal libroON;
	
	@PostConstruct
	public void init() {
		this.loadlibros();
	}
	private Libro libro = new Libro();
	private List<Libro> libros;
	private String titulo;
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String editar(String titulo) {
		System.out.println(titulo);
		return "libro?faces-redirect=true&id=" + libro;
	}
	public void pruebaconexion() {
		System.out.println("si entra a esta funcoin");
		
	}
	public String guardar() {
		System.out.println("guardando..."+this.libro.getEditorial());
		
		try {
			libroON.guardar(this.libro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listadolibros?faces-redirect=true";
	}
	public void loadlibros() {
		this.libros = libroON.getLibros();
	}
	
	public void loadData() {
		if(titulo==null)
			return;
		
		Libro l;
		try {
			l = libroON.getLibro(titulo);
			libro=l;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadDataEditar() {
		Libro l;
		try {
			l = libroON.getLibro(libro.getTitulo());
			libro=l;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
