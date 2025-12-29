package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="travel_agency")
@Entity
@Data
public class TravelAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int agencyId;

    String name;
    // 旅行社资质
    String qualification;
    // 诚信状况
    String creditStatus;
    // 诚信评分（0-100）
    int creditScore;
    
    // 管理人员信息
    String managerName;
    String managerPhone;
    
    // 应急救援人员信息
    String emergencyPerson;
    String emergencyPhone;
    // 应急救援车辆信息
    int emergencyVehicleCount;
    String emergencyVehicleInfo;
    
    // 地理位置信息
    double longitude;
    double latitude;
    String address;
    
    // 今日团队出游人数
    int todayTeamMembers;
    
    // 是否经营出境旅游业务
    boolean hasOutboundBusiness;
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}

