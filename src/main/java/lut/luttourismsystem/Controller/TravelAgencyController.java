package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.TravelAgency;
import lut.luttourismsystem.Service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel-agency")
@CrossOrigin(origins = "*")
public class TravelAgencyController {

    @Autowired
    private TravelAgencyService travelAgencyService;

    @GetMapping
    public ResponseEntity<Iterable<TravelAgency>> getAllTravelAgencies() {
        Iterable<TravelAgency> agencies = travelAgencyService.findAllTravelAgencies();
        return ResponseEntity.ok(agencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelAgency> getTravelAgencyById(@PathVariable int id) {
        try {
            TravelAgency agency = travelAgencyService.findTravelAgency(id);
            if (agency != null) {
                return ResponseEntity.ok(agency);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TravelAgency> createTravelAgency(@RequestBody TravelAgency travelAgency) {
        travelAgencyService.addTravelAgency(travelAgency);
        return ResponseEntity.status(HttpStatus.CREATED).body(travelAgency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelAgency> updateTravelAgency(@PathVariable int id, @RequestBody TravelAgency travelAgency) {
        try {
            TravelAgency existingAgency = travelAgencyService.findTravelAgency(id);
            if (existingAgency == null) {
                return ResponseEntity.notFound().build();
            }
            travelAgency.setAgencyId(id);
            travelAgencyService.updateTravelAgency(travelAgency);
            return ResponseEntity.ok(travelAgency);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelAgency(@PathVariable int id) {
        try {
            TravelAgency agency = travelAgencyService.findTravelAgency(id);
            if (agency == null) {
                return ResponseEntity.notFound().build();
            }
            travelAgencyService.deleteTravelAgency(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

