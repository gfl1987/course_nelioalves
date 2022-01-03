package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Conceito de Stream: Stream é uma sequencia de dados

		/*função map ela aplica uma função a cada elemento do stream, 
		* gerando uma nova stream com os elementos transformados
		* essa expressão é chamada de inline e 
		* serve para converter todos os nomes dos produtos para caixa alta 
		*/ 
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
				
		names.forEach(System.out::println);
	}
}