package com.bcgdv.verspaetung.domain.reader;

import com.bcgdv.verspaetung.domain.*;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Stop> readStop() {
        try {
            File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/stops.csv");
            MappingIterator<Stop> stopIterator = new CsvMapper()
                    .readerWithTypedSchemaFor(Stop.class)
                    .with(CsvSchema.emptySchema().withHeader())
                    .readValues(file);
            return stopIterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Delay> readDelay() {
        try {
            File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/delays.csv");
            MappingIterator<Delay> delayIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Delay.class)
                        .with(CsvSchema.emptySchema().withHeader())
                        .readValues(file);

            return delayIterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Line> readLines() {
        try {
            File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/lines.csv");
            MappingIterator<Line> lineIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Line.class)
                        .with(CsvSchema.emptySchema().withHeader())
                        .readValues(file);
         return lineIterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Time> readTimes() {
        try {
            File file = new File("/Users/ychi/dev/verspaetung/src/main/java/com/bcgdv/verspaetung/domain/reader/times.csv");
            MappingIterator<Time> timeIterator =
                new CsvMapper()
                        .readerWithTypedSchemaFor(Time.class)
                        .with(CsvSchema.emptySchema().withHeader())
                        .readValues(file);

            return timeIterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
