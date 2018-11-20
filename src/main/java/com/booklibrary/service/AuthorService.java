package com.booklibrary.service;

import com.booklibrary.dao.AuthorMapper;
import com.booklibrary.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorMapper authorMapper;

    /**
     * 检查有没有这个作者名,有就返回true
     * @param aName
     * @return
     */
    public boolean checkAuhtor(String aName){
        return authorMapper.selectAuthorByName(aName)!=null;
    }

    /**
     * 添加作者信息
     * @param author
     * @return 返回结果
     */
    public boolean addAuthor(Author author){
        return authorMapper.addAuthor(author)>0;
    }

    /**
     * 修改作者信息
     * @param author
     * @return
     */
    public boolean updateAuthor(Author author){
        return authorMapper.updateAuthor(author)>0;
    }

    /**
     * 根据条件查询作者
     * @param author
     * @return
     */
    public List<Author> findAuthor(Author author){
        return  authorMapper.selectALLAuthor(author);
    }
}
