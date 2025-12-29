package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.CreditArchive;
import lut.luttourismsystem.Service.CreditArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-archive")
@CrossOrigin(origins = "*")
public class CreditArchiveController {

    @Autowired
    private CreditArchiveService creditArchiveService;

    @GetMapping
    public ResponseEntity<Iterable<CreditArchive>> getAllCreditArchives() {
        Iterable<CreditArchive> archives = creditArchiveService.findAllCreditArchives();
        return ResponseEntity.ok(archives);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditArchive> getCreditArchiveById(@PathVariable int id) {
        try {
            CreditArchive archive = creditArchiveService.findCreditArchive(id);
            if (archive != null) {
                return ResponseEntity.ok(archive);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/entity/{type}/{id}")
    public ResponseEntity<CreditArchive> getCreditArchiveByEntity(@PathVariable String type, @PathVariable int id) {
        CreditArchive archive = creditArchiveService.findCreditArchiveByEntity(type, id);
        if (archive != null) {
            return ResponseEntity.ok(archive);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<CreditArchive>> getCreditArchivesByType(@PathVariable String type) {
        List<CreditArchive> archives = creditArchiveService.findCreditArchivesByType(type);
        return ResponseEntity.ok(archives);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<CreditArchive>> getCreditArchivesByLevel(@PathVariable String level) {
        List<CreditArchive> archives = creditArchiveService.findCreditArchivesByLevel(level);
        return ResponseEntity.ok(archives);
    }

    @PostMapping
    public ResponseEntity<CreditArchive> createCreditArchive(@RequestBody CreditArchive creditArchive) {
        creditArchiveService.addCreditArchive(creditArchive);
        return ResponseEntity.status(HttpStatus.CREATED).body(creditArchive);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditArchive> updateCreditArchive(@PathVariable int id, @RequestBody CreditArchive creditArchive) {
        try {
            CreditArchive existing = creditArchiveService.findCreditArchive(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            creditArchive.setArchiveId(id);
            creditArchiveService.updateCreditArchive(creditArchive);
            return ResponseEntity.ok(creditArchive);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update-from-complaint/{type}/{id}")
    public ResponseEntity<CreditArchive> updateCreditArchiveFromComplaint(@PathVariable String type, @PathVariable int id) {
        creditArchiveService.updateCreditArchiveFromComplaint(type, id);
        CreditArchive archive = creditArchiveService.findCreditArchiveByEntity(type, id);
        if (archive != null) {
            return ResponseEntity.ok(archive);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditArchive(@PathVariable int id) {
        try {
            CreditArchive existing = creditArchiveService.findCreditArchive(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            creditArchiveService.deleteCreditArchive(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

