package descargaWeb;

import java.util.ArrayList;
import java.util.Collection;

public class AppDescargaWeb {
	
	static Collection<Fichero> listaFicheros = new ArrayList <Fichero>();


	public static void main(String[] args) {
		//VARIABLES
		Double velocidadConn = 2.0;
		ListaDescarga listaDeDescarga = new ListaDescarga();
		int[] listaElegida = new int[] {8,1,2,4}; //simula los números que se introducirían por pantalla de los IDs
		String tituloBuscar = "Ruway";
		String directorBuscar = "George Lucas";
		String artistaBuscar = "Bon Jovi";
		
		//DATOS 
		Musica cancion1 = new Musica("We are the Champions", 4.3, "Queen");
		Musica cancion2 = new Musica("Love of my life", 3.7, "Queen");
		Musica cancion3 = new Musica("Runaway", 4.3, "Bon Jovi");
		Musica cancion4 = new Musica("Aviones Plateados", 5.8, "El Ultimo de la Fila" );
		Pelicula pelicula1 = new Pelicula("Mision imposible", 10.4);
		Pelicula pelicula2 = new Pelicula("La Roca", 7.3, "John Smith", new String[] {"Pepe", "Juan"});
		Pelicula pelicula3 = new Pelicula("El Hobbit", 12.6);	
		Pelicula pelicula4 = new Pelicula("La Guerra de las Galaxias", 9.3, "George Lucas", new String[] {"Harrison Ford", "Carrie Fisher"});		
		
		//INCLUYENDO DATOS EN COLLECION
		listaFicheros.add(cancion1);
		listaFicheros.add(cancion2);
		listaFicheros.add(cancion3);
		listaFicheros.add(cancion4);
		listaFicheros.add(pelicula1);
		listaFicheros.add(pelicula2);
		listaFicheros.add(pelicula3);
		listaFicheros.add(pelicula4);

		
		//COMIENZA EJECUCIÓN
		System.out.println ("Estos son los ficheros disponibles:");
		for (Fichero ficheros:listaFicheros) {
			System.out.println(ficheros.toString());
		}
		
		System.out.println ();
		System.out.println ("Introducir ID contenido que se quiere descargar");
		System.out.println ("Queremos descargar:"); //solo los de la lista de elegidos los ponemos en la colección que se descargará.
		for (int ids : listaElegida) {
			for (Fichero ficheros: listaFicheros) {
				if (ids == ficheros.getId())
					listaDeDescarga.incluirEnLista(ficheros);
		}
		}
		listaDeDescarga.imprimirLista();
		

		System.out.println();
		System.out.println ("Informe de Descarga:");
		emitirInforme(listaDeDescarga, velocidadConn);

		//BUSCAR EN LOS FICHEROS
		System.out.println();
		System.out.println ("Buscamos fichero con los siguientes datos: Título = " + tituloBuscar);
		buscarDato (tituloBuscar);
		System.out.println ("Buscamos fichero con los siguientes datos: Artista = " + artistaBuscar);
		buscarDato(artistaBuscar);
		System.out.println ("Buscamos fichero con los siguientes datos: Director = " + directorBuscar);
		buscarDato(directorBuscar);
	}
	
	
	
	// MÉTODOS
	
	private static void buscarDato(String dato) {
		for (Fichero fichero : listaFicheros) {
			if ( fichero.BuscarTitulo(dato)) {
				System.out.println (fichero.toString());
			}
			else { 
				if ( fichero.buscarArtista(dato)) {
					System.out.println (fichero.toString());
					}
				else {
					if ( fichero.buscarDirector(dato)) {
						System.out.println (fichero.toString());
					}
				}	
			}
		}
	
	}

	private static void emitirInforme(ListaDescarga listaDeDescarga, double velocidadConexion) {
		double tiempoTotalDesc= listaDeDescarga.calcularTiempoDescarga(velocidadConexion);
		double tamañoTotalDesc = listaDeDescarga.getSizeDescarga();
		listaDeDescarga.ordenarLista();
		listaDeDescarga.imprimirLista();
		System.out.println ("Tamaño total de descarga= " + tamañoTotalDesc + "MB" );
		System.out.println ("Tiempo total de descarga= " + convertirTiempo (tiempoTotalDesc));
		}

	private static String convertirTiempo(double tsegundos) {
		   	Integer horas = (int) (tsegundos / 3600);
		    Integer minutos = (int) ((tsegundos-horas*3600)/60);
		    Integer segundos = (int) (tsegundos-(horas*3600+minutos*60));
		    return horas.toString() + ":" + minutos.toString() + ":" + segundos.toString();
		}
	

}
