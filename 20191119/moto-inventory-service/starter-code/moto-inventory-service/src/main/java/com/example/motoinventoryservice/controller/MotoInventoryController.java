package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.dao.MotoInventoryRepository;
import com.example.motoinventoryservice.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RefreshScope
public class MotoInventoryController {

    @Autowired
    private MotoInventoryRepository motoInventoryRepository;

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        motorcycle = motoInventoryRepository.save(motorcycle);
        return motorcycle;
    }

    @RequestMapping(value = "/motorcycles/something/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        if (motoId < 1) {
           throw new IllegalArgumentException("MotoId must be greater than 0.");
        }

        return motoInventoryRepository.getOne(motoId);
    }

    @RequestMapping(value = "/motorcycles/{vin}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycleByVin(@PathVariable("vin") String vin) {
        if (vin.equals("")) {
            throw new IllegalArgumentException("You must supply a vin!");
        }
        System.out.println(vin);
        return motoInventoryRepository.findByVin(vin);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {
        // do nothing here - in a real application we would delete the entry from
        // the backing data store.
    }

    @RequestMapping(value = "/motorcycles/{motoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle motorcycle, @PathVariable int motoId) {
        // make sure the motoId on the path matches the id of the motorcycle object
        if (motoId != motorcycle.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }

        // do nothing here - in a real application we would update the entry in the backing data store

    }
}
