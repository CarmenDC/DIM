package appDescargaWeb;

public interface Identificable extends Comparable<Identificable> {
	
	int getId();
	
	@Override
	default int compareTo(Identificable elOtro) {
		return getId() - elOtro.getId();
	}

}
