package com.booklibrary.dao;

import com.booklibrary.model.Author;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author star
 */
@Mapper
@Component
public interface AuthorMapper {

    @Insert("insert into book_author(a_name) value(#{aName})")
    int addAuthor(Author author);

    @Update("update book_author Set a_name =#{aName} where a_id = #{aId}")
    int updateAuthor(Author author);


    @Results( {
            @Result(property = "aId",column = "a_id",id = true),
            @Result(property = "aName",column = "a_name")
    })
    @Select("select * from book_author where a_id=#{aId}")
    Author selectAuthorById(Integer aId);


    @Results({
            @Result(property = "aId",column = "a_id"),
            @Result(property = "aName",column = "a_name")
    })
    @Select("select * from book_author where a_name=#{aName}")
    Author selectAuthorByName(String aName);

    @Delete("delete from book_author where a_id=#{aId}")
    int deleteAuthor(Integer aId);

    @SelectProvider(type=AuthorSqlBuilder.class ,method = "select")
    @Results({
            @Result(property = "aId",column = "a_id",id = true),
            @Result(property = "aName",column = "a_name")
    })
    List<Author> selectALLAuthor(Author author);



    class AuthorSqlBuilder{
         public static String select(Author author){
             return new SQL(){
                 {
                     SELECT("*");
                     FROM("book_author");
                     if(author!=null){
                         if (author.getaId()!=null){
                             WHERE("a_id=#{aId}");
                         }
                         if (author.getaName()!=null){
                             WHERE("a_name=#{aName}");
                         }
                     }

                 }
             }.toString();
         }
    }
}
