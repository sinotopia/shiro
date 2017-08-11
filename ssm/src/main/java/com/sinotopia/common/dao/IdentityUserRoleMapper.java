package com.sinotopia.common.dao;

import java.util.List;
import java.util.Map;

import com.sinotopia.common.model.IdentityUserRole;

public interface IdentityUserRoleMapper {
    int insert(IdentityUserRole record);

    int insertSelective(IdentityUserRole record);

	int deleteByUserId(Long id);

	int deleteRoleByUserIds(Map<String, Object> resultMap);

	List<Long> findUserIdByRoleId(Long id);
}