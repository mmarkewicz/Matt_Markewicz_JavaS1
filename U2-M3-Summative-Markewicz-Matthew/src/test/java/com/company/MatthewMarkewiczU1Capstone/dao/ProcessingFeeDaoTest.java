package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.ProcessingFee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() {
        List<ProcessingFee> processingFeeList = processingFeeDao.getAllProcessingFees();
        processingFeeList.stream()
                .forEach(processingFee -> processingFeeDao.deleteProcessingFee(processingFee.getProductType()));
    }

    @After
    public void tearDown() {
        List<ProcessingFee> processingFeeList = processingFeeDao.getAllProcessingFees();
        processingFeeList.stream()
                .forEach(processingFee -> processingFeeDao.deleteProcessingFee(processingFee.getProductType()));
    }

//    @Test
//    public void addGetDeleteProcessingFee() {
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProductType("Test Product");
//        processingFee.setFee(new BigDecimal(3.99));
//        processingFee = processingFeeDao.addProcessingFee(processingFee);
//
//        processingFee.setFee(processingFee.getFee().setScale(2, RoundingMode.HALF_EVEN));
//
//        ProcessingFee testProcessingFee = processingFeeDao.getProcessingFee(processingFee.getProductType());
//        assertEquals(processingFee, testProcessingFee);
//
//        processingFeeDao.deleteProcessingFee(processingFee.getProductType());
//        assertEquals(processingFeeDao.getAllProcessingFees().size(), 0);
//    }
//
//    @Test
//    public void getAllProcessingFees() {
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProductType("Test Product");
//        processingFee.setFee(new BigDecimal(3.99));
//        processingFeeDao.addProcessingFee(processingFee);
//
//        assertEquals(processingFeeDao.getAllProcessingFees().size(), 1);
//    }

    @Test
    public void updateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Test Product");
        processingFee.setFee(new BigDecimal(3.99));
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        processingFee.setFee(new BigDecimal(5.99));
        processingFeeDao.updateProcessingFee(processingFee);

        ProcessingFee newProcessingFee = processingFeeDao.getProcessingFee(processingFee.getProductType());
        BigDecimal newFee = newProcessingFee.getFee();

        assertEquals(newProcessingFee.getFee(), processingFee.getFee().setScale(2, RoundingMode.HALF_EVEN));
    }
}
