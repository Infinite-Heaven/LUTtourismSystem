package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.AlertRuleDao;
import lut.luttourismsystem.Entity.AlertRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AlertRuleService {
    @Autowired
    AlertRuleDao alertRuleDao;

    public void addAlertRule(AlertRule alertRule) {
        if (alertRule.getCreateTime() == null || alertRule.getCreateTime().isEmpty()) {
            alertRule.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        alertRule.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        alertRuleDao.save(alertRule);
    }

    public void deleteAlertRule(int ruleId) {
        alertRuleDao.deleteById(ruleId);
    }

    public AlertRule findAlertRule(int ruleId) {
        return alertRuleDao.findById(ruleId).orElse(null);
    }

    public Iterable<AlertRule> findAllAlertRules() {
        return alertRuleDao.findAll();
    }

    public List<AlertRule> findAlertRulesByType(String ruleType) {
        return alertRuleDao.findByRuleType(ruleType);
    }

    public List<AlertRule> findAlertRulesByTargetType(String targetType) {
        return alertRuleDao.findByTargetType(targetType);
    }

    public List<AlertRule> findEnabledAlertRules() {
        return alertRuleDao.findByIsEnabled(true);
    }

    public void updateAlertRule(AlertRule alertRule) {
        alertRule.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        alertRuleDao.save(alertRule);
    }
}

