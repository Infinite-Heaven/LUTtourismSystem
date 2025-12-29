package lut.luttourismsystem.Config;

import lut.luttourismsystem.Dao.*;
import lut.luttourismsystem.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TouristAttractionDao touristAttractionDao;
    
    @Autowired
    private HotelDao hotelDao;
    
    @Autowired
    private GuideDao guideDao;
    
    @Autowired
    private TravelAgencyDao travelAgencyDao;
    
    @Autowired
    private TourVehicleDao tourVehicleDao;
    
    @Autowired
    private ElectronicItineraryDao electronicItineraryDao;
    
    @Autowired
    private OutboundTourDao outboundTourDao;
    
    @Autowired
    private AlertRuleDao alertRuleDao;
    
    @Autowired
    private AlertReportDao alertReportDao;
    
    @Autowired
    private ComplaintReportDao complaintReportDao;
    
    @Autowired
    private CreditArchiveDao creditArchiveDao;
    
    @Autowired
    private UserDao userDao;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String currentTime = LocalDateTime.now().format(formatter);

    @Override
    public void run(String... args) throws Exception {
        // 检查是否已有数据，避免重复插入
        if (touristAttractionDao.count() == 0) {
            initTouristAttractions();
        }
        if (hotelDao.count() == 0) {
            initHotels();
        }
        if (guideDao.count() == 0) {
            initGuides();
        }
        if (travelAgencyDao.count() == 0) {
            initTravelAgencies();
        }
        if (tourVehicleDao.count() == 0) {
            initTourVehicles();
        }
        if (electronicItineraryDao.count() == 0) {
            initElectronicItineraries();
        }
        if (outboundTourDao.count() == 0) {
            initOutboundTours();
        }
        if (alertRuleDao.count() == 0) {
            initAlertRules();
        }
        if (alertReportDao.count() == 0) {
            initAlertReports();
        }
        if (complaintReportDao.count() == 0) {
            initComplaintReports();
        }
        if (creditArchiveDao.count() == 0) {
            initCreditArchives();
        }
        if (userDao.count() == 0) {
            initUsers();
        }
        
        System.out.println("测试数据初始化完成！");
    }

    private void initTouristAttractions() {
        TouristAttraction attraction1 = new TouristAttraction();
        attraction1.setName("黄山风景区");
        attraction1.setMaxCapacity(50000);
        attraction1.setCurrentCapacity(23847);
        attraction1.setParkingTotal(2800);
        attraction1.setParkingRemaining(1256);
        attraction1.setManagerName("张明");
        attraction1.setManagerPhone("0559-5561111");
        attraction1.setEmergencyPerson("李强");
        attraction1.setEmergencyPhone("0559-5561112");
        attraction1.setEmergencyVehicleCount(4);
        attraction1.setEmergencyVehicleInfo("救护车2辆，消防车1辆，应急指挥车1辆");
        attraction1.setElectronicMapUrl("https://map.baidu.com/");
        attraction1.setLongitude(118.1678);
        attraction1.setLatitude(30.1446);
        attraction1.setAddress("安徽省黄山市黄山区");
        attraction1.setCreateTime(currentTime);
        attraction1.setUpdateTime(currentTime);
        touristAttractionDao.save(attraction1);

        TouristAttraction attraction2 = new TouristAttraction();
        attraction2.setName("宏村景区");
        attraction2.setMaxCapacity(15000);
        attraction2.setCurrentCapacity(8560);
        attraction2.setParkingTotal(800);
        attraction2.setParkingRemaining(320);
        attraction2.setManagerName("王芳");
        attraction2.setManagerPhone("0559-5541234");
        attraction2.setEmergencyPerson("赵伟");
        attraction2.setEmergencyPhone("0559-5541235");
        attraction2.setEmergencyVehicleCount(2);
        attraction2.setEmergencyVehicleInfo("救护车1辆，应急车1辆");
        attraction2.setElectronicMapUrl("https://map.baidu.com/");
        attraction2.setLongitude(117.9833);
        attraction2.setLatitude(30.0167);
        attraction2.setAddress("安徽省黄山市黟县宏村镇");
        attraction2.setCreateTime(currentTime);
        attraction2.setUpdateTime(currentTime);
        touristAttractionDao.save(attraction2);
    }

    private void initHotels() {
        Hotel hotel1 = new Hotel();
        hotel1.setName("黄山国际大酒店");
        hotel1.setStarLevel(5);
        hotel1.setMaxCapacity(500);
        hotel1.setCurrentOccupiedRooms(420);
        hotel1.setOccupancyRate(84.0);
        hotel1.setParkingTotal(200);
        hotel1.setManagerName("陈总");
        hotel1.setManagerPhone("0559-5568888");
        hotel1.setEmergencyPerson("刘经理");
        hotel1.setEmergencyPhone("0559-5568889");
        hotel1.setEmergencyVehicleCount(1);
        hotel1.setEmergencyVehicleInfo("应急车1辆");
        hotel1.setLongitude(118.1500);
        hotel1.setLatitude(30.1200);
        hotel1.setAddress("安徽省黄山市屯溪区");
        hotel1.setCreateTime(currentTime);
        hotel1.setUpdateTime(currentTime);
        hotelDao.save(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setName("宏村精品酒店");
        hotel2.setStarLevel(4);
        hotel2.setMaxCapacity(120);
        hotel2.setCurrentOccupiedRooms(95);
        hotel2.setOccupancyRate(79.2);
        hotel2.setParkingTotal(50);
        hotel2.setManagerName("周经理");
        hotel2.setManagerPhone("0559-5545678");
        hotel2.setEmergencyPerson("吴主管");
        hotel2.setEmergencyPhone("0559-5545679");
        hotel2.setEmergencyVehicleCount(1);
        hotel2.setEmergencyVehicleInfo("应急车1辆");
        hotel2.setLongitude(117.9800);
        hotel2.setLatitude(30.0100);
        hotel2.setAddress("安徽省黄山市黟县宏村镇");
        hotel2.setCreateTime(currentTime);
        hotel2.setUpdateTime(currentTime);
        hotelDao.save(hotel2);
    }

    private void initGuides() {
        Guide guide1 = new Guide();
        guide1.setName("张明");
        guide1.setAge(32);
        guide1.setYear(1988); // 根据身份证号推算出生年份
        guide1.setSex("男");
        guide1.setIdCard("340123198801010001");
        guide1.setPhone("13800138001");
        guide1.setEmail("zhangming@example.com");
        guide1.setRegistrationNumber("D-2024-001");
        guide1.setRegistrationDate("2024-01-15");
        guide1.setRegistered(true);
        guide1.setQualificationReview(true);
        guide1.setQualificationReviewDate("2024-03-20");
        guide1.setQualificationLevel("高级");
        guide1.setJobSeeking(false);
        guide1.setJobSeekingStatus("在职");
        guide1.setItineraryApplicationCount(15);
        guide1.setLastItineraryApplicationDate("2024-06-01");
        guide1.setLongitude(118.1678);
        guide1.setLatitude(30.1446);
        guide1.setCurrentLocation("黄山风景区南门");
        guide1.setTeamMembersNumber(28);
        guide1.setCurrentTeamId(1);
        guide1.setCurrentTeamName("黄山一日游团队");
        guide1.setPracticeStatus("在职");
        guide1.setTotalTours(156);
        guide1.setAverageRating(4.8);
        guide1.setCreateTime(currentTime);
        guide1.setUpdateTime(currentTime);
        guideDao.save(guide1);

        Guide guide2 = new Guide();
        guide2.setName("李雪");
        guide2.setAge(28);
        guide2.setYear(1996); // 根据身份证号推算出生年份
        guide2.setSex("女");
        guide2.setIdCard("340123199601010002");
        guide2.setPhone("13800138002");
        guide2.setEmail("lixue@example.com");
        guide2.setRegistrationNumber("D-2024-002");
        guide2.setRegistrationDate("2024-02-10");
        guide2.setRegistered(true);
        guide2.setQualificationReview(true);
        guide2.setQualificationReviewDate("2024-04-15");
        guide2.setQualificationLevel("中级");
        guide2.setJobSeeking(false);
        guide2.setJobSeekingStatus("在职");
        guide2.setItineraryApplicationCount(8);
        guide2.setLastItineraryApplicationDate("2024-05-28");
        guide2.setLongitude(117.9833);
        guide2.setLatitude(30.0167);
        guide2.setCurrentLocation("宏村景区");
        guide2.setTeamMembersNumber(15);
        guide2.setCurrentTeamId(2);
        guide2.setCurrentTeamName("宏村半日游团队");
        guide2.setPracticeStatus("在职");
        guide2.setTotalTours(89);
        guide2.setAverageRating(4.6);
        guide2.setCreateTime(currentTime);
        guide2.setUpdateTime(currentTime);
        guideDao.save(guide2);
    }

    private void initTravelAgencies() {
        TravelAgency agency1 = new TravelAgency();
        agency1.setName("黄山国际旅行社");
        agency1.setQualification("AAAA级旅行社");
        agency1.setCreditStatus("良好");
        agency1.setCreditScore(92);
        agency1.setManagerName("王总");
        agency1.setManagerPhone("0559-5566666");
        agency1.setEmergencyPerson("孙经理");
        agency1.setEmergencyPhone("0559-5566667");
        agency1.setEmergencyVehicleCount(2);
        agency1.setEmergencyVehicleInfo("应急车2辆");
        agency1.setLongitude(118.1400);
        agency1.setLatitude(30.1100);
        agency1.setAddress("安徽省黄山市屯溪区");
        agency1.setTodayTeamMembers(1358);
        agency1.setHasOutboundBusiness(true);
        agency1.setCreateTime(currentTime);
        agency1.setUpdateTime(currentTime);
        travelAgencyDao.save(agency1);

        TravelAgency agency2 = new TravelAgency();
        agency2.setName("宏村旅行社");
        agency2.setQualification("AAA级旅行社");
        agency2.setCreditStatus("良好");
        agency2.setCreditScore(85);
        agency2.setManagerName("赵总");
        agency2.setManagerPhone("0559-5547777");
        agency2.setEmergencyPerson("钱经理");
        agency2.setEmergencyPhone("0559-5547778");
        agency2.setEmergencyVehicleCount(1);
        agency2.setEmergencyVehicleInfo("应急车1辆");
        agency2.setLongitude(117.9800);
        agency2.setLatitude(30.0100);
        agency2.setAddress("安徽省黄山市黟县");
        agency2.setTodayTeamMembers(456);
        agency2.setHasOutboundBusiness(false);
        agency2.setCreateTime(currentTime);
        agency2.setUpdateTime(currentTime);
        travelAgencyDao.save(agency2);
    }

    private void initTourVehicles() {
        TourVehicle vehicle1 = new TourVehicle();
        vehicle1.setAgencyId(1);
        vehicle1.setAgencyName("黄山国际旅行社");
        vehicle1.setLicensePlate("皖A12345");
        vehicle1.setVehicleModel("宇通ZK6120");
        vehicle1.setSeatCount(45);
        vehicle1.setVehicleCondition("良好");
        vehicle1.setDriverName("张师傅");
        vehicle1.setDriverPhone("13900139001");
        vehicle1.setDriverLicense("A1");
        vehicle1.setLongitude(118.1678);
        vehicle1.setLatitude(30.1446);
        vehicle1.setStatus("运行中");
        vehicle1.setCurrentPassengers(38);
        vehicle1.setLastUpdateTime(currentTime);
        vehicle1.setCreateTime(currentTime);
        tourVehicleDao.save(vehicle1);

        TourVehicle vehicle2 = new TourVehicle();
        vehicle2.setAgencyId(1);
        vehicle2.setAgencyName("黄山国际旅行社");
        vehicle2.setLicensePlate("皖A67890");
        vehicle2.setVehicleModel("金龙XMQ6127");
        vehicle2.setSeatCount(50);
        vehicle2.setVehicleCondition("良好");
        vehicle2.setDriverName("李师傅");
        vehicle2.setDriverPhone("13900139002");
        vehicle2.setDriverLicense("A1");
        vehicle2.setLongitude(117.9833);
        vehicle2.setLatitude(30.0167);
        vehicle2.setStatus("运行中");
        vehicle2.setCurrentPassengers(42);
        vehicle2.setLastUpdateTime(currentTime);
        vehicle2.setCreateTime(currentTime);
        tourVehicleDao.save(vehicle2);

        TourVehicle vehicle3 = new TourVehicle();
        vehicle3.setAgencyId(2);
        vehicle3.setAgencyName("宏村旅行社");
        vehicle3.setLicensePlate("皖B11111");
        vehicle3.setVehicleModel("中通LCK6120");
        vehicle3.setSeatCount(35);
        vehicle3.setVehicleCondition("良好");
        vehicle3.setDriverName("王师傅");
        vehicle3.setDriverPhone("13900139003");
        vehicle3.setDriverLicense("A1");
        vehicle3.setLongitude(118.1000);
        vehicle3.setLatitude(30.0800);
        vehicle3.setStatus("停靠");
        vehicle3.setCurrentPassengers(0);
        vehicle3.setLastUpdateTime(currentTime);
        vehicle3.setCreateTime(currentTime);
        tourVehicleDao.save(vehicle3);
    }

    private void initElectronicItineraries() {
        ElectronicItinerary itinerary1 = new ElectronicItinerary();
        itinerary1.setAgencyId(1);
        itinerary1.setAgencyName("黄山国际旅行社");
        itinerary1.setTeamNumber("T2024060101");
        itinerary1.setTeamName("黄山一日游");
        itinerary1.setStartTime("2024-06-01 08:00:00");
        itinerary1.setEndTime("2024-06-01 18:00:00");
        itinerary1.setPlannedRoute("[{\"lat\":30.1446,\"lng\":118.1678},{\"lat\":30.1500,\"lng\":118.1700}]");
        itinerary1.setActualRoute("[{\"lat\":30.1446,\"lng\":118.1678},{\"lat\":30.1450,\"lng\":118.1680}]");
        itinerary1.setDeviationThreshold(500.0);
        itinerary1.setDeviated(false);
        itinerary1.setDeviationDistance(0.0);
        itinerary1.setTeamMembers(28);
        itinerary1.setGuideId(1);
        itinerary1.setGuideName("张明");
        itinerary1.setVehicleId(1);
        itinerary1.setVehicleLicensePlate("皖A12345");
        itinerary1.setStatus("进行中");
        itinerary1.setCreateTime(currentTime);
        itinerary1.setUpdateTime(currentTime);
        electronicItineraryDao.save(itinerary1);

        ElectronicItinerary itinerary2 = new ElectronicItinerary();
        itinerary2.setAgencyId(1);
        itinerary2.setAgencyName("黄山国际旅行社");
        itinerary2.setTeamNumber("T2024053001");
        itinerary2.setTeamName("宏村半日游");
        itinerary2.setStartTime("2024-05-30 14:00:00");
        itinerary2.setEndTime("2024-05-30 18:00:00");
        itinerary2.setPlannedRoute("[{\"lat\":30.0167,\"lng\":117.9833}]");
        itinerary2.setActualRoute("[{\"lat\":30.0200,\"lng\":117.9900}]");
        itinerary2.setDeviationThreshold(500.0);
        itinerary2.setDeviated(true);
        itinerary2.setDeviationDistance(850.5);
        itinerary2.setTeamMembers(15);
        itinerary2.setGuideId(2);
        itinerary2.setGuideName("李雪");
        itinerary2.setVehicleId(3);
        itinerary2.setVehicleLicensePlate("皖B11111");
        itinerary2.setStatus("已完成");
        itinerary2.setCreateTime("2024-05-30 13:00:00");
        itinerary2.setUpdateTime("2024-05-30 18:30:00");
        electronicItineraryDao.save(itinerary2);
    }

    private void initOutboundTours() {
        OutboundTour tour1 = new OutboundTour();
        tour1.setAgencyId(1);
        tour1.setAgencyName("黄山国际旅行社");
        tour1.setApplicationType("自组境外旅游团队");
        tour1.setDestination("日本大阪");
        tour1.setTeamMembers(28);
        tour1.setDepartureDate("2024-07-15");
        tour1.setReturnDate("2024-07-22");
        tour1.setVisaInfo("团队旅游签证，已提交材料");
        tour1.setVisaStatus("待审核");
        tour1.setApplicationTime("2024-05-15 10:00:00");
        tour1.setUpdateTime(currentTime);
        outboundTourDao.save(tour1);

        OutboundTour tour2 = new OutboundTour();
        tour2.setAgencyId(1);
        tour2.setAgencyName("黄山国际旅行社");
        tour2.setApplicationType("经营出境旅游业务申请");
        tour2.setDestination("泰国曼谷");
        tour2.setTeamMembers(35);
        tour2.setDepartureDate("2024-08-01");
        tour2.setReturnDate("2024-08-08");
        tour2.setVisaInfo("落地签");
        tour2.setVisaStatus("已通过");
        tour2.setReviewer("审核员A");
        tour2.setReviewTime("2024-05-20 14:30:00");
        tour2.setReviewComment("材料齐全，符合要求");
        tour2.setApplicationTime("2024-05-10 09:00:00");
        tour2.setUpdateTime("2024-05-20 14:30:00");
        outboundTourDao.save(tour2);
    }

    private void initAlertRules() {
        AlertRule rule1 = new AlertRule();
        rule1.setRuleName("景区游客容量告警");
        rule1.setRuleType("景区游客百分比");
        rule1.setThresholdValue(80.0);
        rule1.setThresholdUnit("百分比");
        rule1.setTargetType("景区");
        rule1.setAlertLevel("警告");
        rule1.setEnabled(true);
        rule1.setAlertMessageTemplate("景区游客数量已达最大容量的{threshold}%，请注意疏导");
        rule1.setCreateTime(currentTime);
        rule1.setUpdateTime(currentTime);
        alertRuleDao.save(rule1);

        AlertRule rule2 = new AlertRule();
        rule2.setRuleName("停车位告警");
        rule2.setRuleType("停车位百分比");
        rule2.setThresholdValue(85.0);
        rule2.setThresholdUnit("百分比");
        rule2.setTargetType("景区");
        rule2.setAlertLevel("警告");
        rule2.setEnabled(true);
        rule2.setAlertMessageTemplate("停车场占用率达{threshold}%，建议引导至其他停车场");
        rule2.setCreateTime(currentTime);
        rule2.setUpdateTime(currentTime);
        alertRuleDao.save(rule2);

        AlertRule rule3 = new AlertRule();
        rule3.setRuleName("饭店入住率告警");
        rule3.setRuleType("饭店入住率");
        rule3.setThresholdValue(90.0);
        rule3.setThresholdUnit("百分比");
        rule3.setTargetType("饭店");
        rule3.setAlertLevel("警告");
        rule3.setEnabled(true);
        rule3.setAlertMessageTemplate("饭店入住率达{threshold}%，接近满房");
        rule3.setCreateTime(currentTime);
        rule3.setUpdateTime(currentTime);
        alertRuleDao.save(rule3);

        AlertRule rule4 = new AlertRule();
        rule4.setRuleName("缆车等候时间告警");
        rule4.setRuleType("缆车等候时间");
        rule4.setThresholdValue(30.0);
        rule4.setThresholdUnit("分钟");
        rule4.setTargetType("景区");
        rule4.setAlertLevel("提示");
        rule4.setEnabled(true);
        rule4.setAlertMessageTemplate("缆车等候时间超过{threshold}分钟，建议选择其他路线");
        rule4.setCreateTime(currentTime);
        rule4.setUpdateTime(currentTime);
        alertRuleDao.save(rule4);

        AlertRule rule5 = new AlertRule();
        rule5.setRuleName("GPS轨迹偏离告警");
        rule5.setRuleType("GPS轨迹偏离");
        rule5.setThresholdValue(500.0);
        rule5.setThresholdUnit("米");
        rule5.setTargetType("旅行社");
        rule5.setAlertLevel("严重");
        rule5.setEnabled(true);
        rule5.setAlertMessageTemplate("旅游团队GPS轨迹偏离计划路线超过{threshold}米，请立即核实");
        rule5.setCreateTime(currentTime);
        rule5.setUpdateTime(currentTime);
        alertRuleDao.save(rule5);
    }

    private void initAlertReports() {
        AlertReport alert1 = new AlertReport();
        alert1.setContent("黄山风景区游客数量已达最大容量的85%");
        alert1.setAlertType("景区游客");
        alert1.setAlertLevel("警告");
        alert1.setSourceId(1);
        alert1.setSourceName("黄山风景区");
        alert1.setSourceType("景区");
        alert1.setStatus("待处理");
        alert1.setNeedPublish(true);
        alert1.setPublished(false);
        alert1.setCreateTime("2024-06-01 14:30:00");
        alert1.setUpdateTime("2024-06-01 14:30:00");
        alertReportDao.save(alert1);

        AlertReport alert2 = new AlertReport();
        alert2.setContent("南大门停车场占用率达90%，建议引导至北门");
        alert2.setAlertType("停车位");
        alert2.setAlertLevel("警告");
        alert2.setSourceId(1);
        alert2.setSourceName("黄山风景区");
        alert2.setSourceType("景区");
        alert2.setStatus("待处理");
        alert2.setNeedPublish(true);
        alert2.setPublished(false);
        alert2.setCreateTime("2024-06-01 14:25:00");
        alert2.setUpdateTime("2024-06-01 14:25:00");
        alertReportDao.save(alert2);

        AlertReport alert3 = new AlertReport();
        alert3.setContent("宏村半日游团队GPS轨迹偏离计划路线850.5米");
        alert3.setAlertType("GPS轨迹偏离");
        alert3.setAlertLevel("严重");
        alert3.setSourceId(2);
        alert3.setSourceName("宏村半日游");
        alert3.setSourceType("行程单");
        alert3.setStatus("已处理");
        alert3.setNeedPublish(false);
        alert3.setPublished(false);
        alert3.setHandler("值班员A");
        alert3.setHandleTime("2024-05-30 18:30:00");
        alert3.setHandleComment("已联系导游核实，确认为正常路线调整");
        alert3.setCreateTime("2024-05-30 18:00:00");
        alert3.setUpdateTime("2024-05-30 18:30:00");
        alertReportDao.save(alert3);
    }

    private void initComplaintReports() {
        ComplaintReport complaint1 = new ComplaintReport();
        complaint1.setContent("导游服务态度不好，讲解不详细");
        complaint1.setComplaintChannel("网站");
        complaint1.setComplaintDate("2024-05-28 10:30:00");
        complaint1.setComplainantName("张先生");
        complaint1.setComplainantPhone("13800138010");
        complaint1.setComplainantEmail("zhang@example.com");
        complaint1.setComplainedType("导游");
        complaint1.setComplainedId(1);
        complaint1.setComplainedName("张明");
        complaint1.setFirstHandler("客服A");
        complaint1.setFirstHandleTime("2024-05-28 10:35:00");
        complaint1.setStatus("处理中");
        complaint1.setHandler("客服A");
        complaint1.setHandleTime("2024-05-28 11:00:00");
        complaint1.setHandleResult("处理中");
        complaint1.setHandleComment("已联系导游核实情况");
        complaint1.setCreateTime("2024-05-28 10:30:00");
        complaint1.setUpdateTime("2024-05-28 11:00:00");
        complaintReportDao.save(complaint1);

        ComplaintReport complaint2 = new ComplaintReport();
        complaint2.setContent("景区门票价格与宣传不符");
        complaint2.setComplaintChannel("电话");
        complaint2.setComplaintDate("2024-05-27 15:20:00");
        complaint2.setComplainantName("李女士");
        complaint2.setComplainantPhone("13900139010");
        complaint2.setComplainedType("景区");
        complaint2.setComplainedId(1);
        complaint2.setComplainedName("黄山风景区");
        complaint2.setFirstHandler("客服B");
        complaint2.setFirstHandleTime("2024-05-27 15:25:00");
        complaint2.setStatus("待处理");
        complaint2.setCreateTime("2024-05-27 15:20:00");
        complaint2.setUpdateTime("2024-05-27 15:25:00");
        complaintReportDao.save(complaint2);

        ComplaintReport complaint3 = new ComplaintReport();
        complaint3.setContent("酒店房间设施损坏，影响住宿体验");
        complaint3.setComplaintChannel("现场");
        complaint3.setComplaintDate("2024-05-30 20:00:00");
        complaint3.setComplainantName("王先生");
        complaint3.setComplainantPhone("13700137010");
        complaint3.setComplainedType("饭店");
        complaint3.setComplainedId(1);
        complaint3.setComplainedName("黄山国际大酒店");
        complaint3.setFirstHandler("客服C");
        complaint3.setFirstHandleTime("2024-05-30 20:05:00");
        complaint3.setStatus("已处理");
        complaint3.setHandler("客服C");
        complaint3.setHandleTime("2024-05-30 20:30:00");
        complaint3.setHandleResult("已解决");
        complaint3.setHandleComment("已更换房间并致歉，客人满意");
        complaint3.setSatisfactionRating(5);
        complaint3.setSatisfactionComment("处理及时，态度良好");
        complaint3.setCreateTime("2024-05-30 20:00:00");
        complaint3.setUpdateTime("2024-05-30 20:30:00");
        complaintReportDao.save(complaint3);
    }

    private void initCreditArchives() {
        CreditArchive archive1 = new CreditArchive();
        archive1.setEntityType("旅行社");
        archive1.setEntityId(1);
        archive1.setEntityName("黄山国际旅行社");
        archive1.setCreditScore(92);
        archive1.setCreditLevel("优秀");
        archive1.setTotalComplaints(12);
        archive1.setResolvedComplaints(12);
        archive1.setUnresolvedComplaints(0);
        archive1.setSeriousComplaints(0);
        archive1.setHandleTimelyRate(100.0);
        archive1.setHandleSatisfaction(4.8);
        archive1.setViolationCount(0);
        archive1.setRewardCount(2);
        archive1.setComprehensiveEvaluation("诚信经营，服务规范，投诉处理及时");
        archive1.setLastEvaluationTime("2024-05-30 10:00:00");
        archive1.setCreateTime("2024-01-01 00:00:00");
        archive1.setUpdateTime("2024-05-30 10:00:00");
        creditArchiveDao.save(archive1);

        CreditArchive archive2 = new CreditArchive();
        archive2.setEntityType("景区");
        archive2.setEntityId(1);
        archive2.setEntityName("黄山风景区");
        archive2.setCreditScore(85);
        archive2.setCreditLevel("良好");
        archive2.setTotalComplaints(28);
        archive2.setResolvedComplaints(27);
        archive2.setUnresolvedComplaints(1);
        archive2.setSeriousComplaints(2);
        archive2.setHandleTimelyRate(96.4);
        archive2.setHandleSatisfaction(4.5);
        archive2.setViolationCount(1);
        archive2.setRewardCount(1);
        archive2.setComprehensiveEvaluation("整体运营良好，偶有投诉，处理及时");
        archive2.setLastEvaluationTime("2024-05-28 15:00:00");
        archive2.setCreateTime("2024-01-01 00:00:00");
        archive2.setUpdateTime("2024-05-28 15:00:00");
        creditArchiveDao.save(archive2);

        CreditArchive archive3 = new CreditArchive();
        archive3.setEntityType("饭店");
        archive3.setEntityId(1);
        archive3.setEntityName("黄山国际大酒店");
        archive3.setCreditScore(88);
        archive3.setCreditLevel("良好");
        archive3.setTotalComplaints(8);
        archive3.setResolvedComplaints(8);
        archive3.setUnresolvedComplaints(0);
        archive3.setSeriousComplaints(0);
        archive3.setHandleTimelyRate(100.0);
        archive3.setHandleSatisfaction(4.7);
        archive3.setViolationCount(0);
        archive3.setRewardCount(1);
        archive3.setComprehensiveEvaluation("服务质量良好，投诉处理及时");
        archive3.setLastEvaluationTime("2024-05-25 10:00:00");
        archive3.setCreateTime("2024-01-01 00:00:00");
        archive3.setUpdateTime("2024-05-25 10:00:00");
        creditArchiveDao.save(archive3);

        CreditArchive archive4 = new CreditArchive();
        archive4.setEntityType("导游");
        archive4.setEntityId(1);
        archive4.setEntityName("张明");
        archive4.setCreditScore(90);
        archive4.setCreditLevel("优秀");
        archive4.setTotalComplaints(3);
        archive4.setResolvedComplaints(2);
        archive4.setUnresolvedComplaints(1);
        archive4.setSeriousComplaints(0);
        archive4.setHandleTimelyRate(66.7);
        archive4.setHandleSatisfaction(4.5);
        archive4.setViolationCount(0);
        archive4.setRewardCount(0);
        archive4.setComprehensiveEvaluation("专业水平高，偶有服务态度投诉");
        archive4.setLastEvaluationTime("2024-05-20 10:00:00");
        archive4.setCreateTime("2024-01-01 00:00:00");
        archive4.setUpdateTime("2024-05-20 10:00:00");
        creditArchiveDao.save(archive4);
    }

    private void initUsers() {
        User user1 = new User();
        user1.setName("admin");
        user1.setPsw("admin123");
        userDao.save(user1);

        User user2 = new User();
        user2.setName("operator");
        user2.setPsw("operator123");
        userDao.save(user2);
    }
}

