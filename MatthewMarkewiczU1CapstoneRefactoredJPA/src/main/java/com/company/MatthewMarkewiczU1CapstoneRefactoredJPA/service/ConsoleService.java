package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao.ConsoleRepository;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class ConsoleService {

    ConsoleRepository consoleRepository;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public Console saveConsole(Console console) throws Exception {
        try {
            return consoleRepository.save(console);
        } catch (Exception e) {
            throw new Exception("SQL Error: Make sure your request is formatted properly");
        }
    }

    public Console findConsole(int id) throws Exception {
        try {
            return consoleRepository.getOne(id);
        } catch (Exception e) {
            throw new Exception("There is no console in the database with that ID");
        }
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) throws Exception {
        try {
            return consoleRepository.findConsolesByManufacturer(manufacturer);
        } catch (Exception e) {
            throw new Exception("There is no console in the database from that manufacturer");
        }
    }

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public void updateConsole(@Valid Console console) throws Exception {
        try {
            consoleRepository.save(console);
        } catch (Exception e) {
            throw new Exception("Could not update the given entry, make sure that request body is submitting all required information");
        }
    }

    @Transactional
    public void removeConsole(int id) throws Exception {
        try {
            consoleRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Cannot find a console with that ID in the database");
        }
    }

}
