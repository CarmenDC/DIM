package descargaWeb;

public interface Descargable {
	
	int getId ();
	
	double getSizeDescarga ();
		
	double calcularTiempoDescarga (double velocidadConexion);

}
