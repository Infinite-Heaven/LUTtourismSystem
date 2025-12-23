package lut.luttourismsystem.Controller;
import lut.luttourismsystem.Entity.ComplaintReport;

import lut.luttourismsystem.Service.ComplaintReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaint")
public class ComplaintReportController {
    @Autowired
    private ComplaintReportService complaintReportService;


    @GetMapping
    public ResponseEntity<Iterable<ComplaintReport>> getAllComplaintReport() {
        Iterable<ComplaintReport> complaintReport = complaintReportService.findAllComplaintReport();
        return ResponseEntity.ok(complaintReport);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ComplaintReport> getComplaintReportById(@PathVariable int id) {
        try {
            ComplaintReport complaintReport = complaintReportService.findComplaintReport(id);
            return ResponseEntity.ok(complaintReport);
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
            // 检查用户是否存在
            complaintReportService.findComplaintReport(id);
            // 设置ID确保更新的是正确的用户
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
            // 检查用户是否存在
            complaintReportService.findComplaintReport(id);
            complaintReportService.deleteComplaintReport(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
