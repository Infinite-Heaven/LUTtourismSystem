package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="credit_archive")
@Entity
@Data
public class CreditArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int archiveId;

    // 企业/个人类型（景区/饭店/旅行社/导游等）
    String entityType;
    // 企业/个人ID
    int entityId;
    // 企业/个人名称
    String entityName;
    
    // 诚信评分（0-100）
    int creditScore;
    // 诚信等级（优秀/良好/一般/较差/差）
    String creditLevel;
    
    // 投诉统计
    int totalComplaints; // 总投诉数
    int resolvedComplaints; // 已处理投诉数
    int unresolvedComplaints; // 未处理投诉数
    int seriousComplaints; // 严重投诉数
    
    // 投诉处理及时率（百分比）
    double handleTimelyRate;
    // 投诉处理满意度（平均分）
    double handleSatisfaction;
    
    // 违规记录数
    int violationCount;
    // 违规记录详情（JSON格式）
    String violationDetails;
    
    // 奖励记录数
    int rewardCount;
    // 奖励记录详情（JSON格式）
    String rewardDetails;
    
    // 综合评价
    String comprehensiveEvaluation;
    
    // 最后评价时间
    String lastEvaluationTime;
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}

