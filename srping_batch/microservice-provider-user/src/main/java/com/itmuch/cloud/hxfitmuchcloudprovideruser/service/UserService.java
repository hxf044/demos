package com.itmuch.cloud.hxfitmuchcloudprovideruser.service;

import com.itmuch.cloud.hxfitmuchcloudprovideruser.domain.User;
import com.itmuch.cloud.hxfitmuchcloudprovideruser.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/6/26.
 */
@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    public User findByOne(Long id){
        log.info("id"+id);
        if(id == null){
            return null;
        }
        return  userRepository.findOne(id);
    }

}
