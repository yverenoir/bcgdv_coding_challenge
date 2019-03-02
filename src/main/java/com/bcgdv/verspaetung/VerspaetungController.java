package com.bcgdv.verspaetung;

import com.bcgdv.verspaetung.domain.Line;
import com.bcgdv.verspaetung.exception.StopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
public class VerspaetungController {

    @Autowired VerspaetungService verspaetungService;

    @RequestMapping("/lines")
    public ResponseEntity getVehicle(@RequestParam("time") String time,
                             @RequestParam("x") int x,
                             @RequestParam("y") int y) {
        List<Line> vehicles = verspaetungService.getVehicles(time, x, y);
        return new ResponseEntity(vehicles, HttpStatus.OK);
    }

    @RequestMapping("/stops/{stopId}/lines")
    public ResponseEntity getNextVehicleToStop(@PathVariable("stopId") int stopId) {
        int lineId = verspaetungService.getNextLine(stopId, LocalTime.now());
        return new ResponseEntity(lineId, HttpStatus.OK);
    }

    @RequestMapping("/lines/{lineId}")
    public ResponseEntity checkIfDelayed(@PathVariable("lineId") int lineId) {
        boolean delayed = verspaetungService.isDelayed(lineId);
        return new ResponseEntity(delayed, HttpStatus.OK);
    }

}
