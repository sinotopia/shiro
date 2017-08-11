package com.sinotopia.common.dao;

import java.util.List;
import java.util.Map;

import com.sinotopia.common.model.IdentityUser;
import com.sinotopia.dto.permission.URoleBo;

public interface IdentityUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IdentityUser record);

    int insertSelective(IdentityUser record);

    IdentityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityUser record);

    int updateByPrimaryKey(IdentityUser record);

    IdentityUser login(Map<String, Object> map);

    IdentityUser findUserByEmail(String email);

    List<URoleBo> selectRoleByUserId(Long id);

}