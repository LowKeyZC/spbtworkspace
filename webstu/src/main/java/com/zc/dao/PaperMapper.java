package com.zc.dao;

import com.zc.domain.Paper;

public interface PaperMapper {
    void insertPaper(Paper paper);

    void modifyPaper(Paper paper);

    Paper selectById(String id);

    Paper deleteById(String id);
}
