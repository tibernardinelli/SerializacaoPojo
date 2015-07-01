package impl;

import intf.Argumento;
import intf.Aritimetico;
import intf.Logico;

import java.util.List;

public class Divisao implements Aritimetico, Argumento {

	public List<Argumento> argumentos;

	@Override
	public Long executaOperacao() {
		Long resultado = null;
		for (Argumento argumento : argumentos) {
			if (resultado == null){
				resultado = argumento.getLong();
				continue;
			}
			resultado = resultado / argumento.getLong();
		}
		
		return resultado;
	}

	@Override
	public Object getObject() {
		return executaOperacao();
	}

	@Override
	public String getString() {
		throw new ClassCastException();
	}

	@Override
	public Long getLong() {
		
		return executaOperacao();
	}
}
