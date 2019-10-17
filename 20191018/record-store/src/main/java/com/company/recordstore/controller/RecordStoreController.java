package com.company.recordstore.controller;

import com.company.recordstore.exceptions.NotFoundException;
import com.company.recordstore.models.Record;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordStoreController {

    private List<Record> recordList;

    private static int idCounter = 1;

    public RecordStoreController() {
        recordList = new ArrayList<>();
        recordList.add(new Record("The Beach Boys", "Pet Sounds", "1966", idCounter++));
        recordList.add(new Record("Billy Joel", "The Stranger", "1977", idCounter++));
        recordList.add(new Record("The Beatles", "Revolver", "1966", idCounter++));
        recordList.add(new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", "2010", idCounter++));
        recordList.add(new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", "2014", idCounter++));
    }

    // POST /records
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Record createRecord(@RequestBody @Valid Record record) {
        record.setId(idCounter++);
        recordList.add(record);
        return record;
    }

    // GET /records
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Record> getAllRecords() {
        return recordList;
    }

    // GET /records/{id}
    @RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Record getRecordByID(@PathVariable int id) {
        Record requestedRecord = null;

        for (Record record : recordList) {
            if (record.getId() == id) {
                requestedRecord = record;
                break; // break once the loop retrieves the proper id
            }
        }

        // if the requested record is not found in the list, throw an error
        if (requestedRecord == null) {
            throw new NotFoundException("error: record not found");
        }

        return requestedRecord;
    }

    // PUT /records/{id}
    @RequestMapping(value = "/records/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateRecordByID(@PathVariable int id, @RequestBody @Valid Record record) {

        // set request object to proper id
        if (record.getId() == 0) {
            record.setId(id);
        }

        if (record.getId() != id) {
            throw new IllegalArgumentException("error: id in parameter must match id in request body");
        }

        int index = -1;

        for (int i = 0; i <recordList.size(); i++) {
            if (recordList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            recordList.set(index, record);
        }
    }

    // DELETE /records/{id}
    @RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRecordByID(@PathVariable int id) {
        int index = -1;

        for (int i = 0; i < recordList.size(); i++) {
            if (recordList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            recordList.remove(index);
        }
    }


}
