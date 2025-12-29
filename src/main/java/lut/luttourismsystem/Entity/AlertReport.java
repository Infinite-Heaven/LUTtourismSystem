package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="alert_report")
@Entity
@Data
public class AlertReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int alertId;

    // 告警内容
    String content;
    // 告警类型（景区游客/停车位/饭店入住率/缆车等候时间/GPS轨迹偏离等）
    String alertType;
    // 告警级别（提示/警告/严重）
    String alertLevel;
    // 告警来源（景区ID/饭店ID/旅行社ID/车辆ID等）
    int sourceId;
    String sourceName;
    String sourceType; // 来源类型
    
    // 告警状态（待处理/已处理/已发布/已忽略）
    String status;
    // 是否需要发布
    boolean needPublish;
    // 是否已发布
    boolean isPublished;
    // 发布渠道（短信/电台/大屏等）
    String publishChannels;
    
    // 处理信息
    String handler; // 处理人
    String handleTime; // 处理时间
    String handleComment; // 处理意见
    
    // 审批信息
    String approver; // 审批人
    String approveTime; // 审批时间
    boolean isApproved; // 是否已审批
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}
