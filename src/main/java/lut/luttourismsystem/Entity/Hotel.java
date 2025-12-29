package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="hotel")
@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int hotelId;

    String name;
    // 星级（1-5星）
    int starLevel;
    // 最大接待量（房间数）
    int maxCapacity;
    // 最大停车容量
    int parkingTotal;
    // 当前入住率（百分比）
    double occupancyRate;
    // 当前入住房间数
    int currentOccupiedRooms;
    
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
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}

