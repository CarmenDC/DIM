package descargaWeb;

import java.util.ArrayList;
import java.util.Collection;

public class AppDescargaWeb {

	public static void main(String[] args) {
		//VARIABLES
		Double velocidadConn = 5.0;
		Collection<Fichero> listaFicheros = new ArrayList <Fichero>();
		ListaDescarga listaDeDescarga = new ListaDescarga();
		int[] listaElegida = new int[] {4,1,2,5}; //simula los n�meros que se introducir�an por pantalla de los IDs
		String tituloBuscar = "La Roca";
		String directorBuscar = "John Smith";
		String artistaBuscar = "Bon Jovi";
		
		//DATOS 
		Musica cancion1 = new Musica("We are the Champions", 4.3, "Queen");
		Musica cancion2 = new Musica("Love of my life", 3.7, "Queen");
		Musica cancion3 = new Musica("Runaway", 4.3, "Bon Jovi");
		Pelicula pelicula1 = new Pelicula("Mision imposible", 10.4);
		Pelicula pelicula2 = new Pelicula("La Roca", 7.3, "John Smith", new String[] {"Pepe", "Juan"});
		Pelicula pelicula3 = new Pelicula("El Hobbit", 12.6);	
		
		//INCLUYENDO DATOS EN COLLECION
		listaFicheros.add(cancion1);
		listaFicheros.add(cancion2);
		listaFicheros.add(cancion3);
		listaFicheros.add(pelicula1);
		listaFicheros.add(pelicula2);
		listaFicheros.add(pelicula3);

		
		//COMIENZA EJECUCI�N
		System.out.println ("Estos son los ficheros disponibles:");
		for (Fichero ficheros:listaFicheros) {
			System.out.println(ficheros.toString());
		}
		
		System.out.println ();
		System.out.println ("Introducir ID contenido que se quiere descargar");
		System.out.println ("Queremos descargar:"); //solo los de la lista de elegidos los ponemos en la colecci�n que se descargar�.
		for (int ids : listaElegida) {
			for (Fichero ficheros: listaFicheros) {
				if (ids == ficheros.getId())
					listaDeDescarga.incluirEnLista(ficheros);
		}
		}
		listaDeDescarga.imprimirLista();
		
//		for (int i = 0; i<listaDeDescarga.; i++) {
//			System.out.print(((ArrayList<Fichero>) listaDeDescarga).get(i).toString());
//			System.out.println (", t descarga= " + ((ArrayList<Fichero>) listaDeDescarga).get(i).calcularTiempoDescarga(velocidadConn)+"s");
//		}
		
		//imprimimos informe con los ficheros ordenados por Id, damos el tama�o total de la descarga y el tiempo en descargar
		System.out.println();
		System.out.println ("Informe de Descarga:");
		emitirInforme(listaDeDescarga, velocidadConn);

		//BUSCAR EN LOS FICHEROS
		System.out.println();
		System.out.println ("Buscamos fichero con los siguientes datos: T�tulo = " + tituloBuscar);
		for (Fichero fichero : listaFicheros) {
			if ( fichero.BuscarTitulo(tituloBuscar)) {
				System.out.println (fichero.toString());
			}
		}
		
		System.out.println ("Buscamos fichero con los siguientes datos: Artista = " + artistaBuscar);
		for (Fichero fichero : listaFicheros) {
			if (fichero.buscarArtista(artistaBuscar)) {
				System.out.println (fichero.toString());
			}
		}	
	
		System.out.println ("Buscamos fichero con los siguientes datos: Director = " + directorBuscar);
		for (Fichero fichero : listaFicheros) {
			if (fichero.buscarDirector(directorBuscar)) {
				System.out.println (fichero.toString());
			}
		}	
		
	}
	
	
	
	

	
	// M�TODOS
	
	private static void emitirInforme(ListaDescarga listaDeDescarga, double velocidadConexion) {
		double tiempoTotalDesc= listaDeDescarga.calcularTiempoDescarga(velocidadConexion);
		double tama�oTotalDesc = listaDeDescarga.getSizeDescarga();
		listaDeDescarga.ordenarLista();
		listaDeDescarga.imprimirLista();
		System.out.println ("Tama�o total de descarga= " + tama�oTotalDesc + "MB" );
		System.out.println ("Tiempo total de descarga= " + convertirTiempo (tiempoTotalDesc));
		}

	private static String convertirTiempo(double tsegundos) {
		   	Integer horas = (int) (tsegundos / 3600);
		    Integer minutos = (int) ((tsegundos-horas*3600)/60);
		    Integer segundos = (int) (tsegundos-(horas*3600+minutos*60));
		    return horas.toString() + ":" + minutos.toString() + ":" + segundos.toString();
		}
	

}
