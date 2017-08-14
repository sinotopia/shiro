package com.sinotopia.service.role.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinotopia.service.role.IdentityRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinotopia.common.dao.IdentityRoleMapper;
import com.sinotopia.common.dao.IdentityRolePermissionMapper;
import com.sinotopia.common.dao.IdentityUserMapper;
import com.sinotopia.common.model.IdentityRole;
import com.sinotopia.common.utils.LoggerUtils;
import com.sinotopia.core.mybatis.BaseMybatisDao;
import com.sinotopia.core.mybatis.page.Pagination;
import com.sinotopia.core.shiro.token.manager.TokenManager;
import com.sinotopia.dto.permission.RolePermissionAllocationBo;

@Service
@SuppressWarnings("unchecked")
public class IdentityRoleServiceImpl extends BaseMybatisDao<IdentityRoleMapper> implements IdentityRoleService {

    @Autowired
    private IdentityRoleMapper roleMapper;

    @Autowired
    private IdentityUserMapper userMapper;

    @Autowired
    private IdentityRolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IdentityRole record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(IdentityRole record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public IdentityRole selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(IdentityRole record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(IdentityRole record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pagination<IdentityRole> findPage(Map<String, Object> resultMap,
                                             Integer pageNo, Integer pageSize) {
        return super.findPage(resultMap, pageNo, pageSize);
    }

    @Override
    public Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
            Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
        return super.findPage("findRoleAndPermission", "findCount", resultMap, pageNo, pageSize);
    }

    @Override
    public Map<String, Object> deleteRoleById(String ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            int count = 0;
            String resultMsg = "删除成功。";
            String[] idArray = new String[]{};
            if (StringUtils.contains(ids, ",")) {
                idArray = ids.split(",");
            } else {
                idArray = new String[]{ids};
            }
            c:
            for (String idx : idArray) {
                Long id = new Long(idx);
                if (new Long(1).equals(id)) {
                    resultMsg = "操作成功，But'系统管理员不能删除。";
                    continue c;
                } else {
                    count += this.deleteByPrimaryKey(id);
                }
            }
            resultMap.put("status", 200);
            resultMap.put("count", count);
            resultMap.put("resultMsg", resultMsg);
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
            resultMap.put("status", 500);
            resultMap.put("message", "删除出现错误，请刷新后再试！");
        }
        return resultMap;
    }

    @Override
    public Set<String> findRoleByUserId(Long userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<IdentityRole> findNowAllPermission() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", TokenManager.getUserId());
        return roleMapper.findNowAllPermission(map);
    }

    /**
     * 每20分钟执行一次
     */
    @Override
    public void initData() {
        roleMapper.initData();
    }

}
