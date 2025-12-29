# 前后端API集成指南

本文档说明前端页面如何从后端API获取数据，替代硬编码数据。

## API基础配置

所有前端页面使用统一的API基础地址：
```javascript
const API_BASE = 'http://localhost:8080';
```

## 已完成的页面集成

### 1. MainMenu.html (主菜单/景区管理)
- ✅ 从 `/tourist` API获取景区列表
- ✅ 从 `/tourist/{id}` API获取单个景区详情
- ✅ 实时更新游客数量、停车位数量
- ✅ 显示景区基础信息、管理人员信息、地理位置信息、应急救援信息

### 2. Guides.html (导游管理)
- ✅ 从 `/guides` API获取导游列表
- ✅ 从 `/guides/{id}` API获取单个导游详情
- ✅ 支持新增、编辑、删除导游
- ✅ 实时更新导游位置和团队信息

### 3. HotelManagement.html (饭店管理)
- ✅ 从 `/hotel` API获取饭店列表
- ✅ 实时更新入住率、停车位信息
- ✅ 显示饭店基础信息和管理人员信息

## 需要更新的页面

### 4. CatiousSystem.html (告警设定中心)
需要从以下API获取数据：
- `/alert-rule` - 获取告警规则列表
- `/alert` - 获取告警报告列表
- `/alert/status/{status}` - 按状态获取告警
- `/alert/type/{alertType}` - 按类型获取告警

### 5. TouristsBack.html (游客投诉中心)
需要从以下API获取数据：
- `/complaint` - 获取投诉列表
- `/complaint/status/{status}` - 按状态获取投诉
- `/complaint/complained/{type}` - 按被投诉类型获取投诉

### 6. CompanyBelieve.html (企业诚信档案管理)
需要从以下API获取数据：
- `/credit-archive` - 获取诚信档案列表
- `/credit-archive/type/{type}` - 按类型获取档案
- `/credit-archive/level/{level}` - 按等级获取档案

### 7. Departments and vechicies.html (旅行社及车辆管理)
需要从以下API获取数据：
- `/travel-agency` - 获取旅行社列表
- `/tour-vehicle` - 获取车辆列表
- `/tour-vehicle/agency/{agencyId}` - 获取指定旅行社的车辆
- `/electronic-itinerary` - 获取电子行程单列表
- `/electronic-itinerary/deviated` - 获取偏离行程
- `/outbound-tour` - 获取出境游信息

## API端点列表

### 景区管理
- `GET /tourist` - 获取所有景区
- `GET /tourist/{id}` - 获取指定景区
- `POST /tourist` - 创建景区
- `PUT /tourist/{id}` - 更新景区
- `DELETE /tourist/{id}` - 删除景区

### 饭店管理
- `GET /hotel` - 获取所有饭店
- `GET /hotel/{id}` - 获取指定饭店
- `POST /hotel` - 创建饭店
- `PUT /hotel/{id}` - 更新饭店
- `DELETE /hotel/{id}` - 删除饭店

### 导游管理
- `GET /guides` - 获取所有导游
- `GET /guides/{id}` - 获取指定导游
- `POST /guides` - 创建导游
- `PUT /guides/{id}` - 更新导游
- `DELETE /guides/{id}` - 删除导游

### 旅行社管理
- `GET /travel-agency` - 获取所有旅行社
- `GET /travel-agency/{id}` - 获取指定旅行社
- `POST /travel-agency` - 创建旅行社
- `PUT /travel-agency/{id}` - 更新旅行社
- `DELETE /travel-agency/{id}` - 删除旅行社

### 车辆管理
- `GET /tour-vehicle` - 获取所有车辆
- `GET /tour-vehicle/{id}` - 获取指定车辆
- `GET /tour-vehicle/agency/{agencyId}` - 获取指定旅行社的车辆
- `GET /tour-vehicle/status/{status}` - 按状态获取车辆
- `POST /tour-vehicle` - 创建车辆
- `PUT /tour-vehicle/{id}` - 更新车辆
- `DELETE /tour-vehicle/{id}` - 删除车辆

### 电子行程单
- `GET /electronic-itinerary` - 获取所有行程单
- `GET /electronic-itinerary/{id}` - 获取指定行程单
- `GET /electronic-itinerary/deviated` - 获取偏离行程
- `GET /electronic-itinerary/agency/{agencyId}` - 获取指定旅行社的行程单
- `POST /electronic-itinerary` - 创建行程单
- `PUT /electronic-itinerary/{id}` - 更新行程单
- `DELETE /electronic-itinerary/{id}` - 删除行程单

### 告警管理
- `GET /alert` - 获取所有告警
- `GET /alert/{id}` - 获取指定告警
- `GET /alert/status/{status}` - 按状态获取告警
- `GET /alert/type/{alertType}` - 按类型获取告警
- `POST /alert` - 创建告警
- `PUT /alert/{id}` - 更新告警
- `DELETE /alert/{id}` - 删除告警

### 告警规则
- `GET /alert-rule` - 获取所有规则
- `GET /alert-rule/{id}` - 获取指定规则
- `GET /alert-rule/type/{ruleType}` - 按类型获取规则
- `GET /alert-rule/enabled` - 获取启用的规则
- `POST /alert-rule` - 创建规则
- `PUT /alert-rule/{id}` - 更新规则
- `DELETE /alert-rule/{id}` - 删除规则

### 投诉管理
- `GET /complaint` - 获取所有投诉
- `GET /complaint/{id}` - 获取指定投诉
- `GET /complaint/status/{status}` - 按状态获取投诉
- `GET /complaint/complained/{type}` - 按被投诉类型获取投诉
- `POST /complaint` - 创建投诉
- `PUT /complaint/{id}` - 更新投诉
- `DELETE /complaint/{id}` - 删除投诉

### 诚信档案
- `GET /credit-archive` - 获取所有档案
- `GET /credit-archive/{id}` - 获取指定档案
- `GET /credit-archive/entity/{type}/{id}` - 获取指定实体的档案
- `GET /credit-archive/type/{type}` - 按类型获取档案
- `GET /credit-archive/level/{level}` - 按等级获取档案
- `POST /credit-archive` - 创建档案
- `PUT /credit-archive/{id}` - 更新档案
- `POST /credit-archive/update-from-complaint/{type}/{id}` - 根据投诉更新档案
- `DELETE /credit-archive/{id}` - 删除档案

## 通用数据加载模式

```javascript
const API_BASE = 'http://localhost:8080';

// 加载数据
function loadData() {
    $.ajax({
        type: "GET",
        url: API_BASE + "/your-endpoint",
        dataType: "json",
        success: function(data) {
            updateUI(data);
        },
        error: function(xhr, status, error) {
            console.error('获取数据失败:', error);
        }
    });
}

// 更新UI
function updateUI(data) {
    // 处理数据并更新页面元素
}

// 页面加载时初始化
document.addEventListener('DOMContentLoaded', function() {
    loadData();
    // 定时刷新
    setInterval(loadData, 5000);
});
```

## 注意事项

1. 所有API请求都使用CORS跨域支持（后端已配置`@CrossOrigin(origins = "*")`）
2. 数据格式为JSON，使用jQuery的`dataType: "json"`自动解析
3. 错误处理：所有API调用都应包含错误处理逻辑
4. 实时更新：关键数据应定时刷新（建议5-10秒）
5. 数据验证：前端应验证数据是否存在再更新UI

