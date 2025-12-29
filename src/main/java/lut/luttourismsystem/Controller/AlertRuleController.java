package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.AlertRule;
import lut.luttourismsystem.Service.AlertRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert-rule")
@CrossOrigin(origins = "*")
public class AlertRuleController {

    @Autowired
    private AlertRuleService alertRuleService;

    @GetMapping
    public ResponseEntity<Iterable<AlertRule>> getAllAlertRules() {
        Iterable<AlertRule> rules = alertRuleService.findAllAlertRules();
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertRule> getAlertRuleById(@PathVariable int id) {
        try {
            AlertRule rule = alertRuleService.findAlertRule(id);
            if (rule != null) {
                return ResponseEntity.ok(rule);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{ruleType}")
    public ResponseEntity<List<AlertRule>> getAlertRulesByType(@PathVariable String ruleType) {
        List<AlertRule> rules = alertRuleService.findAlertRulesByType(ruleType);
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/target/{targetType}")
    public ResponseEntity<List<AlertRule>> getAlertRulesByTargetType(@PathVariable String targetType) {
        List<AlertRule> rules = alertRuleService.findAlertRulesByTargetType(targetType);
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/enabled")
    public ResponseEntity<List<AlertRule>> getEnabledAlertRules() {
        List<AlertRule> rules = alertRuleService.findEnabledAlertRules();
        return ResponseEntity.ok(rules);
    }

    @PostMapping
    public ResponseEntity<AlertRule> createAlertRule(@RequestBody AlertRule alertRule) {
        alertRuleService.addAlertRule(alertRule);
        return ResponseEntity.status(HttpStatus.CREATED).body(alertRule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertRule> updateAlertRule(@PathVariable int id, @RequestBody AlertRule alertRule) {
        try {
            AlertRule existing = alertRuleService.findAlertRule(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            alertRule.setRuleId(id);
            alertRuleService.updateAlertRule(alertRule);
            return ResponseEntity.ok(alertRule);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlertRule(@PathVariable int id) {
        try {
            AlertRule existing = alertRuleService.findAlertRule(id);
            if (existing == null) {
                return ResponseEntity.notFound().build();
            }
            alertRuleService.deleteAlertRule(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

