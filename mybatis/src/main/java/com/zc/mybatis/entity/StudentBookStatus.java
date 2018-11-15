package com.zc.mybatis.entity;

import java.util.Date;

public class StudentBookStatus {

    private String id;
    private String studentId;
    private String bookId;

//    0未读
//    1正在读
//    2全部读完
    private int status =0;
    
    private int wordNum = 0;//已经读的字数，单位个
    
    private int wordTotalNum = 0;//总字数 单位个
    
    private int passLevelNum=0;//已经通关的关卡数
    
    private int levelNum=0;//总经通关的关卡数
    
    //总PK机会
    private int pkNum = 0;
    
    //已经使用的PK
    private int usedPKNum = 0; 
    
    private Date createDate = null;
    private Date modifyDate = null;
    
    private int isDelete = 0;
    private String gradeId; //书籍年级
    
    private String stuGradeId; //学生年级
    
    private String boxStatus; // 宝箱开启状态，0未开1已开
    
	public int getPassLevelNum() {
		return passLevelNum;
	}
	public void setPassLevelNum(int passLevelNum) {
		this.passLevelNum = passLevelNum;
	}
	public int getWordTotalNum() {
		return wordTotalNum;
	}
	public void setWordTotalNum(int wordTotalNum) {
		this.wordTotalNum = wordTotalNum;
	}
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
 	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getWordNum() {
		return wordNum;
	}
	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}
	public int getPkNum() {
		return pkNum;
	}
	public void setPkNum(int pkNum) {
		this.pkNum = pkNum;
	}
	public int getUsedPKNum() {
		return usedPKNum;
	}
	public void setUsedPKNum(int usedPKNum) {
		this.usedPKNum = usedPKNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getStuGradeId() {
		return stuGradeId;
	}
	public void setStuGradeId(String stuGradeId) {
		this.stuGradeId = stuGradeId;
	}
	public String getBoxStatus() {
		return boxStatus;
	}
	public void setBoxStatus(String boxStatus) {
		this.boxStatus = boxStatus;
	}


}

