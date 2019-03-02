package com.bcgdv.verspaetung.domain.reader;

import com.bcgdv.verspaetung.domain.*;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.File;
import java.util.List;

public class Reader {
    public static List<Stop> readStop() throws Exception {
        File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/stops.csv");
        MappingIterator<Stop> stopIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Stop.class)
                        .readValues(file);

        return stopIterator.readAll();
    }

    public static List<Delay> readDelay() throws Exception {
        File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/delays.csv");
        MappingIterator<Delay> delayIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Delay.class)
                        .readValues(file);

        return delayIterator.readAll();
    }

    public static List<Line> readLines() throws Exception {
        File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/lines.csv");
        MappingIterator<Line> lineIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Line.class)
                        .readValues(file);

        return lineIterator.readAll();
    }

    public static List<Time> readTimes() throws Exception {
        File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/times.csv");
        MappingIterator<Time> timeIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Time.class)
                        .readValues(file);

        return timeIterator.readAll();
    }

}
