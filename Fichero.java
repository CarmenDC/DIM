package appDescargaWeb;

public abstract class Fichero implements IdenDescargable { // en lugar de Identificable, Descargable {
	
	private int id;
	double tamano;
//	String titulo;
	

//	String getTitulo() {
//		return titulo;
//	}

	@Override
	public double getTamano() {
		return tamano;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public abstract String getTitulo();//los ficheros tendrán un título pero no se sabe de donde sale, asi no tiene implementación
	
	
	//CONSTRUCTOR
	public Fichero(int id, double tamano) {
		super();
		this.id = id;
		this.tamano = tamano;
		
	}

	@Override
	public String toString() {
		return "Fichero [id=" + id + ", tamano=" + tamano + "]";
	} 

	
	

	
	
}
