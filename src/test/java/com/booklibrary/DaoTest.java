package com.booklibrary;

import com.booklibrary.dao.AuthorMapper;
import com.booklibrary.dao.PublisherMapper;
import com.booklibrary.dao.UserMapper;
import com.booklibrary.model.Author;
import com.booklibrary.model.Publisher;
import com.booklibrary.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Autowired
    AuthorMapper authorMapper;
    @Autowired
    PublisherMapper publisherMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    public void addAuthorTest() {
        int i = authorMapper.addAuthor(new Author(null, "我吃西红柿"));
        System.out.println("插入结果:" + (i > 0));
    }

    @Test
    public void updateAuthorTest() {
        int i = authorMapper.updateAuthor(new Author(6, "我爱吃西红柿"));
        System.out.println("修改结果:" + (i > 0));
    }

    @Test
    public void findAuthorTest() {
//        Author author = authorMapper.selectAuthorById(6);
//        Author author = authorMapper.selectAuthorByName("猫腻");
        List<Author> authors = authorMapper.selectALLAuthor(null);
        for (Author author: authors) {
            System.out.println("author:"+author);
        }
//        System.out.println(author);
    }

    @Test
    public void deleteAuhtorTest() {
        int i = authorMapper.deleteAuthor(6);
        System.out.println("删除结果:" + (i > 0));
    }

    @Test
    public  void selectPublisher(){
        List<Publisher> publishers = publisherMapper.selectPublisher(new Publisher(1,null));
        for (Publisher publisher:publishers) {
            System.out.println(publisher);
        }
    }
    @Test
    public void insertUser(){
        int i = userMapper.insertUser(new User(null, "s578868472", "a123456"));
        System.out.println("user插入结果:"+(i>0));
    }
    @Test
    public void selectUser(){
        User user = userMapper.selectUserByLogin(new User(null, "s578868472", "a123456"));
        System.out.println(user);
    }
    @Test
    public void updateUser(){
        int i = userMapper.updateUser(new User(6, "a578868472", "a321"));
        System.out.println("修改结果:"+(i>0));
    }
}
