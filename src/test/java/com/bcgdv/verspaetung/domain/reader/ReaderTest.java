package com.bcgdv.verspaetung.domain.reader;

import com.bcgdv.verspaetung.domain.Delay;
import com.bcgdv.verspaetung.domain.Line;
import com.bcgdv.verspaetung.domain.Stop;
import com.bcgdv.verspaetung.domain.Time;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReaderTest {
    @Test
    public void readStops() {
        List<Stop> stops = Reader.readStop();
        assertEquals(12, stops.size());
    }

    @Test
    public void readLines() {
        List<Line> lines = Reader.readLines();
        assertEquals(3, lines.size());
    }

    @Test
    public void readDelays() {
        List<Delay> delays = Reader.readDelay();
        assertEquals(3, delays.size());
    }

    @Test
    public void readTimes() {
        List<Time> times = Reader.readTimes();
        assertEquals(15, times.size());
    }
}