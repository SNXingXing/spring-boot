package com.booklibrary.dao;

import com.booklibrary.model.Publisher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PublisherMapper {

    @Insert("insert into book_publisher (p_name) value(#{pName})")
    int addPublisher(Publisher publisher);

    @Update("update book_publisher SET p_name=#{pName} where p_id=#{pId}")
    int updatePublisher(Publisher publisher);

    @SelectProvider(type = PublisherSqlBuilder.class,method = "select")
    @Results({
            @Result(column = "p_id",property = "pId"),
            @Result(column = "p_name" ,property = "pName" )
    })
    List<Publisher> selectPublisher(Publisher publisher);

    @Delete("delete from book_publisher where p_id=#{pId}")
    int deletePublisher(Integer pId);


    int addPublisherByCall();


    class PublisherSqlBuilder {
        public String select(Publisher publisher) {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("book_publisher");
                    if (publisher != null) {
                        if (publisher.getpId() != null) {
                            WHERE("p_id=#{pId}");
                        }
                        if (publisher.getpName() != null) {
                            WHERE("p_name=#{pName}");
                        }
                    }
                }
            }.toString();
        }
    }
}
