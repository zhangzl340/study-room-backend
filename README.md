## 📋 后端开发完整方案

### 🗂️ **后端项目文件结构**

text

```
study-room-booking-backend/
├── src/main/java/com/studyroom/
│   ├── StudyRoomApplication.java        # 启动类
│   ├── config/                          # 配置类目录
│   │   ├── CorsConfig.java              # 跨域配置
│   │   ├── RedisConfig.java             # Redis配置
│   │   ├── MyBatisPlusConfig.java       # MyBatisPlus配置
│   │   ├── Knife4jConfig.java           # 接口文档配置
│   │   ├── WebSecurityConfig.java       # Spring Security配置
│   │   ├── WebSocketConfig.java         # WebSocket配置
│   │   ├── ScheduleConfig.java          # 定时任务配置
│   │   └── AsyncConfig.java             # 异步处理配置
│   ├── common/                          # 通用模块
│   │   ├── exception/                   # 异常处理
│   │   │   ├── GlobalExceptionHandler.java
│   │   │   ├── BusinessException.java
│   │   │   └── ErrorCode.java
│   │   ├── result/                      # 统一返回
│   │   │   ├── Result.java
│   │   │   ├── ResultCode.java
│   │   │   └── PageResult.java
│   │   ├── utils/                       # 工具类
│   │   │   ├── JwtUtils.java
│   │   │   ├── Md5Utils.java
│   │   │   ├── DateUtils.java
│   │   │   ├── ExcelUtils.java
│   │   │   ├── ValidatorUtils.java
│   │   │   ├── RedisUtils.java
│   │   │   └── WebSocketUtils.java
│   │   ├── constant/                    # 常量定义
│   │   │   ├── UserConstant.java
│   │   │   ├── RoomConstant.java
│   │   │   ├── ReservationConstant.java
│   │   │   ├── SeatConstant.java
│   │   │   └── RedisKeyConstant.java
│   │   └── interceptor/                 # 拦截器
│   │       ├── AuthInterceptor.java
│   │       ├── RateLimitInterceptor.java
│   │       └── LogInterceptor.java
│   ├── modules/                         # 业务模块（核心）
│   │   ├── user/                        # 用户模块
│   │   │   ├── controller/
│   │   │   │   ├── StudentUserController.java    # 学生端用户接口
│   │   │   │   ├── AdminUserController.java      # 管理端用户接口
│   │   │   │   └── AuthController.java          # 认证相关接口
│   │   │   ├── service/
│   │   │   │   ├── UserService.java
│   │   │   │   ├── StudentService.java
│   │   │   │   ├── AdminService.java
│   │   │   │   ├── AuthService.java
│   │   │   │   └── impl/
│   │   │   ├── mapper/
│   │   │   │   ├── UserMapper.java
│   │   │   │   ├── StudentMapper.java
│   │   │   │   └── AdminMapper.java
│   │   │   ├── entity/
│   │   │   │   ├── User.java
│   │   │   │   ├── Student.java
│   │   │   │   └── Admin.java
│   │   │   ├── dto/
│   │   │   │   ├── request/
│   │   │   │   │   ├── LoginReq.java
│   │   │   │   │   ├── RegisterReq.java
│   │   │   │   │   ├── UserUpdateReq.java
│   │   │   │   │   └── BatchImportReq.java
│   │   │   │   └── response/
│   │   │   │       ├── UserInfoRes.java
│   │   │   │       ├── LoginRes.java
│   │   │   │       └── UserListRes.java
│   │   │   └── vo/
│   │   │       ├── UserVO.java
│   │   │       └── StudentVO.java
│   │   ├── room/                        # 自习室模块
│   │   │   ├── controller/
│   │   │   │   ├── RoomController.java
│   │   │   │   └── SeatController.java
│   │   │   ├── service/
│   │   │   ├── mapper/
│   │   │   ├── entity/
│   │   │   │   ├── StudyRoom.java
│   │   │   │   ├── Seat.java
│   │   │   │   └── RoomOpenTime.java
│   │   │   ├── dto/
│   │   │   └── vo/
│   │   ├── reservation/                 # 预约模块
│   │   │   ├── controller/
│   │   │   │   ├── ReservationController.java
│   │   │   │   └── CheckInController.java
│   │   │   ├── service/
│   │   │   ├── mapper/
│   │   │   ├── entity/
│   │   │   │   ├── Reservation.java
│   │   │   │   └── CheckInRecord.java
│   │   │   ├── dto/
│   │   │   └── vo/
│   │   ├── statistics/                  # 统计模块
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── mapper/
│   │   │   ├── entity/
│   │   │   ├── dto/
│   │   │   └── vo/
│   │   ├── admin/                       # 管理模块
│   │   │   ├── controller/
│   │   │   │   ├── SystemController.java
│   │   │   │   ├── AnnouncementController.java
│   │   │   │   └── RuleController.java
│   │   │   ├── service/
│   │   │   ├── mapper/
│   │   │   ├── entity/
│   │   │   │   ├── SystemConfig.java
│   │   │   │   ├── Announcement.java
│   │   │   │   └── RuleConfig.java
│   │   │   ├── dto/
│   │   │   └── vo/
│   │   ├── violation/                   # 违规模块
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── mapper/
│   │   │   ├── entity/
│   │   │   │   └── ViolationRecord.java
│   │   │   ├── dto/
│   │   │   └── vo/
│   │   └── external/                    # 外部对接模块
│   │       ├── controller/
│   │       │   ├── FaceRecognitionController.java
│   │       │   └── ScreenController.java
│   │       ├── service/
│   │       ├── dto/
│   │       └── vo/
│   ├── task/                            # 定时任务
│   │   ├── ReservationTask.java         # 预约超时任务
│   │   ├── StatisticsTask.java          # 统计任务
│   │   ├── CleanupTask.java             # 清理任务
│   │   └── CacheRefreshTask.java        # 缓存刷新任务
│   └── websocket/                       # WebSocket模块
│       ├── WebSocketServer.java
│       ├── handler/
│       │   ├── SeatStatusHandler.java
│       │   └── NotificationHandler.java
│       ├── entity/
│       │   ├── WebSocketMessage.java
│       │   └── SeatStatusUpdate.java
│       └── service/
├── src/main/resources/
│   ├── application.yml                  # 主配置文件
│   ├── application-dev.yml              # 开发环境配置
│   ├── application-prod.yml             # 生产环境配置
│   ├── logback-spring.xml               # 日志配置
│   ├── mapper/                          # MyBatis XML映射文件
│   │   ├── user/
│   │   ├── room/
│   │   ├── reservation/
│   │   └── ...
│   ├── static/                          # 静态资源
│   │   └── qrcode/                      # 二维码存放目录
│   └── templates/                       # 模板文件
│       └── email/
│           └── notification.html
├── sql/                                 # SQL脚本目录
│   ├── init.sql                         # 初始化脚本
│   ├── test_data.sql                    # 测试数据
│   ├── update/                          # 更新脚本
│   │   ├── v1.0.1.sql
│   │   └── v1.0.2.sql
│   └── indexes.sql                      # 索引优化脚本
├── docs/                                # 项目文档
│   ├── api/                             # API文档
│   │   ├── student-api.md
│   │   ├── admin-api.md
│   │   └── external-api.md
│   ├── database/                        # 数据库设计文档
│   │   ├── er-diagram.png
│   │   └── table-structure.md
│   ├── deploy/                          # 部署文档
│   │   ├── docker-compose.yml
│   │   ├── nginx.conf
│   │   └── deploy-guide.md
│   └── design/                          # 设计文档
│       ├── architecture.md
│       └── data-flow.md
├── pom.xml                              # Maven配置文件
├── Dockerfile                           # Docker镜像配置
├── docker-compose.yml                   # Docker Compose配置
├── .gitignore
├── README.md
└── CHANGELOG.md
```



### 📝 **完整的接口设计清单**

#### **1. 认证与用户模块 (api/v1/auth)**

| 接口路径                       | 方法 | 描述       | 权限        |
| :----------------------------- | :--- | :--------- | :---------- |
| `/api/v1/auth/student/login`   | POST | 学生登录   | 公开        |
| `/api/v1/auth/admin/login`     | POST | 管理员登录 | 公开        |
| `/api/v1/auth/register`        | POST | 学生注册   | 公开        |
| `/api/v1/auth/logout`          | POST | 退出登录   | 学生/管理员 |
| `/api/v1/auth/refresh-token`   | POST | 刷新Token  | 学生/管理员 |
| `/api/v1/auth/verify-identity` | POST | 实名认证   | 学生        |

#### **2. 学生端自习室模块 (api/v1/student/room)**

| 接口路径                                    | 方法 | 描述             | 权限 |
| :------------------------------------------ | :--- | :--------------- | :--- |
| `/api/v1/student/room/list`                 | GET  | 获取自习室列表   | 学生 |
| `/api/v1/student/room/detail/{roomId}`      | GET  | 自习室详情       | 学生 |
| `/api/v1/student/room/search`               | GET  | 搜索自习室       | 学生 |
| `/api/v1/student/room/seat-status/{roomId}` | GET  | 获取座位状态     | 学生 |
| `/api/v1/student/room/floor/{floorId}`      | GET  | 按楼层获取自习室 | 学生 |

#### **3. 学生端预约模块 (api/v1/student/reservation)**

| 接口路径                                         | 方法   | 描述           | 权限 |
| :----------------------------------------------- | :----- | :------------- | :--- |
| `/api/v1/student/reservation/create`             | POST   | 创建预约       | 学生 |
| `/api/v1/student/reservation/cancel/{id}`        | DELETE | 取消预约       | 学生 |
| `/api/v1/student/reservation/my`                 | GET    | 我的预约列表   | 学生 |
| `/api/v1/student/reservation/detail/{id}`        | GET    | 预约详情       | 学生 |
| `/api/v1/student/reservation/current`            | GET    | 当前有效预约   | 学生 |
| `/api/v1/student/reservation/history`            | GET    | 历史预约记录   | 学生 |
| `/api/v1/student/reservation/check-availability` | POST   | 检查座位可用性 | 学生 |

#### **4. 学生端签到模块 (api/v1/student/check-in)**

| 接口路径                                          | 方法 | 描述             | 权限 |
| :------------------------------------------------ | :--- | :--------------- | :--- |
| `/api/v1/student/check-in/qrcode/{reservationId}` | GET  | 获取签到二维码   | 学生 |
| `/api/v1/student/check-in/scan`                   | POST | 扫码签到         | 学生 |
| `/api/v1/student/check-in/face`                   | POST | 人脸识别签到     | 学生 |
| `/api/v1/student/check-in/out/{reservationId}`    | POST | 签退             | 学生 |
| `/api/v1/student/check-in/temporary-leave`        | POST | 暂离             | 学生 |
| `/api/v1/student/check-in/return`                 | POST | 返回             | 学生 |
| `/api/v1/student/check-in/status`                 | GET  | 获取当前签到状态 | 学生 |

#### **5. 学生端个人中心模块 (api/v1/student/user)**

| 接口路径                                       | 方法   | 描述           | 权限 |
| :--------------------------------------------- | :----- | :------------- | :--- |
| `/api/v1/student/user/profile`                 | GET    | 获取个人资料   | 学生 |
| `/api/v1/student/user/update-profile`          | PUT    | 更新个人资料   | 学生 |
| `/api/v1/student/user/credit-score`            | GET    | 获取信用分明细 | 学生 |
| `/api/v1/student/user/change-password`         | PUT    | 修改密码       | 学生 |
| `/api/v1/student/user/notifications`           | GET    | 获取通知消息   | 学生 |
| `/api/v1/student/user/notifications/read/{id}` | PUT    | 标记消息已读   | 学生 |
| `/api/v1/student/user/notifications/clear`     | DELETE | 清空消息       | 学生 |

#### **6. 管理端自习室管理 (api/v1/admin/room)**

| 接口路径                                         | 方法   | 描述                 | 权限   |
| :----------------------------------------------- | :----- | :------------------- | :----- |
| `/api/v1/admin/room/list`                        | GET    | 自习室列表（管理端） | 管理员 |
| `/api/v1/admin/room/create`                      | POST   | 创建自习室           | 管理员 |
| `/api/v1/admin/room/update/{id}`                 | PUT    | 更新自习室           | 管理员 |
| `/api/v1/admin/room/delete/{id}`                 | DELETE | 删除自习室           | 管理员 |
| `/api/v1/admin/room/seat-layout/{roomId}`        | GET    | 获取座位布局         | 管理员 |
| `/api/v1/admin/room/seat-layout/update/{roomId}` | PUT    | 更新座位布局         | 管理员 |
| `/api/v1/admin/room/import-seats`                | POST   | 导入座位布局         | 管理员 |
| `/api/v1/admin/room/export-seats/{roomId}`       | GET    | 导出座位布局         | 管理员 |
| `/api/v1/admin/room/open-time/{roomId}`          | GET    | 获取开放时间         | 管理员 |
| `/api/v1/admin/room/open-time/update/{roomId}`   | PUT    | 更新开放时间         | 管理员 |

#### **7. 管理端用户管理 (api/v1/admin/user)**

| 接口路径                                        | 方法 | 描述             | 权限   |
| :---------------------------------------------- | :--- | :--------------- | :----- |
| `/api/v1/admin/user/list`                       | GET  | 用户列表         | 管理员 |
| `/api/v1/admin/user/detail/{userId}`            | GET  | 用户详情         | 管理员 |
| `/api/v1/admin/user/create`                     | POST | 创建用户（批量） | 管理员 |
| `/api/v1/admin/user/update/{userId}`            | PUT  | 更新用户信息     | 管理员 |
| `/api/v1/admin/user/reset-password/{userId}`    | PUT  | 重置用户密码     | 管理员 |
| `/api/v1/admin/user/lock/{userId}`              | PUT  | 锁定/解锁用户    | 管理员 |
| `/api/v1/admin/user/identity-audit`             | POST | 实名认证审核     | 管理员 |
| `/api/v1/admin/user/adjust-credit`              | PUT  | 调整信用分       | 管理员 |
| `/api/v1/admin/user/violation-records/{userId}` | GET  | 获取违规记录     | 管理员 |
| `/api/v1/admin/user/import`                     | POST | 批量导入用户     | 管理员 |
| `/api/v1/admin/user/export`                     | GET  | 导出用户列表     | 管理员 |

#### **8. 管理端预约管理 (api/v1/admin/reservation)**

| 接口路径                                      | 方法   | 描述             | 权限   |
| :-------------------------------------------- | :----- | :--------------- | :----- |
| `/api/v1/admin/reservation/list`              | GET    | 预约列表（全部） | 管理员 |
| `/api/v1/admin/reservation/statistics`        | GET    | 预约统计数据     | 管理员 |
| `/api/v1/admin/reservation/force-cancel/{id}` | DELETE | 强制取消预约     | 管理员 |
| `/api/v1/admin/reservation/check-in-records`  | GET    | 签到记录查询     | 管理员 |
| `/api/v1/admin/reservation/abnormal`          | GET    | 异常预约记录     | 管理员 |

#### **9. 管理端统计分析 (api/v1/admin/statistics)**

| 接口路径                                    | 方法 | 描述         | 权限   |
| :------------------------------------------ | :--- | :----------- | :----- |
| `/api/v1/admin/statistics/dashboard`        | GET  | 仪表盘数据   | 管理员 |
| `/api/v1/admin/statistics/usage`            | GET  | 使用率统计   | 管理员 |
| `/api/v1/admin/statistics/peak`             | GET  | 高峰时段分析 | 管理员 |
| `/api/v1/admin/statistics/heatmap/{roomId}` | GET  | 座位热度图   | 管理员 |
| `/api/v1/admin/statistics/user-behavior`    | GET  | 用户行为分析 | 管理员 |
| `/api/v1/admin/statistics/export`           | POST | 导出统计数据 | 管理员 |

#### **10. 管理端系统配置 (api/v1/admin/system)**

| 接口路径                                        | 方法   | 描述         | 权限   |
| :---------------------------------------------- | :----- | :----------- | :----- |
| `/api/v1/admin/system/config`                   | GET    | 获取系统配置 | 管理员 |
| `/api/v1/admin/system/config/update`            | PUT    | 更新系统配置 | 管理员 |
| `/api/v1/admin/system/rule/reservation`         | GET    | 获取预约规则 | 管理员 |
| `/api/v1/admin/system/rule/reservation/update`  | PUT    | 更新预约规则 | 管理员 |
| `/api/v1/admin/system/rule/violation`           | GET    | 获取违规规则 | 管理员 |
| `/api/v1/admin/system/rule/violation/update`    | PUT    | 更新违规规则 | 管理员 |
| `/api/v1/admin/system/announcement/list`        | GET    | 公告列表     | 管理员 |
| `/api/v1/admin/system/announcement/create`      | POST   | 创建公告     | 管理员 |
| `/api/v1/admin/system/announcement/update/{id}` | PUT    | 更新公告     | 管理员 |
| `/api/v1/admin/system/announcement/delete/{id}` | DELETE | 删除公告     | 管理员 |
| `/api/v1/admin/system/logs/operation`           | GET    | 操作日志查询 | 管理员 |
| `/api/v1/admin/system/logs/login`               | GET    | 登录日志查询 | 管理员 |
| `/api/v1/admin/system/maintenance/cleanup`      | POST   | 数据清理     | 管理员 |
| `/api/v1/admin/system/maintenance/backup`       | POST   | 数据备份     | 管理员 |

#### **11. WebSocket接口 (ws://)**

| 接口路径                 | 描述             | 参数   |
| :----------------------- | :--------------- | :----- |
| `/ws/seat-status`        | 座位状态实时推送 | roomId |
| `/ws/notification`       | 系统通知推送     | userId |
| `/ws/online-count`       | 在线人数统计     | roomId |
| `/ws/reservation-update` | 预约状态更新     | userId |

#### **12. 外部对接接口 (api/v1/external)**

| 接口路径                                | 方法 | 描述           | 对接方       |
| :-------------------------------------- | :--- | :------------- | :----------- |
| `/api/v1/external/face/verify`          | POST | 人脸识别验证   | 人脸识别系统 |
| `/api/v1/external/card/verify`          | POST | 一卡通验证     | 一卡通系统   |
| `/api/v1/external/screen/room/{roomId}` | GET  | 门口屏数据接口 | 电子班牌     |
| `/api/v1/external/wechat/notify`        | POST | 微信通知推送   | 微信小程序   |
| `/api/v1/external/sms/send`             | POST | 短信发送接口   | 短信平台     |

### 🔧 **后端技术栈详细配置**

#### **pom.xml 核心依赖**

xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.5</version>
    </parent>
    
    <dependencies>
        <!-- Spring Boot 核心 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <!-- 数据库相关 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.4.1</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.2.18</version>
        </dependency>
        
        <!-- 缓存 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.redisson</groupId>
            <artifactId>redisson-spring-boot-starter</artifactId>
            <version>3.23.5</version>
        </dependency>
        
        <!-- 安全认证 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        
        <!-- WebSocket -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
        </dependency>
        
        <!-- 工具类 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>
        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
        </dependency>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>32.1.2-jre</version>
        </dependency>
        
        <!-- 文件处理 -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.3</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>easyexcel</artifactId>
            <version>3.3.2</version>
        </dependency>
        
        <!-- 接口文档 -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-openapi3-spring-boot-starter</artifactId>
            <version>4.3.0</version>
        </dependency>
        
        <!-- 其他 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-quartz</artifactId>
        </dependency>
    </dependencies>
</project>
```



#### **application.yml 配置模板**

yaml

```
server:
  port: 8080
  servlet:
    context-path: /api

spring:
  application:
    name: study-room-booking
  profiles:
    active: dev
  
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/study_room_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      validation-query: SELECT 1
  
  redis:
    host: localhost
    port: 6379
    password: 
    database: 0
    lettuce:
      pool:
        max-active: 8
        max-wait: -1ms
        max-idle: 8
        min-idle: 0
  
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  
  mail:
    host: smtp.qq.com
    port: 465
    username: your-email@qq.com
    password: your-password
    properties:
      mail:
        smtp:
          ssl:
            enable: true
          auth: true

mybatis-plus:
  mapper-locations: classpath*:/mapper/**/*.xml
  type-aliases-package: com.studyroom.modules.*.entity
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: deleted
      logic-delete-value: 1
      logic-not-delete-value: 0

study-room:
  jwt:
    secret: your-jwt-secret-key-here
    expiration: 7200000  # 2小时
    refresh-expiration: 2592000000  # 30天
  
  redis:
    seat-status-key: seat:status:
    seat-status-ttl: 300  # 5分钟
    user-token-key: user:token:
    user-token-ttl: 7200  # 2小时
    reservation-lock-key: reservation:lock:
    reservation-lock-ttl: 10  # 10秒
  
  rule:
    reservation:
      max-duration: 240  # 最大预约时长（分钟）
      min-duration: 30   # 最小预约时长（分钟）
      advance-reservation: 60  # 可提前预约时间（分钟）
      cancel-deadline: 30  # 取消截止时间（签到前多少分钟）
    
    violation:
      no-show-deduction: 10  # 爽约扣分
      late-checkin-deduction: 5  # 迟到扣分
      early-checkout-deduction: 3  # 提前离开扣分
    
    credit:
      initial-score: 100  # 初始信用分
      max-score: 200  # 最高信用分
      min-score: 0  # 最低信用分

knife4j:
  enable: true
  setting:
    language: zh-CN
```



### 🚀 **后端开发执行方案**

#### **第一阶段：基础框架搭建（第1-3天）**

1. 创建Spring Boot项目，配置基础依赖
2. 配置数据库连接、MyBatis-Plus
3. 配置Redis缓存
4. 实现统一返回结果封装
5. 实现全局异常处理
6. 配置JWT认证框架

#### **第二阶段：用户认证模块（第4-6天）**

1. 实现用户表结构设计
2. 完成登录、注册接口
3. 实现JWT token生成和验证
4. 完成权限校验拦截器
5. 实现实名认证功能

#### **第三阶段：自习室核心模块（第7-10天）**

1. 自习室和座位表结构设计
2. 实现自习室CRUD接口
3. 实现座位状态管理
4. 集成WebSocket实现实时状态推送
5. 实现座位布局编辑功能

#### **第四阶段：预约业务模块（第11-14天）**

1. 预约表结构设计
2. 实现预约创建、取消逻辑
3. 实现预约冲突检测
4. 完成签到、签退功能
5. 实现暂离/返回逻辑

#### **第五阶段：管理端功能（第15-18天）**

1. 实现用户管理接口
2. 完成数据统计功能
3. 实现系统配置管理
4. 完成公告管理功能
5. 实现违规记录管理

#### **第六阶段：高级功能集成（第19-21天）**

1. 集成定时任务（预约超时、数据统计）
2. 实现数据导出功能
3. 集成外部接口（人脸识别、一卡通）
4. 实现消息推送功能

#### **第七阶段：测试与优化（第22-25天）**

1. 编写单元测试
2. 进行接口性能测试
3. 优化SQL查询和索引
4. 配置生产环境
5. 编写部署文档











# 📁 后端完整文件目录结构

基于前面的设计，这里是你后端项目的完整文件目录结构。我将按照开发阶段逐步完善每个文件。

text

```
study-room-booking-backend/
├── 📁 src/main/java/com/studyroom/
│   ├── 📄 StudyRoomApplication.java                 # Spring Boot启动类
│   ├── 📁 config/                                   # 配置类目录
│   │   ├── 📄 CorsConfig.java                       # 跨域配置
│   │   ├── 📄 RedisConfig.java                      # Redis配置
│   │   ├── 📄 MyBatisPlusConfig.java                # MyBatisPlus配置
│   │   ├── 📄 Knife4jConfig.java                    # 接口文档配置
│   │   ├── 📄 WebSecurityConfig.java                # Spring Security配置
│   │   ├── 📄 WebSocketConfig.java                  # WebSocket配置
│   │   ├── 📄 ScheduleConfig.java                   # 定时任务配置
│   │   ├── 📄 AsyncConfig.java                      # 异步处理配置
│   │   ├── 📄 JacksonConfig.java                    # JSON序列化配置
│   │   └── 📄 ThreadPoolConfig.java                 # 线程池配置
│   ├── 📁 common/                                   # 通用模块
│   │   ├── 📁 exception/                            # 异常处理
│   │   │   ├── 📄 GlobalExceptionHandler.java       # 全局异常处理器
│   │   │   ├── 📄 BusinessException.java            # 业务异常
│   │   │   ├── 📄 AuthenticationException.java      # 认证异常
│   │   │   └── 📄 ErrorCode.java                    # 错误码枚举
│   │   ├── 📁 result/                               # 统一返回
│   │   │   ├── 📄 Result.java                       # 统一响应封装
│   │   │   ├── 📄 ResultCode.java                   # 响应码枚举
│   │   │   ├── 📄 ApiResult.java                    # API响应工具
│   │   │   └── 📄 PageResult.java                   # 分页响应
│   │   ├── 📁 utils/                                # 工具类
│   │   │   ├── 📄 JwtUtils.java                     # JWT工具类
│   │   │   ├── 📄 Md5Utils.java                     # MD5加密工具
│   │   │   ├── 📄 DateUtils.java                    # 日期时间工具
│   │   │   ├── 📄 ExcelUtils.java                   # Excel导入导出工具
│   │   │   ├── 📄 ValidatorUtils.java               # 验证工具
│   │   │   ├── 📄 RedisUtils.java                   # Redis工具类
│   │   │   ├── 📄 WebSocketUtils.java               # WebSocket工具类
│   │   │   ├── 📄 QRCodeUtils.java                  # 二维码生成工具
│   │   │   ├── 📄 FileUtils.java                    # 文件处理工具
│   │   │   ├── 📄 IpUtils.java                      # IP工具类
│   │   │   └── 📄 IdGenerator.java                  # ID生成器
│   │   ├── 📁 constant/                             # 常量定义
│   │   │   ├── 📄 UserConstant.java                 # 用户常量
│   │   │   ├── 📄 RoomConstant.java                 # 自习室常量
│   │   │   ├── 📄 ReservationConstant.java          # 预约常量
│   │   │   ├── 📄 SeatConstant.java                 # 座位常量
│   │   │   ├── 📄 CheckInConstant.java              # 签到常量
│   │   │   ├── 📄 ViolationConstant.java            # 违规常量
│   │   │   ├── 📄 RedisKeyConstant.java             # Redis Key常量
│   │   │   ├── 📄 PermissionConstant.java           # 权限常量
│   │   │   └── 📄 SystemConstant.java               # 系统常量
│   │   ├── 📁 interceptor/                          # 拦截器
│   │   │   ├── 📄 AuthInterceptor.java              # 认证拦截器
│   │   │   ├── 📄 RateLimitInterceptor.java         # 限流拦截器
│   │   │   ├── 📄 LogInterceptor.java               # 日志拦截器
│   │   │   └── 📄 TenantInterceptor.java            # 租户拦截器
│   │   ├── 📁 aspect/                               # 切面
│   │   │   ├── 📄 LogAspect.java                    # 日志切面
│   │   │   ├── 📄 PermissionAspect.java             # 权限切面
│   │   │   └── 📄 RateLimitAspect.java              # 限流切面
│   │   └── 📁 enums/                                # 枚举类
│   │       ├── 📄 UserStatusEnum.java               # 用户状态枚举
│   │       ├── 📄 UserRoleEnum.java                 # 用户角色枚举
│   │       ├── 📄 RoomStatusEnum.java               # 自习室状态枚举
│   │       ├── 📄 SeatStatusEnum.java               # 座位状态枚举
│   │       ├── 📄 ReservationStatusEnum.java        # 预约状态枚举
│   │       ├── 📄 CheckInMethodEnum.java            # 签到方式枚举
│   │       ├── 📄 ViolationTypeEnum.java            # 违规类型枚举
│   │       └── 📄 NotificationTypeEnum.java         # 通知类型枚举
│   ├── 📁 modules/                                  # 业务模块（核心）
│   │   ├── 📁 auth/                                 # 认证模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 AuthController.java           # 认证接口
│   │   │   │   ├── 📄 StudentAuthController.java    # 学生认证接口
│   │   │   │   └── 📄 AdminAuthController.java      # 管理员认证接口
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 AuthService.java              # 认证服务接口
│   │   │   │   ├── 📄 TokenService.java             # Token服务
│   │   │   │   ├── 📄 CaptchaService.java           # 验证码服务
│   │   │   │   └── 📄 impl/
│   │   │   │       ├── 📄 AuthServiceImpl.java      # 认证服务实现
│   │   │   │       └── 📄 TokenServiceImpl.java     # Token服务实现
│   │   │   ├── 📁 mapper/
│   │   │   │   └── 📄 UserMapper.java               # 用户Mapper
│   │   │   ├── 📁 entity/
│   │   │   │   └── 📄 User.java                     # 用户实体
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 LoginRequest.java         # 登录请求DTO
│   │   │   │   │   ├── 📄 RegisterRequest.java      # 注册请求DTO
│   │   │   │   │   ├── 📄 ResetPasswordRequest.java # 重置密码请求
│   │   │   │   │   └── 📄 UpdateProfileRequest.java # 更新资料请求
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 LoginResponse.java        # 登录响应DTO
│   │   │   │       ├── 📄 UserInfoResponse.java     # 用户信息响应
│   │   │   │       └── 📄 TokenResponse.java        # Token响应
│   │   │   └── 📁 vo/
│   │   │       └── 📄 UserVO.java                   # 用户视图对象
│   │   ├── 📁 user/                                 # 用户模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 StudentUserController.java    # 学生端用户接口
│   │   │   │   └── 📄 AdminUserController.java      # 管理端用户接口
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 UserService.java              # 用户服务接口
│   │   │   │   ├── 📄 StudentService.java           # 学生服务
│   │   │   │   ├── 📄 AdminService.java             # 管理员服务
│   │   │   │   ├── 📄 CreditService.java            # 信用分服务
│   │   │   │   └── 📄 impl/
│   │   │   │       ├── 📄 UserServiceImpl.java
│   │   │   │       └── 📄 CreditServiceImpl.java
│   │   │   ├── 📁 mapper/
│   │   │   │   ├── 📄 UserMapper.java
│   │   │   │   ├── 📄 StudentMapper.java
│   │   │   │   └── 📄 AdminMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   ├── 📄 User.java
│   │   │   │   ├── 📄 Student.java
│   │   │   │   ├── 📄 Admin.java
│   │   │   │   └── 📄 Role.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 UserQueryRequest.java
│   │   │   │   │   ├── 📄 UserCreateRequest.java
│   │   │   │   │   ├── 📄 UserUpdateRequest.java
│   │   │   │   │   ├── 📄 BatchImportRequest.java
│   │   │   │   │   └── 📄 CreditAdjustRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 UserDetailResponse.java
│   │   │   │       ├── 📄 UserListResponse.java
│   │   │   │       └── 📄 CreditRecordResponse.java
│   │   │   └── 📁 vo/
│   │   │       ├── 📄 UserVO.java
│   │   │       └── 📄 StudentVO.java
│   │   ├── 📁 room/                                 # 自习室模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 RoomController.java           # 自习室接口
│   │   │   │   ├── 📄 SeatController.java           # 座位接口
│   │   │   │   └── 📄 AdminRoomController.java      # 管理端自习室接口
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 RoomService.java
│   │   │   │   ├── 📄 SeatService.java
│   │   │   │   ├── 📄 RoomStatusService.java
│   │   │   │   └── 📄 impl/
│   │   │   ├── 📁 mapper/
│   │   │   │   ├── 📄 RoomMapper.java
│   │   │   │   └── 📄 SeatMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   ├── 📄 StudyRoom.java
│   │   │   │   ├── 📄 Seat.java
│   │   │   │   └── 📄 RoomOpenTime.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 RoomQueryRequest.java
│   │   │   │   │   ├── 📄 RoomCreateRequest.java
│   │   │   │   │   ├── 📄 SeatLayoutUpdateRequest.java
│   │   │   │   │   └── 📄 SeatImportRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 RoomDetailResponse.java
│   │   │   │       ├── 📄 RoomListResponse.java
│   │   │   │       └── 📄 SeatStatusResponse.java
│   │   │   └── 📁 vo/
│   │   │       ├── 📄 RoomVO.java
│   │   │       └── 📄 SeatVO.java
│   │   ├── 📁 reservation/                          # 预约模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 ReservationController.java    # 预约接口
│   │   │   │   └── 📄 StudentReservationController.java
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 ReservationService.java
│   │   │   │   ├── 📄 ReservationRuleService.java
│   │   │   │   ├── 📄 ReservationConflictService.java
│   │   │   │   └── 📄 impl/
│   │   │   ├── 📁 mapper/
│   │   │   │   ├── 📄 ReservationMapper.java
│   │   │   │   └── 📄 ReservationRuleMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   ├── 📄 Reservation.java
│   │   │   │   ├── 📄 ReservationRule.java
│   │   │   │   └── 📄 CheckInRecord.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 ReservationCreateRequest.java
│   │   │   │   │   ├── 📄 ReservationQueryRequest.java
│   │   │   │   │   ├── 📄 ReservationCancelRequest.java
│   │   │   │   │   └── 📄 ReservationCheckRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 ReservationDetailResponse.java
│   │   │   │       ├── 📄 ReservationListResponse.java
│   │   │   │       └── 📄 AvailabilityResponse.java
│   │   │   └── 📁 vo/
│   │   │       └── 📄 ReservationVO.java
│   │   ├── 📁 checkin/                              # 签到模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 CheckInController.java        # 签到接口
│   │   │   │   └── 📄 StudentCheckInController.java
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 CheckInService.java
│   │   │   │   ├── 📄 QRCodeService.java
│   │   │   │   ├── 📄 FaceRecognitionService.java
│   │   │   │   └── 📄 impl/
│   │   │   ├── 📁 mapper/
│   │   │   │   └── 📄 CheckInRecordMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   └── 📄 CheckInRecord.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 CheckInRequest.java
│   │   │   │   │   ├── 📄 CheckOutRequest.java
│   │   │   │   │   └── 📄 LeaveRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 CheckInResponse.java
│   │   │   │       └── 📄 QRCodeResponse.java
│   │   │   └── 📁 vo/
│   │   │       └── 📄 CheckInRecordVO.java
│   │   ├── 📁 statistics/                           # 统计模块
│   │   │   ├── 📁 controller/
│   │   │   │   └── 📄 StatisticsController.java
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 StatisticsService.java
│   │   │   │   ├── 📄 RoomStatisticsService.java
│   │   │   │   ├── 📄 UserStatisticsService.java
│   │   │   │   └── 📄 impl/
│   │   │   ├── 📁 mapper/
│   │   │   │   └── 📄 StatisticsMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   └── 📄 StatisticsSnapshot.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 StatisticsQueryRequest.java
│   │   │   │   │   └── 📄 ExportRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 SystemStatsResponse.java
│   │   │   │       ├── 📄 RoomUsageResponse.java
│   │   │   │       └── 📄 HeatmapResponse.java
│   │   │   └── 📁 vo/
│   │   │       └── 📄 StatisticsVO.java
│   │   ├── 📁 admin/                                # 管理模块
│   │   │   ├── 📁 controller/
│   │   │   │   ├── 📄 SystemController.java         # 系统设置
│   │   │   │   ├── 📄 AnnouncementController.java   # 公告管理
│   │   │   │   ├── 📄 RuleController.java          # 规则管理
│   │   │   │   └── 📄 LogController.java           # 日志管理
│   │   │   ├── 📁 service/
│   │   │   │   ├── 📄 SystemConfigService.java
│   │   │   │   ├── 📄 AnnouncementService.java
│   │   │   │   ├── 📄 LogService.java
│   │   │   │   └── 📄 impl/
│   │   │   ├── 📁 mapper/
│   │   │   │   ├── 📄 SystemConfigMapper.java
│   │   │   │   ├── 📄 AnnouncementMapper.java
│   │   │   │   └── 📄 OperationLogMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   ├── 📄 SystemConfig.java
│   │   │   │   ├── 📄 Announcement.java
│   │   │   │   └── 📄 OperationLog.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── 📄 SystemConfigUpdateRequest.java
│   │   │   │   │   ├── 📄 AnnouncementCreateRequest.java
│   │   │   │   │   └── 📄 RuleUpdateRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       ├── 📄 SystemConfigResponse.java
│   │   │   │       └── 📄 AnnouncementResponse.java
│   │   │   └── 📁 vo/
│   │   │       ├── 📄 SystemConfigVO.java
│   │   │       └── 📄 AnnouncementVO.java
│   │   ├── 📁 violation/                            # 违规模块
│   │   │   ├── 📁 controller/
│   │   │   │   └── 📄 ViolationController.java
│   │   │   ├── 📁 service/
│   │   │   │   └── 📄 ViolationService.java
│   │   │   ├── 📁 mapper/
│   │   │   │   └── 📄 ViolationRecordMapper.java
│   │   │   ├── 📁 entity/
│   │   │   │   └── 📄 ViolationRecord.java
│   │   │   ├── 📁 dto/
│   │   │   │   ├── 📁 request/
│   │   │   │   │   └── 📄 ViolationHandleRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       └── 📄 ViolationRecordResponse.java
│   │   │   └── 📁 vo/
│   │   │       └── 📄 ViolationRecordVO.java
│   │   └── 📁 notification/                         # 通知模块
│   │       ├── 📁 controller/
│   │       │   └── 📄 NotificationController.java
│   │       ├── 📁 service/
│   │       │   └── 📄 NotificationService.java
│   │       ├── 📁 mapper/
│   │       │   └── 📄 NotificationMapper.java
│   │       ├── 📁 entity/
│   │       │   └── 📄 Notification.java
│   │       ├── 📁 dto/
│   │       │   ├── 📁 request/
│   │       │   │   └── 📄 NotificationSendRequest.java
│   │       │   └── 📁 response/
│   │       │       └── 📄 NotificationResponse.java
│   │       └── 📁 vo/
│   │           └── 📄 NotificationVO.java
│   ├── 📁 task/                                     # 定时任务
│   │   ├── 📄 ReservationTask.java                  # 预约超时任务
│   │   ├── 📄 StatisticsTask.java                   # 统计任务
│   │   ├── 📄 CleanupTask.java                      # 清理任务
│   │   ├── 📄 CacheRefreshTask.java                 # 缓存刷新任务
│   │   └── 📄 NotificationTask.java                 # 通知任务
│   └── 📁 websocket/                                # WebSocket模块
│       ├── 📄 WebSocketServer.java                  # WebSocket服务器
│       ├── 📁 handler/
│       │   ├── 📄 SeatStatusHandler.java            # 座位状态处理器
│       │   ├── 📄 NotificationHandler.java          # 通知处理器
│       │   └── 📄 OnlineCountHandler.java           # 在线人数处理器
│       ├── 📁 entity/
│       │   ├── 📄 WebSocketMessage.java             # WebSocket消息
│       │   ├── 📄 SeatStatusUpdate.java             # 座位状态更新
│       │   └── 📄 NotificationMessage.java          # 通知消息
│       └── 📁 service/
│           ├── 📄 WebSocketService.java             # WebSocket服务
│           └── 📄 impl/
├── 📁 src/main/resources/
│   ├── 📄 application.yml                           # 主配置文件
│   ├── 📄 application-dev.yml                       # 开发环境配置
│   ├── 📄 application-prod.yml                      # 生产环境配置
│   ├── 📄 application-test.yml                      # 测试环境配置
│   ├── 📄 logback-spring.xml                        # 日志配置
│   ├── 📁 mapper/                                   # MyBatis XML映射文件
│   │   ├── 📁 auth/
│   │   │   └── 📄 UserMapper.xml
│   │   ├── 📁 user/
│   │   │   ├── 📄 UserMapper.xml
│   │   │   └── 📄 CreditRecordMapper.xml
│   │   ├── 📁 room/
│   │   │   ├── 📄 RoomMapper.xml
│   │   │   └── 📄 SeatMapper.xml
│   │   ├── 📁 reservation/
│   │   │   ├── 📄 ReservationMapper.xml
│   │   │   └── 📄 ReservationRuleMapper.xml
│   │   ├── 📁 checkin/
│   │   │   └── 📄 CheckInRecordMapper.xml
│   │   ├── 📁 statistics/
│   │   │   └── 📄 StatisticsMapper.xml
│   │   ├── 📁 admin/
│   │   │   ├── 📄 SystemConfigMapper.xml
│   │   │   └── 📄 AnnouncementMapper.xml
│   │   ├── 📁 violation/
│   │   │   └── 📄 ViolationRecordMapper.xml
│   │   └── 📁 notification/
│   │       └── 📄 NotificationMapper.xml
│   ├── 📁 static/                                   # 静态资源
│   │   ├── 📁 qrcode/                               # 二维码存放目录
│   │   ├── 📁 uploads/                              # 上传文件目录
│   │   │   ├── 📁 avatars/                          # 头像
│   │   │   ├── 📁 rooms/                            # 自习室图片
│   │   │   └── 📁 faces/                            # 人脸照片
│   │   └── 📁 templates/                            # 模板文件
│   │       ├── 📁 email/                            # 邮件模板
│   │       │   ├── 📄 notification.html
│   │       │   └── 📄 reset-password.html
│   │       └── 📁 excel/                            # Excel模板
│   │           ├── 📄 user-import-template.xlsx
│   │           └── 📄 seat-import-template.xlsx
│   └── 📁 i18n/                                     # 国际化文件
│       ├── 📄 messages.properties
│       ├── 📄 messages_zh_CN.properties
│       └── 📄 messages_en_US.properties
├── 📁 src/test/java/com/studyroom/                  # 测试代码
│   ├── 📄 StudyRoomApplicationTests.java           # 应用测试
│   ├── 📁 auth/
│   ├── 📁 user/
│   ├── 📁 room/
│   ├── 📁 reservation/
│   ├── 📁 checkin/
│   ├── 📁 statistics/
│   └── 📁 admin/
├── 📁 src/test/resources/                          # 测试资源
│   ├── 📄 application-test.yml
│   └── 📁 test-data/
│       ├── 📄 test-users.sql
│       ├── 📄 test-rooms.sql
│       └── 📄 test-reservations.sql
├── 📁 sql/                                         # SQL脚本目录
│   ├── 📄 init.sql                                 # 初始化脚本（建表）
│   ├── 📄 test_data.sql                            # 测试数据
│   ├── 📄 indexes.sql                              # 索引优化脚本
│   ├── 📄 triggers.sql                             # 触发器脚本
│   ├── 📄 functions.sql                            # 存储过程/函数
│   └── 📁 update/                                  # 版本更新脚本
│       ├── 📄 v1.0.1.sql
│       ├── 📄 v1.0.2.sql
│       └── 📄 v1.1.0.sql
├── 📁 docs/                                        # 项目文档
│   ├── 📁 api/                                     # API文档
│   │   ├── 📄 student-api.md                      # 学生端API文档
│   │   ├── 📄 admin-api.md                        # 管理端API文档
│   │   └── 📄 external-api.md                     # 外部API文档
│   ├── 📁 database/                                # 数据库设计文档
│   │   ├── 📄 er-diagram.png                      # ER图
│   │   ├── 📄 table-structure.md                  # 表结构说明
│   │   └── 📄 index-optimization.md               # 索引优化说明
│   ├── 📁 deploy/                                  # 部署文档
│   │   ├── 📄 docker-compose.yml                  # Docker Compose配置
│   │   ├── 📄 Dockerfile                          # Docker镜像配置
│   │   ├── 📄 nginx.conf                          # Nginx配置
│   │   ├── 📄 jenkinsfile                         # Jenkins流水线
│   │   └── 📄 deploy-guide.md                     # 部署指南
│   ├── 📁 design/                                  # 设计文档
│   │   ├── 📄 architecture.md                     # 架构设计
│   │   ├── 📄 data-flow.md                        # 数据流设计
│   │   └── 📄 api-design.md                       # API设计规范
│   └── 📁 guide/                                   # 使用指南
│       ├── 📄 user-guide.md                       # 用户使用手册
│       ├── 📄 admin-guide.md                      # 管理员操作指南
│       └── 📄 developer-guide.md                  # 开发者指南
├── 📄 pom.xml                                      # Maven配置文件
├── 📄 Dockerfile                                   # Docker镜像配置
├── 📄 docker-compose.yml                           # Docker Compose配置
├── 📄 .gitignore                                   # Git忽略配置
├── 📄 README.md                                    # 项目说明
├── 📄 CHANGELOG.md                                 # 变更日志
└── 📄 .env.example                                 # 环境变量示例
```



# 🗓️ 分阶段开发计划

## 📋 阶段划分（共8周）

### **第1阶段：基础框架搭建（第1周）**

**目标：** 创建项目基础结构，配置核心依赖，实现基础功能

**任务清单：**

1. ✅ 创建Spring Boot项目结构
2. ✅ 配置pom.xml依赖
3. ✅ 配置application.yml多环境
4. ✅ 创建数据库并执行init.sql
5. ✅ 配置MyBatis-Plus和代码生成器
6. ✅ 实现统一响应封装Result
7. ✅ 实现全局异常处理
8. ✅ 配置JWT认证框架
9. ✅ 创建用户表实体类和Mapper

**交付物：**

- 可启动的Spring Boot项目
- 基础数据库表结构
- 统一异常处理和响应格式
- JWT认证基础框架

------

### **第2阶段：认证与用户模块（第2周）**

**目标：** 完成用户认证、注册、权限管理等核心功能

**任务清单：**

1. ✅ 实现用户注册接口
2. ✅ 实现用户登录接口（JWT生成）
3. ✅ 实现Token刷新接口
4. ✅ 实现用户信息获取和修改
5. ✅ 实现密码修改和重置
6. ✅ 实现实名认证接口
7. ✅ 实现用户列表查询（分页）
8. ✅ 实现用户搜索功能
9. ✅ 配置Spring Security权限控制
10. ✅ 实现拦截器和权限注解

**对应前端API：**

- `auth.ts` 所有接口
- `user.ts` 基础接口

------

### **第3阶段：自习室模块（第3周）**

**目标：** 完成自习室管理、座位布局、实时状态功能

**任务清单：**

1. ✅ 实现自习室CRUD接口
2. ✅ 实现自习室列表查询（分页+筛选）
3. ✅ 实现自习室详情获取
4. ✅ 实现座位CRUD接口
5. ✅ 实现座位布局管理
6. ✅ 实现座位状态实时查询
7. ✅ 实现座位导入导出功能
8. ✅ 实现自习室搜索功能
9. ✅ 配置Redis缓存座位状态
10. ✅ 实现WebSocket实时推送

**对应前端API：**

- `room.ts` 所有接口
- WebSocket实时通信

------

### **第4阶段：预约模块（第4周）**

**目标：** 完成预约创建、取消、冲突检测等核心业务

**任务清单：**

1. ✅ 实现预约创建接口（含冲突检测）
2. ✅ 实现预约取消接口
3. ✅ 实现预约列表查询（分页+筛选）
4. ✅ 实现预约详情获取
5. ✅ 实现我的预约查询
6. ✅ 实现即将开始的预约查询
7. ✅ 实现预约冲突检测接口
8. ✅ 实现座位可用时间段查询
9. ✅ 实现预约规则配置
10. ✅ 实现预约状态流转

**对应前端API：**

- `reservation.ts` 所有接口

------

### **第5阶段：签到与违规模块（第5周）**

**目标：** 完成签到、签退、暂离、违规处理功能

**任务清单：**

1. ✅ 实现二维码签到接口
2. ✅ 实现人脸识别签到接口
3. ✅ 实现签退接口
4. ✅ 实现暂离/返回接口
5. ✅ 实现签到记录查询
6. ✅ 实现违规检测逻辑
7. ✅ 实现违规记录管理
8. ✅ 实现信用分扣减逻辑
9. ✅ 实现信用分记录查询
10. ✅ 实现违规申诉处理

**对应前端API：**

- `checkIn.api.ts` 所有接口
- 违规处理相关接口

------

### **第6阶段：管理员模块（第6周）**

**目标：** 完成管理员后台管理功能

**任务清单：**

1. ✅ 实现管理员登录和权限
2. ✅ 实现用户管理（增删改查）
3. ✅ 实现公告管理
4. ✅ 实现系统设置管理
5. ✅ 实现预约规则配置
6. ✅ 实现数据清理功能
7. ✅ 实现数据备份功能
8. ✅ 实现系统日志查询
9. ✅ 实现批量导入用户
10. ✅ 实现数据导出功能

**对应前端API：**

- `admin.ts` 所有接口

------

### **第7阶段：统计与高级功能（第7周）**

**目标：** 完成数据统计、可视化、高级功能

**任务清单：**

1. ✅ 实现系统统计接口
2. ✅ 实现自习室使用率统计
3. ✅ 实现座位热度图统计
4. ✅ 实现用户活跃度统计
5. ✅ 实现时间段使用统计
6. ✅ 实现学院分布统计
7. ✅ 实现违规统计
8. ✅ 实现数据导出（Excel）
9. ✅ 集成定时任务
10. ✅ 优化缓存策略

**对应前端API：**

- `statistics.ts` 所有接口

------

### **第8阶段：测试与部署（第8周）**

**目标：** 完成测试、优化和部署

**任务清单：**

1. ✅ 编写单元测试
2. ✅ 编写集成测试
3. ✅ 进行性能测试
4. ✅ 进行安全测试
5. ✅ 配置生产环境
6. ✅ 配置Docker容器化
7. ✅ 配置Nginx反向代理
8. ✅ 配置CI/CD流水线
9. ✅ 编写部署文档
10. ✅ 编写用户手册
