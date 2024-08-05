package com.devsuperior.firstchallenge;

import com.devsuperior.firstchallenge.entities.Order;
import com.devsuperior.firstchallenge.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FirstchallengeApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(FirstchallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira o código do pedido: ");
		Integer code = scanner.nextInt();

		System.out.println("Insira o valor básico do pedido: ");
		double basic = scanner.nextDouble();

		System.out.println("Insira a porcentagem de desconto do pedido: ");
		double discount = scanner.nextDouble();

		Order order = new Order(code, basic, discount);
		double totalValue = orderService.total(order);

		System.out.printf("%nPedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", totalValue);

		scanner.close();
	}
}
