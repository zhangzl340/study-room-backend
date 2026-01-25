package com.studyroom.modules.user.service;

import com.studyroom.modules.user.dto.request.*;
import com.studyroom.modules.user.entity.Admin;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.vo.UserVO;

import java.util.List;

public interface AdminService {

    /**
     * 创建管理员账户
     */
    User createAdmin(UserCreateRequest request);

    /**
     * 更新管理员信息
     */
    User updateAdmin(Long id, UserUpdateRequest request);

    /**
     * 删除管理员账户
     */
    boolean deleteAdmin(Long id);

    /**
     * 获取管理员详情
     */
    UserVO getAdminDetail(Long id);

    /**
     * 获取管理员列表
     */
    List<UserVO> getAdminList(UserQueryRequest request);

    /**
     * 批量导入管理员
     */
    boolean batchImportAdmins(BatchImportRequest request);

    /**
     * 更新管理员状态
     */
    boolean updateAdminStatus(Long id, Integer status);

    /**
     * 重置管理员密码
     */
    boolean resetAdminPassword(Long id, String newPassword);
}
