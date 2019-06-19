package com.xiongzehua.freetalk.repository;

import com.xiongzehua.freetalk.entity.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Integer> {

    Talk findByContent(String content);

    Talk findByOne(Integer id);

    @Query("from Talk t where t.content=:content")
    Talk findTalk(@Param("content") String content);
}
