package com.example.demo.service;

import com.example.demo.model.TempratureCelciusRequest;
import com.example.demo.model.TempratureFahrenheitRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SimpleTemperatureConverter implements TemperatureConverter {

    @Override
    public double convertToFahrenheit(TempratureCelciusRequest request) {
        if (request.getCelsius() != null ) {
            double fahrenheit = (((request.getCelsius() * 9) / 5) + 32);
            BigDecimal bd = new BigDecimal(Double.toString(fahrenheit));
            bd = bd.setScale(3, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }else {
            throw new ArithmeticException();
        }
    }

    @Override
    public double convertToCelsius(TempratureFahrenheitRequest request) {
        if (request.getFahrenheit() != null){
            double celcius = ((request.getFahrenheit() - 32 ) * 5 ) / 9;
            BigDecimal bd = new BigDecimal(Double.toString(celcius));
            bd = bd.setScale(3, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }else {
            throw new ArithmeticException();
        }

    }

}
