package appDescargaWeb;

import java.util.Collection;

public class Pelicula extends Fichero {
	
	

	String Director;
	Collection <Actor> actoresPrincipales;

	@Override
	public String getTitulo() {
		return null;
	}

	public String getDirector() {
		return Director;
	}

	public Collection<Actor> getActoresPrincipales() {
		return actoresPrincipales;
	}

	//CONSTRUCTOR 
	
	public Pelicula(int id, double tamano) {
		super(id, tamano);
	}
	
}
