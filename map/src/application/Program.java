package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		// instanciação do Map
		Map<String, String> cookies = new TreeMap<>();

		// insere a chave com parametro após a vírgula.
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
		 * ATENÇÃO: Map não aceita repetições, ele sempre sobrescreve as chamadas.
		 * Exemplo: 
		 * cookies.put("phone", "21976600054"); 
		 * cookies.put("phone", "2133461313");
		 * 
		 * Na execução do programa só mostraria a chave "phone", "2133461313"
		 */

	}

}
