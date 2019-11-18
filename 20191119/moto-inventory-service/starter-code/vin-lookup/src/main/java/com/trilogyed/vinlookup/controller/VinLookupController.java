package com.trilogyed.vinlookup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.vinlookup.feign.MotorServiceFeign;
import com.trilogyed.vinlookup.model.Motorcycle;
import com.trilogyed.vinlookup.model.Vehicle;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class VinLookupController {

    @Autowired
    private final MotorServiceFeign motorServiceFeign;

    public VinLookupController(MotorServiceFeign motorServiceFeign) {
        this.motorServiceFeign = motorServiceFeign;
    }

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping (value = "/vehicle/{vin}", method = RequestMethod.GET)
    public Map<String,String> lookUpVehicle(@PathVariable String vin) throws IOException {
       Map<String, String> map = objectMapper.readValue(motorServiceFeign.getMotorcycleByVin(vin), Map.class);
       return buildResponseMap(map);
    }

    private Map<String, String> buildResponseMap(Map<String, String> map) {
        Map returnMap = new HashMap();
        returnMap.put("Vehicle Type", "Motorcycle");
        returnMap.put("Vehicle Make", map.get("make"));
        returnMap.put("Vehicle Model", map.get("model"));
        returnMap.put("Vehicle Year", map.get("year"));
        returnMap.put("Vehicle Color", map.get("color"));
        return returnMap;
    }

}