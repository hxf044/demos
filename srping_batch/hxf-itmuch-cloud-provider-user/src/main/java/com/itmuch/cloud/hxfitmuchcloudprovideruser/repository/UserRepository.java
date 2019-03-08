package com.itmuch.cloud.hxfitmuchcloudprovideruser.repository;

import com.itmuch.cloud.hxfitmuchcloudprovideruser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/6/26.
 */
@Repository
public interface UserRepository extends CoreRepository<User> {

}
