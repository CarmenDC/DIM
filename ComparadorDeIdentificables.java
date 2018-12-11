package appDescargaWeb;

import java.util.Comparator;

public class ComparadorDeIdentificables implements Comparator<Identificable> {

	@Override
	public int compare(Identificable arg0, Identificable arg1) {
	
		return -arg0.getId()+arg1.getId(); // compara en orden inverso
	}


}
