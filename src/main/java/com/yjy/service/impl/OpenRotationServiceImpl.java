package com.yjy.service.impl;

import com.yjy.dto.LayUiDto;
import com.yjy.mapper.OpenRotationMapper;
import com.yjy.model.OpenRotation;
import com.yjy.service.OpenRotationService;
import com.yjy.util.QiniuFile;
import com.yjy.vo.JsonPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 任凭
 * @create 2022/8/31 13:06
 * @describe TODO
 */
@Service
public class OpenRotationServiceImpl implements OpenRotationService {

    @Autowired
    private OpenRotationMapper openRotationMapper;

    /**
     * 列表
     *
     * @param dto
     * @return 返回mapvo页面表格数据
     */
    @Override
    public JsonPageResult listOpenRotation(LayUiDto dto) {
        Integer count = openRotationMapper.count(dto);
        if (count == 0) {
            return JsonPageResult.successPage();
        }
        List<OpenRotation> list = openRotationMapper.listOpenRotation(dto);
        JsonPageResult mapVo = JsonPageResult.successPage(list, count);
        return mapVo;
    }

    /**
     * 详情
     *
     * @param rotationId
     * @return 返回一个OpenRotation对象
     */
    @Override
    public OpenRotation loadOpenRotation(String rotationId) {
        OpenRotation openRotation = openRotationMapper.loadOpenRotation(rotationId);
        return openRotation;
    }

    /**
     * 增加
     *
     * @param openRotation
     * @return 整数num=1
     */
    @Override
    public Integer insertOpenRotation(OpenRotation openRotation, MultipartFile img) {
        try {
            openRotation.setRotationId(UUID.randomUUID().toString());
            Date currentTime = new Date(System.currentTimeMillis());
            openRotation.setCreateTime(currentTime.getTime());
            openRotation.setUpdateTime(currentTime.getTime());
            if (img!=null){
                openRotation.setPhoto(QiniuFile.uploadFile(img.getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openRotationMapper.insertOpenRotation(openRotation);
    }

    /**
     * 删除
     *
     * @param rotationId
     * @return 整数delete=1
     */
    @Override
    public Integer deleteOpenRotation(String rotationId) {
        OpenRotation openRotation = new OpenRotation();
        openRotation.setRotationId(rotationId);
        Date currentTime = new Date(System.currentTimeMillis());
        openRotation.setUpdateTime(currentTime.getTime());
        openRotationMapper.updateTime(openRotation);
        return openRotationMapper.deleteOpenRotation(openRotation);
    }

    /**
     * 批量删除
     *
     * @param openRotationIds
     * @return 返回多个对象delete参数
     */
    @Override
    public Integer deleteMore(String openRotationIds) {
        String[] split = openRotationIds.split(",");
        Integer integer = 0;
        for (String s : split) {
            OpenRotation openRotation = new OpenRotation();
            openRotation.setRotationId(s);
            Date currentTime = new Date(System.currentTimeMillis());
            openRotation.setUpdateTime(currentTime.getTime());
            openRotationMapper.updateTime(openRotation);
            integer = openRotationMapper.deleteOpenRotation(openRotation);
        }
        return integer;
    }

    /**
     * 修改
     *
     * @param openRotation
     * @return 整数update=1
     */
    @Override
    public Integer updateOpenRotation(OpenRotation openRotation, MultipartFile img) {
        try {
            Date currentTime = new Date(System.currentTimeMillis());
            openRotation.setUpdateTime(currentTime.getTime());
            if (img!=null) {
            openRotation.setPhoto(QiniuFile.uploadFile(img.getBytes()));
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openRotationMapper.updateOpenRotation(openRotation);
    }
}
