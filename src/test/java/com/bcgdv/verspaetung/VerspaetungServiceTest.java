package com.bcgdv.verspaetung;

import com.bcgdv.verspaetung.exception.LineNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerspaetungServiceTest {
    @Autowired
    VerspaetungService verspaetungService;

    @Test
    public void lineShouldBeDelayed() throws Exception {
        boolean delayed = verspaetungService.isDelayed(1);
        assertTrue(delayed);
    }

    @Test(expected = LineNotFoundException.class)
    public void shouldThrowException() throws Exception {
        verspaetungService.isDelayed(800);
    }
}