package com.sinotopia.common.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinotopia.common.model.IdentityRole;

public interface IdentityRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IdentityRole record);

    int insertSelective(IdentityRole record);

    IdentityRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityRole record);

    int updateByPrimaryKey(IdentityRole record);

    Set<String> findRoleByUserId(Long id);

    List<IdentityRole> findNowAllPermission(Map<String, Object> map);

    void initData();
}