package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.Guide;
import lut.luttourismsystem.Service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guides")
@CrossOrigin(origins = "*")
public class GuideController {



    @Autowired
     GuideService guideService;


        @GetMapping
        public ResponseEntity<Iterable<Guide>> getAllGuides() {
            Iterable<Guide> guides = guideService.findAllGuides();
            return ResponseEntity.ok(guides);
        }


        @GetMapping("/{id}")
        public ResponseEntity<Guide> getGuideById(@PathVariable int id) {
            try {
                Guide guide = guideService.findGuide(id);
                if (guide != null) {
                    return ResponseEntity.ok(guide);
                }
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }


        @PostMapping
        public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
            guideService.addGuide(guide);
            return ResponseEntity.status(HttpStatus.CREATED).body(guide);
        }


        @PutMapping("/{id}")
        public ResponseEntity<Guide> updateGuide(@PathVariable int id, @RequestBody Guide guide) {
            try {
                Guide existing = guideService.findGuide(id);
                if (existing == null) {
                    return ResponseEntity.notFound().build();
                }
                guide.setGuideId(id);
                guideService.updateGuide(guide);
                return ResponseEntity.ok(guide);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteGuide(@PathVariable int id) {
            try {
                Guide existing = guideService.findGuide(id);
                if (existing == null) {
                    return ResponseEntity.notFound().build();
                }
                guideService.deleteGuide(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }
}

