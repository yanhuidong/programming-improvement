package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminDao extends Mapper<Admin> {

    @Select("select * from admin")
    List<Admin> getUser();

    List<Admin> findBySearch(@Param("params") Params params);

    @Select("select * from admin where name=#{name} limit 1")
    Admin findByName(@Param("name") String name);

    @Select("select * from admin where name=#{name} and password=#{password} limit 1")
    Admin findByNameAndPassowrd(@Param("name") String name,@Param("password") String password);


}
