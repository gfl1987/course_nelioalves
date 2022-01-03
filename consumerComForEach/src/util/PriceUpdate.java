package util;

import java.util.function.Consumer;

import entities.Product;

//Implementação do consumer
public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
}