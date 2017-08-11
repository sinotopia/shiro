package com.sinotopia.common.dao;

import java.util.List;
import java.util.Map;

import com.sinotopia.common.model.IdentityRolePermission;

public interface IdentityRolePermissionMapper {

    int insert(IdentityRolePermission record);

    int insertSelective(IdentityRolePermission record);

    List<IdentityRolePermission> findRolePermissionByPid(Long id);

    List<IdentityRolePermission> findRolePermissionByRid(Long id);

    List<IdentityRolePermission> find(IdentityRolePermission entity);

    int deleteByPid(Long id);

    int deleteByRid(Long id);

    int delete(IdentityRolePermission entity);

    int deleteByRids(Map<String, Object> resultMap);
}