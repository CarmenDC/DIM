package appDescargaWeb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.InternationalFormatter;

import descargaWeb.ListaDescarga;

public class App {

//	public static <T extends Identificable & Descargables> void main(String[] args) {
		
		
//		Collection<T> listaDescargas;
	
		public static void main(String[] args) {
		
		
		Collection<IdenDescargable> listaDescargas = new ArrayList<>(); 
		Velocidad velocidad = new Velocidad(20.0);
		
	
		listaDescargas.add(new Musica(2, 3.4)); // hemos puesto en Fichero IdenDescargable
		listaDescargas.add(new Pelicula(1, 904.5));
		listaDescargas.add(new Musica(4, 10.3));
		listaDescargas.add(new Pelicula(3, 725.3));
		
		listaDescargas = ordenarDescargas(listaDescargas);
		
		System.out.println(construirInforme (listaDescargas, velocidad));
		} 
		
			
	

	private static double calcularTamañoTotal (Collection<IdenDescargable> descargas) {
		double total=0;
		for (Descargable descargable: descargas) {
			total += descargable.getTamano();
		}
		return total;
	}	
	
	private static double calcularTiempoDescarga (Collection<IdenDescargable> descargas, Conexion conexion) {
		return calcularTamañoTotal(descargas)/conexion.getVelocidad();
	
		
	}
	
	private static String formatearTiempo (double tsegundos) {
		int horas = (int) (tsegundos / 3600);
		int minutos = (int) (tsegundos - horas*3600)/60;
		int segundos = (int) (tsegundos - horas*3600 - minutos*60);
		return "" + horas +":"+ minutos+":"+ segundos;
		
	}
		
	private static <T extends Identificable> Collection<T> ordenarDescargas (Collection<T> descargas){ //genericos tipo variable (T) puede ser otra letra
		List<T> listaOrdenada = new ArrayList<>(descargas);			// la coleccion que devuelve ordenada es del mismo tipo T, el extends dice una condicion que implemente identificable (fichero, pelicula, músilca, idendescargable... todos pasaría
//		listaOrdenada.sort(null);
		
//		listaOrdenada.sort(new ComparadorDeIdentificables()); // con una clase creada
		
//		listaOrdenada.sort(new Comparator<T>() { // con clase anonima
//
//			@Override
//			public int compare(T o1, T o2) {
//				return -o1.getId()+o2.getId();
//			}
//			
//		});
		
//		listaOrdenada.sort((o1,o2)-> o2.getId() - o1.getId());// con landas
		listaOrdenada.sort(Comparator.comparingInt(Identificable::getId));
		return listaOrdenada;
	}
	
	private static String construirInforme (Collection<IdenDescargable> descargas, Conexion conexion) {
		String informe = "";
		for (IdenDescargable idenDescargable : descargas) {
			informe += "\n" + idenDescargable.toString();
 		}
		informe += "\n" + "El tamaño total de la descarga es: " + calcularTamañoTotal(descargas)+ " MB";
		informe += "\n" + "El tiempo total de la descarga es: " + formatearTiempo(calcularTiempoDescarga(descargas, conexion));
 		return informe;
	}
	

	
}
