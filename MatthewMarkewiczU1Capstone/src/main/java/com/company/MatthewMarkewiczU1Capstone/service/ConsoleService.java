package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.*;
import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsoleService {

    ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    public Console saveConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console findConsole(int id) {
        return consoleDao.getConsole(id);
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    public List<Console> findAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    @Transactional
    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }

}
