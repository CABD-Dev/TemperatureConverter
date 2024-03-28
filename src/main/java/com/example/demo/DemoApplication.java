package com.example.demo;

import com.example.demo.model.TempratureCelciusRequest;
import com.example.demo.model.TempratureCelciusResponse;
import com.example.demo.model.TempratureFahrenheitRequest;
import com.example.demo.services.TemperatureConverter;
import com.example.demo.services.SimpleTemperatureConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	static TemperatureConverter converter = new SimpleTemperatureConverter();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		boolean status = true;
		while(status){
			System.out.print("Enter a temperature: ");
			double temperature = scanner.nextDouble();

			System.out.print("(C)elsius or (F)ahrenheit: ");
			char unit = scanner.next().toUpperCase().charAt(0);

			double convertedTemperature;
			if (unit == 'C') {
				convertedTemperature = converter.convertToFahrenheit(TempratureCelciusRequest.builder()
						.celsius(temperature)
						.build());
				System.out.println(temperature + " degrees Celsius is equal to " + convertedTemperature + " degrees Fahrenheit.");
			} else if (unit == 'F') {
				convertedTemperature = converter.convertToCelsius(TempratureFahrenheitRequest.builder()
						.fahrenheit(temperature)
						.build());
				System.out.println(temperature + " degrees Fahrenheit is equal to " + convertedTemperature + " degrees Celsius.");
			} else {
				System.out.println("Invalid unit. Please enter 'C' or 'F'.");
			}
			System.out.println("Do you want to terminate the application ? Y/N");
			char terminate = scanner.next().toUpperCase().charAt(0);
			if(terminate == 'Y'){
				System.out.println("Terminating Application ...");
				System.exit(0);
			}
		}
	}
}