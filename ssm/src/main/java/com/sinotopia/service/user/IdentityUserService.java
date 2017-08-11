package com.sinotopia.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.sinotopia.common.model.IdentityUser;
import com.sinotopia.core.mybatis.page.Pagination;
import com.sinotopia.dto.permission.URoleBo;
import com.sinotopia.dto.permission.UserRoleAllocationBo;

public interface IdentityUserService {

    int deleteByPrimaryKey(Long id);

    IdentityUser insert(IdentityUser record);

    IdentityUser insertSelective(IdentityUser record);

    IdentityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityUser record);

    int updateByPrimaryKey(IdentityUser record);

    IdentityUser login(String email, String pswd);

    IdentityUser findUserByEmail(String email);

    Pagination<IdentityUser> findByPage(Map<String, Object> resultMap, Integer pageNo,
                                        Integer pageSize);

    Map<String, Object> deleteUserById(String ids);

    Map<String, Object> updateForbidUserById(Long id, Long status);

    Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
                                                     Integer pageNo, Integer pageSize);

    List<URoleBo> selectRoleByUserId(Long id);

    Map<String, Object> addRole2User(Long userId, String ids);

    Map<String, Object> deleteRoleByUserIds(String userIds);
}
