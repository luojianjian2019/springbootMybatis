package com.luo.study003.mapper;

import com.luo.study003.entity.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

//@Mapper
public interface StudentInfoMapper {

    StudentInfo getStuByStuNo(Integer StuNo);

    List<StudentInfo> getAllStudent();

    List<StudentInfo> getAllStudentByPage1(RowBounds rowBounds);

    List<StudentInfo> getAllStudentByPage2(Map<String,Object> map);

    List<StudentInfo> getAllStudentByPage3(@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize);

    int addStudent(StudentInfo studentInfo);

    List<StudentInfo> getStudentByConditions(StudentInfo studentInfo);

    int updateStudentByStuNo(StudentInfo studentInfo);
}
