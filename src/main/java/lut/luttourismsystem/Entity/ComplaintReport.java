package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="complaint_report")
@Entity
@Data
public class ComplaintReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reportId;
    
    // 投诉内容
    String content;
    // 投诉渠道（电话/网站/现场等）
    String complaintChannel;
    // 投诉日期
    String complaintDate;
    
    // 投诉人信息
    String complainantName; // 投诉人姓名
    String complainantPhone; // 投诉人电话
    String complainantEmail; // 投诉人邮箱
    
    // 被投诉对象
    String complainedType; // 被投诉类型（景区/饭店/旅行社/导游/车辆等）
    int complainedId; // 被投诉对象ID
    String complainedName; // 被投诉对象名称
    
    // 处理流程（首问负责制）
    String firstHandler; // 首问负责人
    String firstHandleTime; // 首问处理时间
    
    // 处理状态（待处理/处理中/已处理/已关闭）
    String status;
    // 处理人
    String handler;
    // 处理时间
    String handleTime;
    // 处理结果
    String handleResult;
    // 处理意见
    String handleComment;
    
    // 满意度评价
    int satisfactionRating; // 满意度评分（1-5）
    String satisfactionComment; // 满意度评价
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}