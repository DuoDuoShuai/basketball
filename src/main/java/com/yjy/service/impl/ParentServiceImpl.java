package com.yjy.service.impl;

import com.yjy.dto.LayUiDto;
import com.yjy.mapper.ParentMapper;
import com.yjy.model.Admin;
import com.yjy.model.Parent;
import com.yjy.service.ParentService;
import com.yjy.util.QiniuFile;
import com.yjy.vo.JsonPageResult;
import com.yjy.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 徐晓瑞
 * @date 2022/8/29 23:25
 * @describe:
 */

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    /**
     * 家长信息展示
     * @param dto
     * @return
     */
    @Override
    public JsonPageResult list(LayUiDto dto) {
        //判断是否有数据
        Integer count = parentMapper.count(dto);
        if(count ==0) {
            return JsonPageResult.successPage();
        }
        List<Admin> list = parentMapper.list(dto);
        JsonPageResult map = JsonPageResult.successPage(list, count);
        return map;
    }

    /**
     * 添加家长信息
     * @param parent
     * @return
     */
    @Override
    public Integer insertParent(Parent parent, MultipartFile img) {
        try {
            parent.setParentId(UUID.randomUUID().toString());
            Date currentTime=new Date(System.currentTimeMillis());
            parent.setParentRegtime(currentTime.getTime());
            if (img != null){
                parent.setParentPhoto(QiniuFile.uploadFile(img.getBytes()));
            } else {
                parent.setParentPhoto("Ft7t33aDzKOQ_-99zzefF1kWU7dw");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parentMapper.insertParent(parent);
    }

    /**
     * 批量删除家长信息
     * @param str
     * @return
     */
    @Override
    public Integer deleteParentMore(String str) {
        String[] split = str.split(",");
        Integer integer = 0;
        for (String s : split) {
            Parent parent = new Parent();
            parent.setParentId(s);
            Date currentTime = new Date(System.currentTimeMillis());
            parent.setUpdateTime(currentTime.getTime());
            parentMapper.updateTime(parent);
            integer = parentMapper.deleteParent(parent);
        }
        return integer;
    }

    /**
     * 删除家长信息
     * @param parentId
     * @return
     */
    @Override
    public Integer deleteParent(String parentId) {
        Parent parent = new Parent();
        parent.setParentId(parentId);
        Date currentTime = new Date(System.currentTimeMillis());
        parent.setUpdateTime(currentTime.getTime());
        parentMapper.updateTime(parent);
        return parentMapper.deleteParent(parent);
    }

    /**
     * 修改家长信息
     * @param parent
     * @return
     */
    @Override
    public Integer updateParent(Parent parent,MultipartFile img) {
        try {
            Date currentTime=new Date(System.currentTimeMillis());
            parent.setUpdateTime(currentTime.getTime());
            if (img != null){
                parent.setParentPhoto(QiniuFile.uploadFile(img.getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parentMapper.updateParent(parent);
    }
}
