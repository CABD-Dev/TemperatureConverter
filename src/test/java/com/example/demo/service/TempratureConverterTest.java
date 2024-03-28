package com.example.demo.service;

import com.example.demo.model.TempratureCelciusRequest;
import com.example.demo.model.TempratureCelciusResponse;
import com.example.demo.model.TempratureFahrenheitRequest;
import com.example.demo.model.TempratureFahrenheitResponse;
import com.example.demo.services.SimpleTemperatureConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class TempratureConverterTest {

    @InjectMocks
    SimpleTemperatureConverter simpleTemperatureConverter;

    @Test
    @DisplayName("Celcius Test Value 0 : ")
    void tempratureConverterCelciusTest(){
        TempratureCelciusRequest request = new TempratureCelciusRequest();
        request.setCelsius((double) 0);
        assertEquals(32.0, simpleTemperatureConverter.convertToFahrenheit(request));
    }

    @Test
    @DisplayName("Celcius Test Value 100 : ")
    void tempratureConverterCelcius2Test(){
        TempratureCelciusRequest request = new TempratureCelciusRequest();
        request.setCelsius(100.0);
        assertEquals(212.0, simpleTemperatureConverter.convertToFahrenheit(request));
    }

    @Test
    @DisplayName("Celcius Test Value -100 : ")
    void tempratureConverterCelcius3Test(){
        TempratureCelciusRequest request = new TempratureCelciusRequest();
        request.setCelsius(-100.0);
        assertEquals(-148.0, simpleTemperatureConverter.convertToFahrenheit(request));
    }

    @Test
    @DisplayName("Celcius Negative Test : ")
    void tempratureConverterCelciusNegative1(){
        assertThrows(ArithmeticException.class,() -> simpleTemperatureConverter.convertToFahrenheit(new TempratureCelciusRequest()));
    }

    @Test
    @DisplayName("Celcius Alphabet Negative Test : ")
    void tempratureConverterCelciusAlphabetNegative(){
        assertThrows(NumberFormatException.class,() -> simpleTemperatureConverter.convertToFahrenheit(TempratureCelciusRequest.builder()
                .celsius(Double.parseDouble("s"))
                .build()));
    }

    @Test
    @DisplayName("Celcius Expressions Negative Test : ")
    void tempratureConverterCelciusExpressionsNegative(){
        assertThrows(NumberFormatException.class,() -> simpleTemperatureConverter.convertToFahrenheit(TempratureCelciusRequest.builder()
                .celsius(Double.parseDouble("!"))
                .build()));
    }

    @Test
    @DisplayName("Fahrenheit Test Value 32 : ")
    void tempratureConverterFahrenheitTest(){
        TempratureFahrenheitRequest request = new TempratureFahrenheitRequest();
        request.setFahrenheit(32.0);
        assertEquals(0.0, simpleTemperatureConverter.convertToCelsius(request));
    }

    @Test
    @DisplayName("Fahrenheit Test Value 212 : ")
    void tempratureConverterFahrenheit2Test(){
        TempratureFahrenheitRequest request = new TempratureFahrenheitRequest();
        request.setFahrenheit(212.0);
        assertEquals(100.0, simpleTemperatureConverter.convertToCelsius(request));
    }

    @Test
    @DisplayName("Fahrenheit Test Value -212 : ")
    void tempratureConverterFahrenheit3Test(){
        TempratureFahrenheitRequest request = new TempratureFahrenheitRequest();
        request.setFahrenheit(-212.0);
        assertEquals(-135.556, simpleTemperatureConverter.convertToCelsius(request));
    }

    @Test
    @DisplayName("Fahrenheit Negative Test : ")
    void tempratureConverterFahrenheitNegativeTest(){
        assertThrows(ArithmeticException.class,() -> simpleTemperatureConverter.convertToCelsius(new TempratureFahrenheitRequest()));
    }

    @Test
    @DisplayName("Fahrenheit Alphabet Negative Test : ")
    void tempratureConverterFahrenheitNegativeAlphabetTest(){
        assertThrows(NumberFormatException.class,() -> simpleTemperatureConverter.convertToCelsius(TempratureFahrenheitRequest.builder()
                        .fahrenheit(Double.parseDouble("s"))
                .build()));
    }

    @Test
    @DisplayName("Fahrenheit Expressions Negative Test : ")
    void tempratureConverterFahrenheitNegativeExpressionsTest(){
        assertThrows(NumberFormatException.class,() -> simpleTemperatureConverter.convertToCelsius(TempratureFahrenheitRequest.builder()
                .fahrenheit(Double.parseDouble("!"))
                .build()));
    }

}
