package com.xiongzehua.freetalk.repository;

import com.xiongzehua.freetalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiongzehua on 2019/6/19.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "update User u set u.phone = :phone where u.id = :id")
    void updatePhone(Long id, String phone);
}
