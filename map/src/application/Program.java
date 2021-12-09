package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		// instancia��o do Map
		Map<String, String> cookies = new TreeMap<>();

		// insere a chave com parametro ap�s a v�rgula.
		cookies.put("username", "Guilherme");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "21976600054");

		// remove a chave informada dentro do parametro.
		cookies.remove("email");

		System.out.println("ALL COOKIES:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}

		/*
		 * ATEN��O: Map n�o aceita repeti��es, ele sempre sobrescreve as chamadas.
		 * Exemplo: 
		 * cookies.put("phone", "21976600054"); 
		 * cookies.put("phone", "2133461313");
		 * 
		 * Na execu��o do programa s� mostraria a chave "phone", "2133461313"
		 */

	}

}
