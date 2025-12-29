package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.OutboundTour;
import lut.luttourismsystem.Service.OutboundTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outbound-tour")
@CrossOrigin(origins = "*")
public class OutboundTourController {

    @Autowired
    private OutboundTourService outboundTourService;

    @GetMapping
    public ResponseEntity<Iterable<OutboundTour>> getAllOutboundTours() {
        Iterable<OutboundTour> tours = outboundTourService.findAllOutboundTours();
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutboundTour> getOutboundTourById(@PathVariable int id) {
        try {
            OutboundTour tour = outboundTourService.findOutboundTour(id);
            if (tour != null) {
                return ResponseEntity.ok(tour);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/agency/{agencyId}")
    public ResponseEntity<List<OutboundTour>> getOutboundToursByAgency(@PathVariable int agencyId) {
        List<OutboundTour> tours = outboundTourService.findOutboundToursByAgency(agencyId);
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/visa-status/{status}")
    public ResponseEntity<List<OutboundTour>> getOutboundToursByVisaStatus(@PathVariable String status) {
        List<OutboundTour> tours = outboundTourService.findOutboundToursByVisaStatus(status);
        return ResponseEntity.ok(tours);
    }

    @PostMapping
    public ResponseEntity<OutboundTour> createOutboundTour(@RequestBody OutboundTour outboundTour) {
        outboundTourService.addOutboundTour(outboundTour);
        return ResponseEntity.status(HttpStatus.CREATED).body(outboundTour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutboundTour> updateOutboundTour(@PathVariable int id, @RequestBody OutboundTour outboundTour) {
        try {
            OutboundTour existingTour = outboundTourService.findOutboundTour(id);
            if (existingTour == null) {
                return ResponseEntity.notFound().build();
            }
            outboundTour.setOutboundTourId(id);
            outboundTourService.updateOutboundTour(outboundTour);
            return ResponseEntity.ok(outboundTour);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutboundTour(@PathVariable int id) {
        try {
            OutboundTour tour = outboundTourService.findOutboundTour(id);
            if (tour == null) {
                return ResponseEntity.notFound().build();
            }
            outboundTourService.deleteOutboundTour(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

