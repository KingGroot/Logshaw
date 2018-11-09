package com.xy.dao;

import com.xy.entity.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataRepository extends JpaRepository<Data,Integer> {

    //根据id查询
    Data findDataById(int id);

    //根据num字段模糊查找数据
    @Query(value = "select s from Data s where s.num like %?1%")
    Page<Data> findDataByNum(String num, Pageable pageable);

    //根据类型模糊查询（相当于根据num模糊查询）
    @Query(value = "select s from Data s where s.type = ?1")
    Page<Data> findDataByType(String type,Pageable pageable);

    @Query(value = "select * from datas order by id DESC",nativeQuery = true)
    Page<Data> findAll(Pageable pageable);

    @Query(value = "select count(*) from datas",nativeQuery = true)
    long count();
}
