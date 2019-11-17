package com.trilogyed.adserver.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdserverControllerTest {

    @Autowired
    AdserverController adserverController;

    @Autowired
    MockMvc mockMvc;

   @Test
    public void getRandomAd() {
   }
}
