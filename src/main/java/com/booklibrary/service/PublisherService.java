package com.booklibrary.service;

import com.booklibrary.dao.PublisherMapper;
import com.booklibrary.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    PublisherMapper publisherMapper;

    /**
     * 添加出版社
     * @param publisher
     * @return
     */
    public boolean addPublisher(Publisher publisher){
        return publisherMapper.addPublisher(publisher)>0;
    }

    public boolean updatePublisher(Publisher publisher){
        return publisherMapper.updatePublisher(publisher)>0;
    }

    public boolean deletePublisher(Integer pId){
        return publisherMapper.deletePublisher(pId)>0;
    }

    public List<Publisher> findPublisher(Publisher publisher){
        return publisherMapper.selectPublisher(publisher);
    }


}
