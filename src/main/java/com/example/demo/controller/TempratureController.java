package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.services.TemperatureConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Controller
public class TempratureController {

    @Autowired
    TemperatureConverter iTempratureConverter;

    @GetMapping("/convertToFahrenheit")
    public BaseResponse convertToFahrenheit (TempratureCelciusRequest request){
        BaseResponse response = new BaseResponse();
        TempratureCelciusResponse data = new TempratureCelciusResponse();
        data.setFahrenheit(iTempratureConverter.convertToFahrenheit(request));
        response.setCode("200");
        response.setMessage("Converted Successfully");
        response.setData(request.getCelsius()+" celsius equals "+ data.getFahrenheit() + " fahrenheit");
        return response;
    }

    @GetMapping("/convertToCelsius")
    public BaseResponse convertToCelsius (TempratureFahrenheitRequest request){
        BaseResponse response = new BaseResponse();
        TempratureFahrenheitResponse data = new TempratureFahrenheitResponse();
        data.setCelcius(iTempratureConverter.convertToCelsius(request));
        response.setCode("200");
        response.setMessage("Converted Successfully");
        response.setData(request.getFahrenheit() + " fahrenheit equals " + data.getCelcius() + " celsius");
        return response;
    }
}
