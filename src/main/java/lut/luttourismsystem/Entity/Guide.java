package lut.luttourismsystem.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name="guide")
@Entity
@Data
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int guideId;
    
    String name;
    int age;
    int year; // 年份（兼容旧数据库字段）
    String sex;
    String idCard; // 身份证号
    String phone;
    String email;
    
    // 注册登记信息
    String registrationNumber; // 注册登记号
    String registrationDate; // 注册日期
    boolean isRegistered; // 是否已注册
    
    // 资格审验状态
    boolean qualificationReview; // 资质审验状态
    String qualificationReviewDate; // 审验日期
    String qualificationLevel; // 资格等级
    
    // 求职应聘信息
    boolean isJobSeeking; // 是否正在求职
    String jobSeekingStatus; // 求职状态
    String resumeUrl; // 简历链接
    
    // 导游行程单申领
    int itineraryApplicationCount; // 已申领行程单数量
    String lastItineraryApplicationDate; // 最后申领日期
    
    // 当前位置信息
    double longitude;
    double latitude;
    String currentLocation; // 当前位置描述
    
    // 当前团队信息
    int teamMembersNumber; // 当前团队人数
    int currentTeamId; // 当前团队ID
    String currentTeamName; // 当前团队名称
    
    // 执业状况
    String practiceStatus; // 执业状态（在职/休假/停职等）
    int totalTours; // 总带团次数
    double averageRating; // 平均评分
    
    // 创建时间
    String createTime;
    // 更新时间
    String updateTime;
}