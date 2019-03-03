package com.bcgdv.verspaetung;

import com.bcgdv.verspaetung.domain.Line;
import com.bcgdv.verspaetung.exception.LineNotFoundException;
import com.bcgdv.verspaetung.exception.StopNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerspaetungServiceTest {
    @Autowired
    VerspaetungService verspaetungService;

    @Test
    public void shouldReturnVehicle() {
        List<Line> vehicles = verspaetungService.getVehicles("10:00:00", 1, 1);
        assertEquals(1, vehicles.size());
        assertEquals(0, vehicles.get(0).getId());
    }

    @Test
    public void shouldReturnMultipleVehicles() {
        List<Line> vehicles = verspaetungService.getVehicles("10:08:00", 2, 9);
        assertEquals(2, vehicles.size());
        assertEquals(1, vehicles.get(0).getId());
        assertEquals(2, vehicles.get(1).getId());
    }

    @Test
    public void shouldReturnNoVehicleWhenNoVehicleAtStopAtGivenTime() {
        List<Line> vehicles = verspaetungService.getVehicles("10:02:00", 3, 1);
        assertEquals(0, vehicles.size());
    }

    @Test(expected = StopNotFoundException.class)
    public void shouldThrowExceptionWhenTimeOkayButNoStopAtCoords() {
        verspaetungService.getVehicles("10:00:00", 5, 5);
    }

    @Test(expected = StopNotFoundException.class)
    public void shouldThrowExceptionWhenBothTimeAndStopNotFound() {
        verspaetungService.getVehicles("14:00:00", 5, 5);
    }

    @Test
    public void shouldReturnNextLineConsideringDelay() {
        int nextLine = verspaetungService.getNextLine(3, LocalTime.parse("10:07:01"));
        assertEquals(0, nextLine);
    }

    @Test
    public void shouldReturnNextLineWhenLastLineJustPassed() {
        int nextLine = verspaetungService.getNextLine(3, LocalTime.parse("10:10:00"));
        assertEquals(2, nextLine);
    }

    @Test
    public void shouldReturnNextLineWhenLastLineOfTheDayPassed() {
        int nextLine = verspaetungService.getNextLine(3, LocalTime.parse("18:10:00"));
        assertEquals(0, nextLine);
    }

    @Test
    public void shouldReturnTrueWhenLineIsDelayed() {
        boolean delayed = verspaetungService.isDelayed(1);
        assertTrue(delayed);
    }

    @Test(expected = LineNotFoundException.class)
    public void shouldThrowExceptionWhenLineIdNotFound() {
        verspaetungService.isDelayed(800);
    }

    @Test(expected = LineNotFoundException.class)
    public void shouldThrowExceptionWhenLineIdIsNegative() {
        verspaetungService.isDelayed(-1);
    }
}