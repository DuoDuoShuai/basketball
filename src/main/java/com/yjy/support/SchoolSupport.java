package com.yjy.support;

import com.yjy.mapper.SchoolMapper;
import com.yjy.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:黄文倩
 * @CreatTime:2022/8/31
 * @Description:
 */
@Component
public class SchoolSupport {
    @Autowired
    private SchoolMapper schoolMapper;
    /**
     * 接口-查询全部的校区信息-给新增学员选择校区的信息
     * @return
     */
    public List<School> listAll(){
        return schoolMapper.listAll();
    }

    /**
     * 接口-根据校区名称查校区
     * @param schoolName
     * @return
     */
    public School loadByName(String schoolName){
        return schoolMapper.loadByName(schoolName);
    }
}
