package com.bcgdv.verspaetung.domain.reader;

import com.bcgdv.verspaetung.domain.*;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Reader<T> {
    public List<T> read(String filePath, Class<T> clazz) {
        try {
            File file = new File(filePath);
            MappingIterator<T> iterator = new CsvMapper()
                    .readerWithTypedSchemaFor(clazz)
                    .with(CsvSchema.emptySchema().withHeader())
                    .readValues(file);
            return iterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Stop> readStop() {
        return (List<Stop>) read("./src/main/java/com/bcgdv/verspaetung/domain/reader/stops.csv", (Class<T>) Stop.class);
    }

    public List<Delay> readDelay() {
        return (List<Delay>) read("./src/main/java/com/bcgdv/verspaetung/domain/reader/delays.csv", (Class<T>) Delay.class);
    }

    public List<Line> readLines() {
        return (List<Line>) read("./src/main/java/com/bcgdv/verspaetung/domain/reader/lines.csv", (Class<T>) Line.class);
    }

    public List<Time> readTimes() {
        return (List<Time>) read("./src/main/java/com/bcgdv/verspaetung/domain/reader/times.csv", (Class<T>) Time.class);
    }

}
