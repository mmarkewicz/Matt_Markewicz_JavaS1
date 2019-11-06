package com.company.MatthewMarkewiczU1Capstone.controller;

import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import com.company.MatthewMarkewiczU1Capstone.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleService consoleService;

    @GetMapping(value = "/consoles")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoles() {
        return consoleService.findAllConsoles();
    }

    @GetMapping(value = "/consoles/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) { return consoleService.findConsole(id); }

    @GetMapping(value = "/consoles/manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer) {
        return consoleService.findConsolesByManufacturer(manufacturer);
    }

    @PostMapping(value = "/consoles")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console postConsole(@RequestBody Console console) {
        return consoleService.saveConsole(console);
    }

    @PutMapping(value = "/consoles")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        consoleService.updateConsole(console);
    }

    @DeleteMapping(value = "/consoles/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleService.removeConsole(id);
    }
}
