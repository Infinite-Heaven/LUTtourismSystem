package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.AlertReport;
import lut.luttourismsystem.Service.AlertReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
public class AlertReportController {
    @Autowired
    private AlertReportService alertReportService;


    @GetMapping
    public ResponseEntity<Iterable<AlertReport>> getAllAlertReports() {
        Iterable<AlertReport> alertReports = alertReportService.findAll();
        return ResponseEntity.ok(alertReports);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AlertReport> getAlertReportById(@PathVariable int id) {
        try {
            AlertReport alertReport = alertReportService.find(id);
            return ResponseEntity.ok(alertReport);
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
            // 检查警报报告是否存在
            alertReportService.find(id);
            // 设置ID确保更新的是正确的警报报告
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
            // 检查警报报告是否存在
            alertReportService.find(id);
            alertReportService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
