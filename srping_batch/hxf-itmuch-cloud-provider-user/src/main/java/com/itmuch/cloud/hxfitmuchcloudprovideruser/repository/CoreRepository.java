package com.itmuch.cloud.hxfitmuchcloudprovideruser.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * Created by Administrator on 2018/6/26.
 */
@NoRepositoryBean
public interface CoreRepository<E> extends JpaRepository<E,Long> {

}
