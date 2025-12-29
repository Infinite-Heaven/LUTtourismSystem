package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.AlertRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRuleDao extends CrudRepository<AlertRule, Integer> {
    List<AlertRule> findByRuleType(String ruleType);
    List<AlertRule> findByTargetType(String targetType);
    List<AlertRule> findByIsEnabled(boolean isEnabled);
}

