package com.xy.dao;

import com.xy.entity.Qdsjtj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: xy
 * @Date: 2018/10/6 13:51
 * @Description:
 */
public interface QdtjRepository extends JpaRepository<Qdsjtj,Integer>{
    List<Qdsjtj> findQdsjtjByQd(String qd);

    @Query(value = "select * from qdsjtj where id = ?",nativeQuery = true)
    Qdsjtj findQdsjtjById(int id);

    List<Qdsjtj> findQdsjtjBySq(String sq);
}
