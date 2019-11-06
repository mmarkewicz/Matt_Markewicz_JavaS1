package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao.ConsoleRepository;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConsoleService {

    @Autowired
    ConsoleRepository consoleRepository;

    public Console saveConsole(Console console) {
        return consoleRepository.save(console);
    }

    public Console getConsole(int id) {
        return consoleRepository.getOne(id);
    }

    public List<Console> getAllConsoles() {
        return consoleRepository.findAll();
    }

    public Console updateConsole(Console console) {
        return consoleRepository.save(console);
    }
}
