package com.trilogyed.adserver.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdserverControllerTest {

    @Autowired
    AdserverController adserverController;

    MockMvc mockMvc;

   @Test
    public void getRandomAd() throws Exception {
//       mockMvc.perform(get("/ad"))
//               .andExpect(status().isOk());
   }
}
