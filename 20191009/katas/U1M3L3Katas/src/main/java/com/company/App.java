package com.company;

import java.util.*;

public class App {

    public void printKeys(HashMap<String, String> hashMap) {
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public void printValues(HashMap<String, String> hashMap) {
        Collection<String> myValues = hashMap.values();
        for (String value : myValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(HashMap<String, String> hashMap) {
        Set<Map.Entry<String, String>> myEntries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : myEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> map) {
        map.put("Toyota Camry", 2012);
        map.put("Chevy Camaro", 1969);
        map.put("Hyundai Genesis", 2015);
        map.put("Jeep Wrangler", 2003);
        map.put("Honda Civic", 2018);
        map.put("Pontiac GTO", 1964);
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler");
        return map;
    }

    public Map<String, List<Car>> listCars(List<Car> list) {
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();
        Map<String, List<Car>> resultMap = new HashMap<>();

        for (Car car : list) {
            if (car.getMake().equals("Toyota")) {
                toyotaList.add(car);
            } else if (car.getMake().equals("Ford")) {
                fordList.add(car);
            } else if (car.getMake().equals("Honda")) {
                hondaList.add(car);
            }
        }

        resultMap.put("Toyota", toyotaList);
        resultMap.put("Ford", fordList);
        resultMap.put("Honda", hondaList);

        return resultMap;
    }
}
