package com.sinotopia.controller.permission;

import java.util.List;
import java.util.Map;

import com.sinotopia.service.permission.IdentityPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinotopia.common.controller.BaseController;
import com.sinotopia.core.mybatis.page.Pagination;
import com.sinotopia.dto.permission.RolePermissionAllocationBo;
import com.sinotopia.dto.permission.UPermissionBo;
import com.sinotopia.service.permission.impl.PermissionService;
import com.sinotopia.service.role.IdentityRoleService;

/**
 * <p>
 * 用户权限分配
 * <p>
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("permission")
public class PermissionAllocationController extends BaseController {

    @Autowired
    private IdentityPermissionService identityPermissionService;

    @Autowired
    private IdentityRoleService roleService;

    /**
     * 权限分配
     *
     * @param modelMap
     * @param pageNo
     * @param findContent
     * @return
     */
    @RequestMapping(value = "allocation")
    public ModelAndView allocation(ModelMap modelMap, Integer pageNo, String findContent) {
        modelMap.put("findContent", findContent);
        Pagination<RolePermissionAllocationBo> boPage = roleService.findRoleAndPermissionPage(modelMap, pageNo, pageSize);
        modelMap.put("page", boPage);
        return new ModelAndView("permission/allocation");
    }

    /**
     * 根据角色ID查询权限
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "selectPermissionById")
    @ResponseBody
    public List<UPermissionBo> selectPermissionById(Long id) {
        List<UPermissionBo> permissionBos = identityPermissionService.selectPermissionById(id);
        return permissionBos;
    }

    /**
     * 操作角色的权限
     *
     * @param roleId 角色ID
     * @param ids    权限ID，以‘,’间隔
     * @return
     */
    @RequestMapping(value = "addPermission2Role")
    @ResponseBody
    public Map<String, Object> addPermission2Role(Long roleId, String ids) {
        return identityPermissionService.addPermission2Role(roleId, ids);
    }

    /**
     * 根据角色id清空权限。
     *
     * @param roleIds 角色ID ，以‘,’间隔
     * @return
     */
    @RequestMapping(value = "clearPermissionByRoleIds")
    @ResponseBody
    public Map<String, Object> clearPermissionByRoleIds(String roleIds) {
        return identityPermissionService.deleteByRids(roleIds);
    }
}
