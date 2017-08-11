package com.sinotopia.common.dao;

import java.util.List;
import java.util.Set;

import com.sinotopia.common.model.IdentityPermission;
import com.sinotopia.dto.permission.UPermissionBo;

public interface IdentityPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IdentityPermission record);

    int insertSelective(IdentityPermission record);

    IdentityPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityPermission record);

    int updateByPrimaryKey(IdentityPermission record);

    List<UPermissionBo> selectPermissionById(Long id);

    //根据用户ID获取权限的Set集合
    Set<String> findPermissionByUserId(Long id);
}