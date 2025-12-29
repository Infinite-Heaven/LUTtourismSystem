# 旅游行业管理与运行调度系统

## 项目概述

**旅游行业管理与运行调度系统**是一个基于Spring Boot和MySQL的综合性旅游管理平台，旨在实现对旅游行业各要素的全面监控、管理和调度。系统覆盖景区、饭店、旅行社、导游、车辆等核心业务实体，提供实时数据监控、告警管理、投诉处理、诚信档案等完整的管理功能。

### 项目信息
- **项目名称**: LUTtourismSystem
- **版本**: 0.0.1-SNAPSHOT
- **开发框架**: Spring Boot 4.0.1
- **Java版本**: 17
- **数据库**: MySQL 5.7+
- **服务端口**: 8080

---

## 项目背景

随着旅游业的快速发展，旅游管理部门需要一套完整的系统来：
- 实时监控景区、饭店等旅游设施的运营状态
- 管理旅行社、导游、车辆等旅游服务提供者
- 及时处理游客投诉，维护旅游市场秩序
- 建立企业诚信档案，促进旅游行业健康发展
- 提供告警机制，预防和应对突发事件

---

## 核心功能模块

### 1. 旅游景区管理
- **基础信息管理**: 景区名称、最大容量、停车位数量等
- **人员管理**: 管理人员信息、紧急联系人
- **实时监控**: 当前游客数量、停车位使用情况
- **地理位置**: 经纬度坐标、详细地址、电子地图链接
- **应急救援**: 应急联系人、应急车辆信息

### 2. 星级饭店管理
- **基础信息**: 饭店名称、星级评定、最大接待量
- **实时数据**: 当前入住率、入住房间数、停车位使用情况
- **人员管理**: 管理人员、应急救援人员信息
- **地理位置**: 坐标信息、地址信息

### 3. 旅行社及旅游车辆管理
- **旅行社管理**:
  - 资质等级（AAAA级、AAA级等）
  - 诚信状态、诚信评分
  - 今日团队出游人数统计
  - 出境旅游业务管理
- **车辆管理**:
  - 车辆基本信息（车牌号、车型、座位数）
  - 驾驶员信息
  - 实时位置追踪（GPS坐标）
  - 车辆运行状态（运行中/停靠）
  - 当前载客数量
- **电子行程单管理**:
  - 计划路线与实际路线对比
  - GPS轨迹偏离检测
  - 偏离阈值设定与告警
  - 行程状态跟踪
- **出境游管理**:
  - 出境旅游团队信息
  - 签证申请与审核流程
  - 目的地管理

### 4. 导游管理
- **注册登记**: 导游注册号、注册日期、注册状态
- **资格审验**: 资质审验状态、审验日期、资格等级
- **求职应聘**: 求职状态、简历管理
- **行程单申领**: 已申领数量、最后申领日期
- **实时监控**: 当前位置（GPS坐标）、当前团队信息
- **执业状况**: 执业状态、总带团次数、平均评分

### 5. 告警（提示）信息设定及管理
- **告警规则设定**:
  - 景区游客容量百分比阈值
  - 停车位占用率阈值
  - 饭店入住率阈值
  - 缆车等候时间阈值
  - GPS轨迹偏离阈值（米）
- **告警报告管理**:
  - 告警生成与记录
  - 告警级别分类（提示/警告/严重）
  - 告警处理流程（待处理/已处理/已发布）
  - 告警审批机制
  - 发布渠道管理（短信/电台/大屏等）

### 6. 游客投诉管理
- **投诉记录**: 投诉内容、投诉渠道、投诉时间
- **投诉人信息**: 姓名、联系方式、邮箱
- **被投诉对象**: 类型（景区/饭店/旅行社/导游/车辆）、ID、名称
- **处理流程**:
  - 首问负责制（首问负责人、首问处理时间）
  - 处理状态跟踪（待处理/处理中/已处理/已关闭）
  - 处理结果记录
  - 满意度评价（评分1-5、评价内容）

### 7. 企业诚信档案管理
- **档案信息**: 企业名称、统一社会信用代码、企业类型
- **诚信评价**:
  - 初始诚信等级、当前诚信等级
  - 诚信评分（0-100）
  - 投诉统计（总投诉数、已解决投诉数、未解决投诉数、严重投诉数）
  - 处理及时率、处理满意度
  - 违规次数、奖励次数
- **综合评价**: 综合评估意见、评估时间

---

## 技术架构

### 后端技术栈
- **框架**: Spring Boot 4.0.1
- **ORM**: Spring Data JPA + Hibernate 7.2.0
- **数据库**: MySQL 5.7+ (使用MySQL Connector/J 9.5.0)
- **工具库**: Lombok 1.18.42 (简化代码)
- **连接池**: HikariCP 7.0.2
- **Web框架**: Spring WebMVC

### 前端技术栈
- **HTML5**: 页面结构
- **CSS3**: 样式设计（包含响应式布局）
- **JavaScript**: 交互逻辑
- **jQuery**: DOM操作和AJAX请求
- **地图服务**: 百度地图 (https://map.baidu.com/)

### 系统架构
```
┌─────────────────────────────────────────┐
│           前端层 (Frontend)              │
│  HTML + CSS + JavaScript + jQuery        │
└─────────────────┬───────────────────────┘
                  │ HTTP/REST API
┌─────────────────▼───────────────────────┐
│        后端层 (Backend)                  │
│  ┌──────────────────────────────────┐   │
│  │   Controller层 (REST API)        │   │
│  └───────────┬──────────────────────┘   │
│              │                           │
│  ┌───────────▼──────────────────────┐   │
│  │   Service层 (业务逻辑)            │   │
│  └───────────┬──────────────────────┘   │
│              │                           │
│  ┌───────────▼──────────────────────┐   │
│  │   Dao层 (数据访问)               │   │
│  └───────────┬──────────────────────┘   │
└──────────────┼─────────────────────────────┘
               │
┌──────────────▼─────────────────────────────┐
│        数据层 (Database)                   │
│         MySQL 5.7+                         │
└────────────────────────────────────────────┘
```

---

## 数据库设计

### 核心数据表

1. **tourist_attraction** - 景区表
2. **hotel** - 饭店表
3. **travel_agency** - 旅行社表
4. **tour_vehicle** - 旅游车辆表
5. **electronic_itinerary** - 电子行程单表
6. **outbound_tour** - 出境游表
7. **guide** - 导游表
8. **alert_rule** - 告警规则表
9. **alert_report** - 告警报告表
10. **complaint_report** - 投诉报告表
11. **credit_archive** - 诚信档案表
12. **user** - 用户表

### 数据初始化
系统启动时自动初始化测试数据（`DataInitializer`类），包括：
- 2个景区（黄山风景区、宏村景区）
- 2个饭店（5星和4星酒店）
- 2个导游（高级和中级）
- 2个旅行社（AAAA级和AAA级）
- 3辆旅游车辆
- 2个电子行程单（包含偏离检测）
- 2个出境游申请
- 5条告警规则
- 3条告警报告
- 3条投诉记录
- 4条诚信档案
- 2个用户账户

---

## API接口文档

### 基础配置
- **API基础地址**: `http://localhost:8080`
- **跨域支持**: 所有Controller已启用`@CrossOrigin(origins = "*")`

### 主要API端点

#### 景区管理
- `GET /tourist` - 获取所有景区
- `GET /tourist/{id}` - 获取指定景区
- `POST /tourist` - 创建景区
- `PUT /tourist/{id}` - 更新景区
- `DELETE /tourist/{id}` - 删除景区

#### 饭店管理
- `GET /hotel` - 获取所有饭店
- `GET /hotel/{id}` - 获取指定饭店
- `POST /hotel` - 创建饭店
- `PUT /hotel/{id}` - 更新饭店
- `DELETE /hotel/{id}` - 删除饭店

#### 导游管理
- `GET /guides` - 获取所有导游
- `GET /guides/{id}` - 获取指定导游
- `POST /guides` - 创建导游
- `PUT /guides/{id}` - 更新导游
- `DELETE /guides/{id}` - 删除导游

#### 旅行社管理
- `GET /travel-agency` - 获取所有旅行社
- `GET /travel-agency/{id}` - 获取指定旅行社
- `POST /travel-agency` - 创建旅行社
- `PUT /travel-agency/{id}` - 更新旅行社
- `DELETE /travel-agency/{id}` - 删除旅行社

#### 车辆管理
- `GET /tour-vehicle` - 获取所有车辆
- `GET /tour-vehicle/{id}` - 获取指定车辆
- `GET /tour-vehicle/agency/{agencyId}` - 获取指定旅行社的车辆
- `GET /tour-vehicle/status/{status}` - 按状态获取车辆
- `POST /tour-vehicle` - 创建车辆
- `PUT /tour-vehicle/{id}` - 更新车辆
- `DELETE /tour-vehicle/{id}` - 删除车辆

#### 电子行程单
- `GET /electronic-itinerary` - 获取所有行程单
- `GET /electronic-itinerary/{id}` - 获取指定行程单
- `GET /electronic-itinerary/deviated` - 获取偏离行程
- `GET /electronic-itinerary/agency/{agencyId}` - 获取指定旅行社的行程单
- `POST /electronic-itinerary` - 创建行程单
- `PUT /electronic-itinerary/{id}` - 更新行程单
- `DELETE /electronic-itinerary/{id}` - 删除行程单

#### 出境游管理
- `GET /outbound-tour` - 获取所有出境游信息
- `GET /outbound-tour/{id}` - 获取指定出境游信息
- `POST /outbound-tour` - 创建出境游申请
- `PUT /outbound-tour/{id}` - 更新出境游信息（支持签证审核）
- `DELETE /outbound-tour/{id}` - 删除出境游信息

#### 告警管理
- `GET /alert-rule` - 获取所有告警规则
- `GET /alert-rule/{id}` - 获取指定告警规则
- `POST /alert-rule` - 创建告警规则
- `PUT /alert-rule/{id}` - 更新告警规则
- `DELETE /alert-rule/{id}` - 删除告警规则
- `GET /alert` - 获取所有告警报告
- `GET /alert/{id}` - 获取指定告警报告
- `GET /alert/status/{status}` - 按状态获取告警
- `GET /alert/type/{alertType}` - 按类型获取告警
- `POST /alert` - 创建告警报告
- `PUT /alert/{id}` - 更新告警报告（处理/审批）
- `DELETE /alert/{id}` - 删除告警报告

#### 投诉管理
- `GET /complaint` - 获取所有投诉
- `GET /complaint/{id}` - 获取指定投诉
- `GET /complaint/status/{status}` - 按状态获取投诉
- `GET /complaint/complained/{type}` - 按被投诉类型获取投诉
- `POST /complaint` - 创建投诉
- `PUT /complaint/{id}` - 更新投诉（处理投诉）
- `DELETE /complaint/{id}` - 删除投诉

#### 诚信档案管理
- `GET /credit-archive` - 获取所有诚信档案
- `GET /credit-archive/{id}` - 获取指定诚信档案
- `GET /credit-archive/type/{type}` - 按类型获取档案
- `GET /credit-archive/level/{level}` - 按等级获取档案
- `POST /credit-archive` - 创建诚信档案
- `PUT /credit-archive/{id}` - 更新诚信档案（重新评价）
- `DELETE /credit-archive/{id}` - 删除诚信档案

详细API文档请参考: `frontpage/API_INTEGRATION_GUIDE.md`

---

## 前端页面

### 主要页面列表

1. **Login.html** - 登录页面
2. **MainMenu.html** - 主菜单/景区管理页面
   - 景区基础信息展示
   - 实时数据监控（游客数量、停车位）
   - 管理人员信息
   - 地理位置信息
   - 电子地图链接
   - 应急救援信息
3. **HotelManagement.html** - 饭店管理页面
   - 饭店基础信息
   - 入住率实时监控
   - 停车位信息
4. **Guides.html** - 导游管理页面
   - 导游基础信息
   - 注册登记管理
   - 资格审验管理
   - 求职应聘管理
   - 实时位置监控
5. **Departments and vechicies.html** - 旅行社及车辆管理页面
   - 旅行社管理
   - 车辆管理
   - 电子行程单管理
   - 出境游管理（签证审核）
6. **CatiousSystem.html** - 告警设定中心
   - 告警规则设定
   - 告警报告管理
   - 告警处理流程
7. **TouristsBack.html** - 游客投诉中心
   - 投诉列表展示
   - 投诉处理流程
   - 满意度评价
8. **CompanyBelieve.html** - 企业诚信档案管理
   - 诚信档案列表
   - 诚信评价
   - 投诉关联

### 前端特性
- ✅ 所有数据从后端API动态获取，无硬编码数据
- ✅ 实时数据更新（5-30秒自动刷新）
- ✅ 响应式设计，适配不同屏幕尺寸
- ✅ 交互式UI，提供良好的用户体验
- ✅ 错误处理和调试信息

---

## 部署说明

### 环境要求
- **JDK**: 17或更高版本
- **MySQL**: 5.7或更高版本
- **Maven**: 3.6+ (可选，项目包含Maven Wrapper)

### 数据库配置

1. 创建数据库:
```sql
CREATE DATABASE tourism_management_system 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;
```

2. 配置数据库连接:
编辑 `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tourism_management_system?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=your_password
```

### 启动步骤

1. **克隆项目**:
```bash
git clone <repository-url>
cd LUTtourismSystem
```

2. **配置数据库**: 修改`application.properties`中的数据库连接信息

3. **启动后端服务**:
```bash
# 使用Maven Wrapper
./mvnw spring-boot:run

# 或使用Maven
mvn spring-boot:run

# 或使用IDE直接运行 LuTtourismSystemApplication
```

4. **访问前端页面**:
   - 打开浏览器访问 `frontpage/` 目录下的HTML文件
   - 或使用Web服务器（如Nginx、Apache）部署前端文件
   - 确保前端可以访问后端API (`http://localhost:8080`)

### 默认账户
- 用户名: `admin` / 密码: `admin123`
- 用户名: `operator` / 密码: `operator123`

---

## 开发说明

### 项目结构
```
LUTtourismSystem/
├── frontpage/                    # 前端页面目录
│   ├── MainMenu.html            # 主菜单/景区管理
│   ├── HotelManagement.html     # 饭店管理
│   ├── Guides.html              # 导游管理
│   ├── Departments and vechicies.html  # 旅行社及车辆管理
│   ├── CatiousSystem.html       # 告警设定中心
│   ├── TouristsBack.html        # 游客投诉中心
│   ├── CompanyBelieve.html      # 企业诚信档案管理
│   ├── Login.html               # 登录页面
│   └── API_INTEGRATION_GUIDE.md # API集成指南
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── lut/luttourismsystem/
│   │   │       ├── Config/
│   │   │       │   └── DataInitializer.java  # 数据初始化
│   │   │       ├── Controller/               # REST API控制器
│   │   │       ├── Service/                   # 业务逻辑层
│   │   │       ├── Dao/                      # 数据访问层
│   │   │       ├── Entity/                   # 实体类
│   │   │       └── LuTtourismSystemApplication.java
│   │   └── resources/
│   │       └── application.properties        # 配置文件
│   └── test/                                  # 测试代码
├── pom.xml                                    # Maven配置
└── README.md                                  # 项目文档
```

### 开发规范
- **命名规范**: 
  - 实体类使用PascalCase（如`TouristAttraction`）
  - 方法名使用camelCase（如`findAllTouristattractions`）
  - 数据库表名使用snake_case（如`tourist_attraction`）
- **代码风格**: 使用Lombok简化代码，遵循Spring Boot最佳实践
- **API设计**: RESTful风格，使用标准HTTP方法

### 数据初始化
系统启动时，`DataInitializer`类会自动检查各表是否有数据：
- 如果表为空，自动插入测试数据
- 如果表已有数据，跳过初始化（避免重复插入）

---

## 功能亮点

1. **实时监控**: 支持实时数据更新，监控景区、饭店等设施的运营状态
2. **GPS轨迹偏离检测**: 通过对比计划路线和实际GPS轨迹，自动检测偏离并告警
3. **首问负责制**: 投诉管理实现首问负责制，确保投诉得到及时处理
4. **诚信评价体系**: 建立完整的诚信档案系统，关联投诉信息进行综合评价
5. **多级告警机制**: 支持多种告警规则设定，分级告警（提示/警告/严重）
6. **数据可视化**: 前端提供直观的数据展示和状态指示
7. **完整的管理流程**: 从信息录入到处理跟踪，提供完整的管理闭环

---

## 技术特点

1. **前后端分离**: 前端使用HTML+JavaScript，后端提供RESTful API
2. **自动数据初始化**: 启动时自动创建测试数据，方便开发和测试
3. **跨域支持**: 后端已配置CORS，支持跨域访问
4. **数据库自动更新**: 使用JPA的`ddl-auto=update`，自动创建和更新表结构
5. **连接池优化**: 使用HikariCP连接池，提高数据库访问性能
6. **代码简化**: 使用Lombok减少样板代码

---

## 未来扩展方向

1. **用户权限管理**: 实现基于角色的访问控制（RBAC）
2. **数据统计分析**: 添加数据统计和报表功能
3. **消息推送**: 集成短信、邮件等通知渠道
4. **地图集成**: 深度集成百度地图API，实现地图可视化
5. **移动端支持**: 开发移动端应用或响应式优化
6. **数据导出**: 支持Excel、PDF等格式的数据导出
7. **日志审计**: 添加操作日志记录和审计功能
8. **API文档**: 集成Swagger/OpenAPI生成API文档

---

## 注意事项

1. **数据库密码**: 请修改`application.properties`中的数据库密码为实际密码
2. **端口冲突**: 如果8080端口被占用，可在`application.properties`中修改`server.port`
3. **跨域配置**: 生产环境建议限制CORS的允许来源，而不是使用`*`
4. **数据安全**: 生产环境应使用HTTPS，并加强数据加密
5. **性能优化**: 大量数据时考虑添加分页、缓存等优化措施

---

## 许可证

本项目为内部项目，版权归开发团队所有。

---

## 联系方式

如有问题或建议，请联系开发团队。

---

**最后更新**: 2024年12月


