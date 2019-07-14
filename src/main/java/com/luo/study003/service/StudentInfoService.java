package com.luo.study003.service;

import com.luo.study003.entity.StudentInfo;
import com.luo.study003.mapper.StudentInfoMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public StudentInfo getStudentInfoByStuNo(Integer stuNo){
        return studentInfoMapper.getStuByStuNo(stuNo);
    }

    public List<StudentInfo> getAllStudent(){
        return studentInfoMapper.getAllStudent();
    }

    //分页 RowBounds
    public List<StudentInfo> getAllStudentByPage1(int start, int limit){
        return studentInfoMapper.getAllStudentByPage1(new RowBounds(start,limit));
    }

    //分页 sql语句
    public List<StudentInfo> getAllStudentByPage2(int start, int limit){
        Map<String,Object> map=new HashMap<>();
        map.put("start",start);
        map.put("limit",limit);
        return studentInfoMapper.getAllStudentByPage2(map);
    }

    //分页 拦截器
    public List<StudentInfo> getAllStudentByPage3(Integer pageNo, Integer pageSize){
        return studentInfoMapper.getAllStudentByPage3(pageNo,pageSize);
    }

    public int addStudent(StudentInfo studentInfo){
        return studentInfoMapper.addStudent(studentInfo);
    }

    public List<StudentInfo> getStudentByConditions(StudentInfo studentInfo){
        return studentInfoMapper.getStudentByConditions(studentInfo);
    }

    public int updateStudentByStuNo(StudentInfo studentInfo){
        return studentInfoMapper.updateStudentByStuNo(studentInfo);
    }
}
