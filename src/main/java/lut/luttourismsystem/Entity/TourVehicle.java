package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="tour_vehicle")
@Entity
@Data
public class TourVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleId;

    // 所属旅行社ID
    int agencyId;
    String agencyName;
    
    // 车牌号
    String licensePlate;
    // 车辆型号
    String vehicleModel;
    // 座位数
    int seatCount;
    // 基本车况信息
    String vehicleCondition;
    
    // 驾驶员信息
    String driverName;
    String driverPhone;
    String driverLicense;
    
    // 当前位置信息
    double longitude;
    double latitude;
    // 运行状态（运行中/停靠/维修等）
    String status;
    
    // 当前载客人数
    int currentPassengers;
    
    // 最后更新时间
    String lastUpdateTime;
    
    // 创建时间
    String createTime;
}

