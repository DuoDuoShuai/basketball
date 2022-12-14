package com.yjy.mapper;

import com.yjy.dto.LayUiDto;
import com.yjy.model.Admin;
import com.yjy.model.Parent;
import com.yjy.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 徐晓瑞
 * @date 2022/8/29 17:14
 * @describe:
 */
@Repository
public interface TeacherMapper {
    /**
     * 教练信息查询全部
     * @param dto
     * @return
     */
    List<Admin> list(LayUiDto dto);

    /**
     * 列表总数
     * @param dto
     * @return
     */
    Integer count(LayUiDto dto);

    /**
     * 添加教练信息
     * @param teacher
     * @return
     */
    Integer insertTeacher(Teacher teacher);

    /**
     * 删除教练信息
     * @param teacher
     * @return
     */
    Integer deleteTeacher(Teacher teacher);

    /**
     * 修改教练信息
     * @param teacher
     * @return
     */
    Integer updateTeacher(Teacher teacher);

    /**
     * 删除时改变修改时间
     * @param teacher
     * @return
     */
    Integer updateTime(Teacher teacher);
}
