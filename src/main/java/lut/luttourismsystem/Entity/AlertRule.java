package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="alert_rule")
@Entity
@Data
public class AlertRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ruleId;

    // 规则名称
    String ruleName;
    // 规则类型（景区游客百分比/停车位百分比/饭店入住率/缆车等候时间/GPS轨迹偏离等）
    String ruleType;
    
    // 阈值设定（百分比或数值）
    double thresholdValue; // 阈值
    String thresholdUnit; // 单位（百分比/人数/分钟/米等）
    
    // 适用对象类型（景区/饭店/旅行社/车辆等）
    String targetType;
    // 适用对象ID（如果为空则适用于所有该类型对象）
    Integer targetId;
    
    // 告警级别
    String alertLevel;
    // 是否启用
    boolean isEnabled;
    
    // 告警消息模板
    String alertMessageTemplate;
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}

