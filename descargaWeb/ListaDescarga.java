package descargaWeb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ListaDescarga implements Descargable {
	
	Collection<Fichero> listaAdescargar  = new ArrayList <Fichero> () ;

	public void incluirEnLista (Fichero fichero) {
		listaAdescargar.add(fichero);			
		}
	
	
	@Override
	public double getSizeDescarga() {
		double tama�oTotal = 0.0;
		for (Fichero objeto: listaAdescargar) {
			tama�oTotal += objeto.getSizeMB();			
		}
		return tama�oTotal;
	}

	@Override
	public double calcularTiempoDescarga(double velocidadConexion) {
		double tiempoTotal = 0.0;
		for (Fichero objeto: listaAdescargar) {
			tiempoTotal += objeto.getSizeMB()/velocidadConexion;			
		}
		return tiempoTotal;
	}


	public void ordenarLista () {
		Collections.sort((List<Fichero>) listaAdescargar);
	}
	
	public void imprimirLista () {
		for (Fichero fichero: listaAdescargar) {
			System.out.println (fichero.toString());
		}
	}
	
	

}
