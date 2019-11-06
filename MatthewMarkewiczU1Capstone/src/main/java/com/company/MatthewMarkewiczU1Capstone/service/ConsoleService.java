package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.*;
import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class ConsoleService {

    ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    public @Valid Console saveConsole(@Valid Console console) throws Exception{
        try {
            return consoleDao.addConsole(console);
        } catch (Exception e) {
            throw new Exception("SQL Error: Make sure your request is formatted properly.");
        }
    }

    public @Valid Console findConsole(int id) {
        return consoleDao.getConsole(id);
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    public List<Console> findAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public void updateConsole(@Valid Console console) {
        consoleDao.updateConsole(console);
    }

    @Transactional
    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }

}
