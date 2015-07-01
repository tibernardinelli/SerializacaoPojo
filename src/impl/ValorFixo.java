package impl;

import java.math.BigDecimal;

import intf.Argumento;

public class ValorFixo implements Argumento {

	private TipoCampo tipo;
	private Object valor;
	
	public ValorFixo(Object valor){
		if (valor instanceof Long || valor instanceof Integer || valor instanceof BigDecimal ){
			tipo = TipoCampo.Numerico;
		}
		else if (valor instanceof String ){
			tipo = TipoCampo.Alfanumerico;
		} else
			throw new RuntimeException();
		
		this.valor = valor;
	}
	
	
	enum TipoCampo {
		Numerico, Alfanumerico, Funcao
	}


	@Override
	public Object getObject() {
		return valor;
	}


	@Override
	public String getString() throws ClassCastException{
		if (tipo != TipoCampo.Alfanumerico)
			throw new ClassCastException();
		return (String) valor;
	}


	@Override
	public Long getLong() {
		if (tipo != TipoCampo.Numerico)
			throw new ClassCastException();
		return (Long) valor;	
	}
}
