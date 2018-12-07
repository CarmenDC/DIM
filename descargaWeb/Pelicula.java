package descargaWeb;


public class Pelicula extends Fichero {

//	ATRIBUTOS
	
	String director;
	String [] actores;
	

	
//GETTERS SETTERS
	
	
	String getDirector() {
		return director;
	}

	void setDirector(String director) {
		this.director = director;
	}

	String[] getActores() {
		return actores;
	}

	void setActores(String[] actores) {
		this.actores = actores;
	}

	
//CONSTRUCTORES	
	Pelicula(String titulo, double d) {
		super(titulo, d);
	
	}

	Pelicula (String titulo, double sizeMB, String director, String[] actores) {
		super (titulo, sizeMB);
		this.director = director;
		this.actores = actores;
	}

	@Override
	public double getSizeDescarga() {
		return sizeMB;
	}

	@Override
	public double calcularTiempoDescarga(double velocidadDescarga) {
		return getSizeDescarga()/velocidadDescarga;
	}

	@Override
	public String toString() {
		return "Película: Id=" + id + " " + titulo + ", tamaño="+ sizeMB + "MB";
	}

	public Boolean Buscar(String Dato) {
		Boolean encontrado = false;
		if (getDirector() == Dato) {
			encontrado = true;
		}
		return encontrado;
	}
	
	
	@Override
	public int compareTo(Fichero o) {
		int r = 0;
		if (id < o.id) {
			r= -1;
		}
		if (id > o.id) {
			r= 1;
		}
		return r;
	}

	@Override
	public Boolean buscarArtista(String Dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean buscarDirector(String Dato) {
		Boolean encontrado = false;
		if (getDirector() == Dato) {
			encontrado = true;
		}
		return encontrado;
	}


}
