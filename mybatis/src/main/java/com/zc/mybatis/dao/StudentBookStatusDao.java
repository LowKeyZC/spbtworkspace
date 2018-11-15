package com.zc.mybatis.dao;

import com.zc.mybatis.entity.StudentBookStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentBookStatusDao {

    void insertOne(StudentBookStatus sbs);

    void updateStatusForFirstPass(StudentBookStatus sbs);

    void updateOneForEveryAnswer(StudentBookStatus sbs);

    List<StudentBookStatus> queryOneOrList(Map<String,String> map);

    List<StudentBookStatus> queryListByIds(Map<String,String> map);

    List<StudentBookStatus> queryListByBookIds(Map map);

    void updateStatusForEndGame(StudentBookStatus sbs);

    Long queryReadBookCount(String studentId);

    List<StudentBookStatus> queryReadingAndAllByStudentId(Map map);

    Long queryStatusPersonNumByBookId(String bookId);

    StudentBookStatus selectById(String id);
}
