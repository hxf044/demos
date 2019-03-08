package com.neo.sevice.impl;

import com.neo.dao.SysRoleDao;
import com.neo.dao.UserInfoDao;
import com.neo.entity.SysPermission;
import com.neo.entity.SysRole;
import com.neo.entity.UserInfo;
import com.neo.sevice.SysPermissionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2018/3/15.
 */
@Service
public class SysPermissionServerImpl implements SysPermissionServer {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public List<Object> getPermissionTree(Integer uid) {
        Set<SysPermission> setPermissions = null;
        List<Object> newList = new  ArrayList();
        UserInfo userInfo = userInfoDao.findOne(uid);
        System.out.printf(userInfo.toString());
        List<SysRole> Listroles =  userInfo.getRoleList();
        if(Listroles.size() == 0){
            System.out.printf("没有角色配置");
            return newList;
        }
        Set<SysRole> roles  = new HashSet<>();
        roles.addAll(Listroles);
        System.out.printf("共有角色"+roles.size()+"个");
        setPermissions  = new HashSet<>();
        for(SysRole role:roles){
            for (SysPermission permission:role.getPermissions()){
                setPermissions.add(permission);
            }
        }
        newList = treeMenuList(setPermissions,0);
        System.out.printf("执行结果"+ newList.toString());
        return newList;
    }
    public List<Object> treeMenuList(Set<SysPermission> menuList, int parentId) {
        List<Object> childMenu = new ArrayList<>();
        for (SysPermission sysPermission : menuList) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if (sysPermission.getParentId() == parentId) {
                mapArr.put("id",sysPermission.getId());
                mapArr.put("pid",sysPermission.getParentId());
                mapArr.put("permission",sysPermission.getPermission());
                mapArr.put("url",sysPermission.getUrl());
                mapArr.put("parentIds",sysPermission.getParentIds());
                mapArr.put("childNode", treeMenuList(menuList, sysPermission.getId()));
                childMenu.add(mapArr);
            }
        }
        return childMenu;
    }
}
