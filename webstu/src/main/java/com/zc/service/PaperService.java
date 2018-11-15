package com.zc.service;

import com.zc.dao.PaperMapper;
import com.zc.domain.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    Paper selectById(String id) {
        return paperMapper.selectById(id);
    }

    void insertPaper(Paper paper) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        paper.setId(id);
        paperMapper.insertPaper(paper);
    }

    void modifyPaper(Paper paper) {
        paperMapper.modifyPaper(paper);
    }

    void deleteById(String id) {
        paperMapper.deleteById(id);
    }
}
