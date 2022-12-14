package com.app.controller;

import com.app.service.impl.WxGradeStudentServiceImpl;
import com.app.support.WxGradeSupport;
import com.app.vo.WxJsonResult;
import com.yjy.model.GradeStudent;
import com.yjy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:黄文倩
 * @CreatTime:2022/9/7
 * @Description:
 */
@RestController
@RequestMapping("wx_grade_student")
public class WxGradeStudentController {
    @Autowired
    private WxGradeStudentServiceImpl wxGradeStudentService;
    private WxGradeSupport wxGradeSupport;
    /**
     * 添加到班级-新增班级学员关系
     * @param gradeStudent
     * @return
     */
    @RequestMapping("insertGrade")
    public WxJsonResult insertGrade(GradeStudent gradeStudent){
        wxGradeSupport.totalCount(gradeStudent.getGradeId());
        return WxJsonResult.success(wxGradeStudentService.insertGrade(gradeStudent));
    }

    /**
     * 移除班级-改变学员状态
     * @param gradeStudent
     * @return
     */
    @RequestMapping("updateState")
    public WxJsonResult updateState(GradeStudent gradeStudent){
        return WxJsonResult.success(wxGradeStudentService.updateState(gradeStudent));
    }


}
