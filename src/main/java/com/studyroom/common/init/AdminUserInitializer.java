package com.studyroom.common.init;

import com.studyroom.common.utils.Md5Utils;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AdminUserInitializer {

    private final UserService userService;

    @Bean
    public ApplicationRunner initAdminUser() {
        return args -> {
            // 检查是否存在管理员账号
            User existingAdmin = userService.getUserByUsername("admin");
            if (existingAdmin == null) {
                log.info("开始创建默认管理员账号...");
                
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(Md5Utils.MD5Encode("admin123"));
                adminUser.setRealName("系统管理员");
                adminUser.setEmail("admin@example.com");
                adminUser.setPhone("13800138001");
                adminUser.setRoleType("ADMIN");
                adminUser.setStatus(1);
                adminUser.setIdentityStatus(1);
                adminUser.setCreditScore(100);
                adminUser.setTotalReservations(0);
                adminUser.setCompletedReservations(0);
                adminUser.setViolationCount(0);
                adminUser.setCreateTime(LocalDateTime.now());
                adminUser.setUpdateTime(LocalDateTime.now());
                
                userService.save(adminUser);
                
                log.info("默认管理员账号创建成功！");
                log.info("账号: admin");
                log.info("密码: admin123");
                log.info("请登录后及时修改密码！");
            } else {
                // 检查现有管理员账号的角色是否正确
                if (!"ADMIN".equals(existingAdmin.getRoleType())) {
                    log.info("修复管理员账号角色...");
                    existingAdmin.setRoleType("ADMIN");
                    existingAdmin.setUpdateTime(LocalDateTime.now());
                    userService.updateById(existingAdmin);
                    log.info("管理员账号角色修复成功！");
                } else {
                    log.info("管理员账号已存在且角色正确，跳过初始化");
                }
            }
        };
    }
}
