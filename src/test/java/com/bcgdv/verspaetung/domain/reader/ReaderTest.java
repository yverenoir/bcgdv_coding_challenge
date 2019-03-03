package com.bcgdv.verspaetung.domain.reader;

import com.bcgdv.verspaetung.domain.Delay;
import com.bcgdv.verspaetung.domain.Line;
import com.bcgdv.verspaetung.domain.Stop;
import com.bcgdv.verspaetung.domain.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTest {
    @Autowired
    Reader reader;

    @Test
    public void readStops() {
        List<Stop> stops = reader.readStop();
        assertEquals(12, stops.size());
    }

    @Test
    public void readLines() {
        List<Line> lines = reader.readLines();
        assertEquals(3, lines.size());
    }

    @Test
    public void readDelays() {
        List<Delay> delays = reader.readDelay();
        assertEquals(3, delays.size());
    }

    @Test
    public void readTimes() {
        List<Time> times = reader.readTimes();
        assertEquals(15, times.size());
    }
}