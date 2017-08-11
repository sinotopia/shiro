package com.sinotopia.service.permission;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinotopia.common.model.IdentityPermission;
import com.sinotopia.core.mybatis.page.Pagination;
import com.sinotopia.dto.permission.UPermissionBo;

public interface IdentityPermissionService {

    int deleteByPrimaryKey(Long id);

    IdentityPermission insert(IdentityPermission record);

    IdentityPermission insertSelective(IdentityPermission record);

    IdentityPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityPermission record);

    int updateByPrimaryKey(IdentityPermission record);

    Map<String, Object> deletePermissionById(String ids);

    Pagination<IdentityPermission> findPage(Map<String, Object> resultMap, Integer pageNo,
                                            Integer pageSize);

    List<UPermissionBo> selectPermissionById(Long id);

    Map<String, Object> addPermission2Role(Long roleId, String ids);

    Map<String, Object> deleteByRids(String roleIds);

    //根据用户ID查询权限（permission），放入到Authorization里。
    Set<String> findPermissionByUserId(Long userId);
}
