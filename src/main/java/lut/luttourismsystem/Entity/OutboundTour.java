package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="outbound_tour")
@Entity
@Data
public class OutboundTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int outboundTourId;

    // 所属旅行社ID
    int agencyId;
    String agencyName;
    
    // 申请类型（经营出境旅游业务申请/自组境外旅游团队）
    String applicationType;
    
    // 目的地国家/地区
    String destination;
    
    // 团队人数
    int teamMembers;
    
    // 出发日期
    String departureDate;
    // 返回日期
    String returnDate;
    
    // 签证信息
    String visaInfo;
    // 签证状态（待审核/已通过/已拒绝）
    String visaStatus;
    
    // 审核人
    String reviewer;
    // 审核时间
    String reviewTime;
    // 审核意见
    String reviewComment;
    
    // 申请时间
    String applicationTime;
    // 更新时间
    String updateTime;
}

