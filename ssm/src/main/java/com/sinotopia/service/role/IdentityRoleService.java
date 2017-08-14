package com.sinotopia.service.role;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinotopia.common.model.IdentityRole;
import com.sinotopia.core.mybatis.page.Pagination;
import com.sinotopia.dto.permission.RolePermissionAllocationBo;

public interface IdentityRoleService {

    int deleteByPrimaryKey(Long id);

    int insert(IdentityRole record);

    int insertSelective(IdentityRole record);

    IdentityRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdentityRole record);

    int updateByPrimaryKey(IdentityRole record);

    Pagination<IdentityRole> findPage(Map<String, Object> resultMap, Integer pageNo,
                                      Integer pageSize);

    Map<String, Object> deleteRoleById(String ids);

    Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
            Map<String, Object> resultMap, Integer pageNo, Integer pageSize);

    //根据用户ID查询角色（role），放入到Authorization里。
    Set<String> findRoleByUserId(Long userId);

    List<IdentityRole> findNowAllPermission();

    //初始化数据
    void initData();
}
