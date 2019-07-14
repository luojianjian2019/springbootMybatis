package com.luo.study003.controller;

import com.luo.study003.entity.StudentInfo;
import com.luo.study003.service.StudentInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/studentInfo")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @ApiOperation(value="获取学生信息", notes="通过学号获取信息")
    @RequestMapping(value = "getStudentInfoByStuNo",method = RequestMethod.GET)
    @ResponseBody
    public StudentInfo getStudentInfo(Integer StuNo){
        return studentInfoService.getStudentInfoByStuNo(StuNo);
    }

    @ApiOperation(value="获取学生信息", notes="获取所有信息不分页")
    @RequestMapping(value = "getAllStudent",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> getStudentInfo(){
        return studentInfoService.getAllStudent();
    }

    @ApiOperation(value="分页获取学生信息", notes="RowBounds分页")
    @RequestMapping(value = "getAllStudentByPage1",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> getAllStudentByPage1(int pageNo){
        return studentInfoService.getAllStudentByPage1((pageNo-1)*3,3);
    }

    @ApiOperation(value="分页获取学生信息", notes="sql语句分页")
    @RequestMapping(value = "getAllStudentByPage2",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> getAllStudentByPage2(int pageNo){
        return studentInfoService.getAllStudentByPage2((pageNo-1)*3,3);
    }

    @ApiOperation(value="分页获取学生信息", notes="拦截器分页")
    @RequestMapping(value = "getAllStudentByPage3",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> getAllStudentByPage3(int pageNo){
        return studentInfoService.getAllStudentByPage3(pageNo,3);
    }

    @ApiOperation(value="插入学生信息", notes="插入学生信息")
    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody StudentInfo studentInfo){
        int result=studentInfoService.addStudent(studentInfo);
        if(result!=0){
            return "OK";
        }else {
            return "fail";
        }
    }

    @ApiOperation(value="查询学生信息", notes="多条件查询学生信息")
    @RequestMapping(value = "getStudentByConditions",method = RequestMethod.GET)
    @ResponseBody
    public List<StudentInfo> getStudentByConditions(@RequestBody StudentInfo studentInfo){
        return studentInfoService.getStudentByConditions(studentInfo);
    }

    @ApiOperation(value="更新学生信息", notes="更新学生信息")
    @RequestMapping(value = "updateStudentByStuNo",method = RequestMethod.PUT)
    @ResponseBody
    public String updateStudentByStuNo(@RequestBody StudentInfo studentInfo){
        int result=studentInfoService.updateStudentByStuNo(studentInfo);
        if(result!=0){
            return "OK";
        }else {
            return "fail";
        }
    }
}
