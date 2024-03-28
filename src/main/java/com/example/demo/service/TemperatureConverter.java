package com.example.demo.service;

import com.example.demo.model.TempratureCelciusRequest;
import com.example.demo.model.TempratureFahrenheitRequest;

public interface TemperatureConverter {

    double convertToFahrenheit(TempratureCelciusRequest request);

    double convertToCelsius(TempratureFahrenheitRequest request);
}
