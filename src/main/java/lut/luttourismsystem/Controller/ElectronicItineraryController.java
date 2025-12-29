package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.ElectronicItinerary;
import lut.luttourismsystem.Service.ElectronicItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronic-itinerary")
@CrossOrigin(origins = "*")
public class ElectronicItineraryController {

    @Autowired
    private ElectronicItineraryService electronicItineraryService;

    @GetMapping
    public ResponseEntity<Iterable<ElectronicItinerary>> getAllElectronicItineraries() {
        Iterable<ElectronicItinerary> itineraries = electronicItineraryService.findAllElectronicItineraries();
        return ResponseEntity.ok(itineraries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectronicItinerary> getElectronicItineraryById(@PathVariable int id) {
        try {
            ElectronicItinerary itinerary = electronicItineraryService.findElectronicItinerary(id);
            if (itinerary != null) {
                return ResponseEntity.ok(itinerary);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<ElectronicItinerary>> getItinerariesByAgency(@PathVariable int agencyId) {
        List<ElectronicItinerary> itineraries = electronicItineraryService.findItinerariesByAgency(agencyId);
        return ResponseEntity.ok(itineraries);
    }

    @GetMapping("/deviated")
    public ResponseEntity<List<ElectronicItinerary>> getDeviatedItineraries() {
        List<ElectronicItinerary> itineraries = electronicItineraryService.findDeviatedItineraries();
        return ResponseEntity.ok(itineraries);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ElectronicItinerary>> getItinerariesByStatus(@PathVariable String status) {
        List<ElectronicItinerary> itineraries = electronicItineraryService.findItinerariesByStatus(status);
        return ResponseEntity.ok(itineraries);
    }

    @PostMapping
    public ResponseEntity<ElectronicItinerary> createElectronicItinerary(@RequestBody ElectronicItinerary itinerary) {
        electronicItineraryService.addElectronicItinerary(itinerary);
        return ResponseEntity.status(HttpStatus.CREATED).body(itinerary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectronicItinerary> updateElectronicItinerary(@PathVariable int id, @RequestBody ElectronicItinerary itinerary) {
        try {
            ElectronicItinerary existingItinerary = electronicItineraryService.findElectronicItinerary(id);
            if (existingItinerary == null) {
                return ResponseEntity.notFound().build();
            }
            itinerary.setItineraryId(id);
            electronicItineraryService.updateElectronicItinerary(itinerary);
            return ResponseEntity.ok(itinerary);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectronicItinerary(@PathVariable int id) {
        try {
            ElectronicItinerary itinerary = electronicItineraryService.findElectronicItinerary(id);
            if (itinerary == null) {
                return ResponseEntity.notFound().build();
            }
            electronicItineraryService.deleteElectronicItinerary(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

