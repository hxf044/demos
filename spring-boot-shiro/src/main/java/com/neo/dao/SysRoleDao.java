package com.neo.dao;

import com.neo.entity.SysRole;
import com.neo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2018/3/15.
 */

public interface SysRoleDao extends CrudRepository<SysRole,Long> {

}
