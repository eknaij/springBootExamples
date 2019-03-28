package com.eknaij.springbootmybatis.mapper;

import java.util.List;
import com.eknaij.springbootmybatis.pojo.Category;
import org.apache.ibatis.annotations.*;


@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();
    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category);

}
