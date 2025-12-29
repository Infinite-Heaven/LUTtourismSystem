package lut.luttourismsystem.Controller;
import lut.luttourismsystem.Entity.ComplaintReport;

import lut.luttourismsystem.Service.ComplaintReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaint")
@CrossOrigin(origins = "*")
public class ComplaintReportController {
    @Autowired
    private ComplaintReportService complaintReportService;


    @GetMapping
    public ResponseEntity<Iterable<ComplaintReport>> getAllComplaintReport() {
        Iterable<ComplaintReport> complaintReport = complaintReportService.findAllComplaintReport();
        return ResponseEntity.ok(complaintReport);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<java.util.List<ComplaintReport>> getComplaintReportsByStatus(@PathVariable String status) {
        java.util.List<ComplaintReport> reports = complaintReportService.findComplaintReportsByStatus(status);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/complained/{type}")
    public ResponseEntity<java.util.List<ComplaintReport>> getComplaintReportsByType(@PathVariable String type) {
        java.util.List<ComplaintReport> reports = complaintReportService.findComplaintReportsByComplainedType(type);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/complained/{type}/{id}")
    public ResponseEntity<java.util.List<ComplaintReport>> getComplaintReportsByEntity(@PathVariable String type, @PathVariable int id) {
        java.util.List<ComplaintReport> reports = complaintReportService.findComplaintReportsByComplainedEntity(type, id);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintReport> getComplaintReportById(@PathVariable int id) {
        try {
            ComplaintReport complaintReport = complaintReportService.findComplaintReport(id);
            if (complaintReport != null) {
                return ResponseEntity.ok(complaintReport);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<ComplaintReport> createComplaintReport(@RequestBody ComplaintReport complaintReport) {
        complaintReportService.addComplaintReport(complaintReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(complaintReport);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ComplaintReport> updateComplaintReport(@PathVariable int id, @RequestBody ComplaintReport complaintReport) {
        try {
            ComplaintReport existing = complaintReportService.findComplaintReport(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            complaintReport.setReportId(id);
            complaintReportService.updateComplaintReport(complaintReport);
            return ResponseEntity.ok(complaintReport);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaintReport(@PathVariable int id) {
        try {
            ComplaintReport existing = complaintReportService.findComplaintReport(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            complaintReportService.deleteComplaintReport(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
