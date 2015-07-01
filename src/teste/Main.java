package teste;

import impl.Divisao;
import impl.Soma;
import impl.ValorFixo;
import intf.Argumento;
import intf.Aritimetico;
import intf.Operacao;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {
 
	public static void main(String[] args) {
		
		Soma soma = new Soma();
		soma.argumentos = new ArrayList<Argumento>();
		soma.argumentos.add(new ValorFixo(1l));
		soma.argumentos.add(new ValorFixo(2l));
		soma.argumentos.add(new ValorFixo(2l));
		
		Divisao divisao = new Divisao();
		divisao.argumentos = new ArrayList<Argumento>();
		ValorFixo valorFixo = new ValorFixo(10l);
		divisao.argumentos.add(valorFixo);
		divisao.argumentos.add(soma);
		
		
		XStream xStream = new XStream(new DomDriver());
		String xml = xStream.toXML(divisao);
		System.out.println(xml);
		
		Operacao operacao = (Operacao) xStream.fromXML(xml);
		Object valor = operacao.executaOperacao();
		System.out.println(valor);
	}
}
