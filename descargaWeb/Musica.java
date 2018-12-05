package descargaWeb;

public class Musica extends Fichero {
	
//	atributos
	
	String artista;
	
	
	
//	getter y setter

	String getArtista() {
		return artista;
	}

	void setArtista(String artista) {
		this.artista = artista;
	}

//constructores


	Musica(String titulo, double sizeMB, String artista) {
		super(titulo, sizeMB);
		this.artista= artista;
	
	}

	@Override
	public double getSizeDescarga() {
		return sizeMB;
	}

	@Override
	public double calcularTiempoDescarga(double velocidadDescarga) {
		return sizeMB/velocidadDescarga;
	}
	
	@Override
	public String toString() {
		return "Canción: Id=" + id + " " + titulo + ", tamaño="+ sizeMB + "MB";
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

	
}
