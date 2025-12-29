package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.TourVehicle;
import lut.luttourismsystem.Service.TourVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour-vehicle")
@CrossOrigin(origins = "*")
public class TourVehicleController {

    @Autowired
    private TourVehicleService tourVehicleService;

    @GetMapping
    public ResponseEntity<Iterable<TourVehicle>> getAllTourVehicles() {
        Iterable<TourVehicle> vehicles = tourVehicleService.findAllTourVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourVehicle> getTourVehicleById(@PathVariable int id) {
        try {
            TourVehicle vehicle = tourVehicleService.findTourVehicle(id);
            if (vehicle != null) {
                return ResponseEntity.ok(vehicle);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<TourVehicle>> getVehiclesByAgency(@PathVariable int agencyId) {
        List<TourVehicle> vehicles = tourVehicleService.findVehiclesByAgency(agencyId);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TourVehicle>> getVehiclesByStatus(@PathVariable String status) {
        List<TourVehicle> vehicles = tourVehicleService.findVehiclesByStatus(status);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<TourVehicle> createTourVehicle(@RequestBody TourVehicle tourVehicle) {
        tourVehicleService.addTourVehicle(tourVehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(tourVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourVehicle> updateTourVehicle(@PathVariable int id, @RequestBody TourVehicle tourVehicle) {
        try {
            TourVehicle existingVehicle = tourVehicleService.findTourVehicle(id);
            if (existingVehicle == null) {
                return ResponseEntity.notFound().build();
            }
            tourVehicle.setVehicleId(id);
            tourVehicleService.updateTourVehicle(tourVehicle);
            return ResponseEntity.ok(tourVehicle);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourVehicle(@PathVariable int id) {
        try {
            TourVehicle vehicle = tourVehicleService.findTourVehicle(id);
            if (vehicle == null) {
                return ResponseEntity.notFound().build();
            }
            tourVehicleService.deleteTourVehicle(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

