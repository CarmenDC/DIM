package descargaWeb;

public abstract class Fichero implements Comparable<Fichero>, Descargable, Buscable { 

 
//	atributos
	private static int idFichero;
	int id;
	String titulo;
	double sizeMB;

	//getters and setters
	
	public int getId() {
		return id;
		
	}

	String getTitulo() {
		return titulo;
	}
	void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	double getSizeMB() {
		return sizeMB;
	}


	//CONSTRUCTORES
	Fichero(String titulo, double sizeMB) {
		this.id = darId();		
		this.titulo = titulo;
		this.sizeMB = sizeMB;
	}

	//OTROS MÉTODOS
	
	public int darId() {
		idFichero++;
		return id=idFichero;
		
	}

	@Override
	public Boolean BuscarTitulo(String Dato) {
		Boolean encontrado = false;
		if (getTitulo() == Dato) {
			encontrado = true;
		}
		return encontrado;
	}

		
	@Override
	public String toString() {
		return "id descarga =" + id + ", titulo=" + titulo + ", tamaño= " + sizeMB +"MB";
	
	}

	
}
