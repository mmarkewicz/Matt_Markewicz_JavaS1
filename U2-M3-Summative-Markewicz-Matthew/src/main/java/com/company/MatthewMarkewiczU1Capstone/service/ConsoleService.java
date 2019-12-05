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

    public @Valid Console saveConsole(@Valid Console console) throws Exception {
        try {
            return consoleDao.addConsole(console);
        } catch (Exception e) {
            throw new Exception("SQL Error: Make sure your request is formatted properly");
        }
    }

    public @Valid Console findConsole(int id) throws Exception {
        try {
            return consoleDao.getConsole(id);
        } catch (Exception e) {
            throw new Exception("There is no console in the database with that ID");
        }
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) throws Exception {
        try {
            return consoleDao.getConsolesByManufacturer(manufacturer);
        } catch (Exception e) {
            throw new Exception("There is no console in the database from that manufacturer");
        }
    }

    public List<Console> findAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public void updateConsole(@Valid Console console) throws Exception {
        try {
            consoleDao.updateConsole(console);
        } catch (Exception e) {
            throw new Exception("Could not update the given entry, make sure that request body is submitting all required information");
        }
    }

    @Transactional
    public void removeConsole(int id) throws Exception {
        try {
            consoleDao.deleteConsole(id);
        } catch (Exception e) {
            throw new Exception("Cannot find a console with that ID in the database");
        }
    }

}
