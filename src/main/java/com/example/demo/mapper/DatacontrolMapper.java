package com.example.demo.mapper;

import com.example.demo.model.Datacontrol;
import com.example.demo.mapper.DatacontrolMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DatacontrolMapper {
    @Insert("insert into datacontrol (head,title,txt) values(#{head},#{title},#{txt})")
    void addtxt(Datacontrol datacontrol);

    @Select("select * from datacontrol where head=#{head} and title=#{title}")
    Datacontrol getdatacontrol(String head,String title);
    @Select("select txt from datacontrol where head=#{head} and title=#{title}")
    String gettxt1(String head,String title);

    @Delete("delete from datacontrol where head=#{head} and title=#{title}")
    void deletedatacontrol(String head,String title);
    @Delete("delete from datacontrol where txt=#{txt}")
    void deletedatacontrol1(String txt);

    @Update("update datacontrol set txt=#{txt} where head=#{head} and title=#{title}")
    void updatedatacontrol(String head,String title,String txt);

    @Select("select * from datacontrol where  head=#{head} and title=#{title} and txt=#{txt}")
    Datacontrol getdatacontrol1(String head,String title,String txt);
    @Select("select * from datacontrol where  head=#{head}")
    Datacontrol getdatacontrol2(String head);



    @Select("select * from datacontrol where id=#{id}")
    Datacontrol getId(Integer id);
    @Select("select title from datacontrol where id = #{id}")
    String gettitle(Integer id);
    @Select("select head from datacontrol where id = #{id}")
    String gethead(Integer id);
    @Select("select txt from datacontrol where id= #{id}")
    String gettxt(Integer id);

    @Select("select txt from datacontrol where head=#{head} and title=#{title}" )
    String gettxt2(String head,String title);
    @Select("select head from datacontrol where txt=#{txt}")
    String gethead1(String txt);


    @Select("select txt from datacontrol")
    List<String> Alltxt();
    @Select("select title from datacontrol")
    List<String> Alltitle();
    @Select("select head from datacontrol")
    List<String> Allhead();


}

