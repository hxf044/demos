package com.neo.sevice;

import com.neo.entity.SysPermission;
import com.neo.entity.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 */
public interface SysPermissionServer {
    /**
     * 根据用户ID获取菜单树形结构
     * @param uid
     * @return
     */
    public List<Object> getPermissionTree(Integer uid);
}
