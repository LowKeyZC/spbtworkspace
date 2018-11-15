package com.zc.service;

import com.zc.dao.PaperMapper;
import com.zc.domain.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperServiceTest {
    @Autowired
    private PaperMapper paperMapper;

    @Test
    public void selectById() throws Exception {
        Paper paper = paperMapper.selectById("123");
    }

    @Test
    public void insertPaper() throws Exception {
        Paper paper = new Paper();
//        paper.setId();
     }

    @Test
    public void modifyPaper() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

}