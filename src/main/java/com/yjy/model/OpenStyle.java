package com.yjy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 任凭
 * @create 2022/8/30 9:51
 * @describe TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenStyle {
    /**
     * 信息风采表id
     */
    private String styleId;
    /**
     * 学员id
     */
    private String studentId;
    /**
     * 所属校区
     */
    private String schoolId;
    /**
     * 学员风采图片
     */
    private String picture;
    /**
     * 学员风采图片
     */
    private String video;
    /**
     * 信息类型(0-跳转，1-排序)
     */
    private boolean styleType;
    /**
     * 排序（0-asc，1-desc）
     */
    private boolean sort;
    /**
     * 切换路径
     */
    private String cutUrl;
    /**
     * 是否展示（0-否，1-是）
     */
    private boolean isShow;
    /**
     * 是否删除（0-否，1-是）
     */
    private boolean isDelete;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long updateTime;
}
