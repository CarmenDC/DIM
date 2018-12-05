package descargaWeb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AppDescargaWeb {

	public static void main(String[] args) {
		//VARIABLES
		Double velocidadConn = 5.0;
		Collection<Fichero> listaFicheros = new ArrayList <Fichero>();
		Collection<Fichero> listaDescarga = new ArrayList <Fichero>();
		int[] listaElegida = new int[] {4,1,2,5}; //simula los n�meros que se introducir�an por pantalla de los IDs
		
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
					a�adir (ficheros, listaDescarga);
				}
		}
		
		
		for (int i = 0; i<listaDescarga.size(); i++) {
			System.out.print(((ArrayList<Fichero>) listaDescarga).get(i).toString());
			System.out.println (", t descarga= " + ((ArrayList<Fichero>) listaDescarga).get(i).calcularTiempoDescarga(velocidadConn)+"s");
		}
		
		//imprimimos informe con los ficheros ordenados por Id, damos el tama�o total de la descarga y el tiempo en descargar
		System.out.println();
		System.out.println ("Informe de Descarga:");
		emitirInforme(listaDescarga, velocidadConn);

	}

	
	// M�TODOS
	private static void a�adir(Fichero ficheros, Collection<Fichero> listaDescarga) {
		listaDescarga.add(ficheros);
	}

	private static void emitirInforme(Collection<Fichero> listaDescarga, double velocidadConexion) {
		double tiempoTotalDesc=0.0;
		double tama�oTotalDesc=0.0;
		Collections.sort((List<Fichero>) listaDescarga);
		for (Fichero ficheros: listaDescarga) {
			tiempoTotalDesc += ficheros.calcularTiempoDescarga(velocidadConexion);
			tama�oTotalDesc += ficheros.sizeMB;
			System.out.println (ficheros.toString());
			}

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
