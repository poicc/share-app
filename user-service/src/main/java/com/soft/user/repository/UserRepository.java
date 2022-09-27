package com.soft.user.repository;


import com.soft.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenrongqi
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 根据用户名密码查询
     * @param mobile mobile
     * @param password password
     * @return user
     */
    User findByMobileAndPassword(String mobile,String password);
}
