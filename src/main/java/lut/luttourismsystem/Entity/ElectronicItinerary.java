package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="electronic_itinerary")
@Entity
@Data
public class ElectronicItinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int itineraryId;

    // 所属旅行社ID
    int agencyId;
    String agencyName;
    
    // 团队编号
    String teamNumber;
    // 团队名称
    String teamName;
    
    // 行程开始时间
    String startTime;
    // 行程结束时间
    String endTime;
    
    // 计划路线（JSON格式存储路线点）
    String plannedRoute;
    
    // 实际路线（JSON格式存储GPS轨迹点）
    String actualRoute;
    
    // 偏离设定值（单位：米）
    double deviationThreshold;
    // 是否偏离
    boolean isDeviated;
    // 偏离距离（米）
    double deviationDistance;
    
    // 团队人数
    int teamMembers;
    
    // 导游ID
    int guideId;
    String guideName;
    
    // 车辆ID
    int vehicleId;
    String vehicleLicensePlate;
    
    // 行程状态（计划中/进行中/已完成/已取消）
    String status;
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}

