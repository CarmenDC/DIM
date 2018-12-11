package appDescargaWeb;

public class Musica extends Fichero{
	


	Cantante cantante;
	
	
	//GETTERS AND SETTERS

	public Cantante getCantante() {
		return cantante;
	}


	@Override
	public String getTitulo() {
		return null;
	}
	
	
	//CONSTRUCTOR
	
	public Musica(int id, double tamano) {
		super(id, tamano);
	}

	
}
