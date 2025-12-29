package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.AlertReport;
import lut.luttourismsystem.Service.AlertReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
@CrossOrigin(origins = "*")
public class AlertReportController {
    @Autowired
    private AlertReportService alertReportService;


    @GetMapping
    public ResponseEntity<Iterable<AlertReport>> getAllAlertReports() {
        Iterable<AlertReport> alertReports = alertReportService.findAll();
        return ResponseEntity.ok(alertReports);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<java.util.List<AlertReport>> getAlertReportsByStatus(@PathVariable String status) {
        java.util.List<AlertReport> alertReports = alertReportService.findByStatus(status);
        return ResponseEntity.ok(alertReports);
    }

    @GetMapping("/type/{alertType}")
    public ResponseEntity<java.util.List<AlertReport>> getAlertReportsByType(@PathVariable String alertType) {
        java.util.List<AlertReport> alertReports = alertReportService.findByAlertType(alertType);
        return ResponseEntity.ok(alertReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertReport> getAlertReportById(@PathVariable int id) {
        try {
            AlertReport alertReport = alertReportService.find(id);
            if (alertReport != null) {
                return ResponseEntity.ok(alertReport);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<AlertReport> createAlertReport(@RequestBody AlertReport alertReport) {
        alertReportService.add(alertReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(alertReport);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AlertReport> updateAlertReport(@PathVariable int id, @RequestBody AlertReport alertReport) {
        try {
            AlertReport existing = alertReportService.find(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            alertReport.setAlertId(id);
            alertReportService.update(alertReport);
            return ResponseEntity.ok(alertReport);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlertReport(@PathVariable int id) {
        try {
            AlertReport existing = alertReportService.find(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            alertReportService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
