package com.zc.mybatis.service;

import com.zc.mybatis.dao.StudentBookStatusDao;
import com.zc.mybatis.entity.StudentBookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentBookStatusService {

    @Autowired
    private StudentBookStatusDao sbsDao;

    public StudentBookStatus selectById(String id) {
        return sbsDao.selectById(id);
    }

    public Long countById(String bookId) {
        return sbsDao.queryStatusPersonNumByBookId(bookId);
    }

    public List<StudentBookStatus> selectBatch(String id, String bookId, String studentId) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("bookId", bookId);
        map.put("studentId", studentId);
        return sbsDao.queryOneOrList(map);
    }
}
