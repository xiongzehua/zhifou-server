package com.xiongzehua.freetalk.repository;

import com.xiongzehua.freetalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiongzehua
 * @date 2019-06-17 15:10
 */
public interface TalkRepository extends JpaRepository<User, Long> {
}
