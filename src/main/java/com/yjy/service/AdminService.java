package com.yjy.service;

import com.yjy.dto.LayUiDto;
import com.yjy.vo.JsonPageResult;

/**
 * @author 徐晓瑞
 * @date 2022/8/29 17:14
 * @describe: TODO-
 */
public interface AdminService {
    /**
     * 管理员信息查询全部
     * @param dto
     * @return
     */
    JsonPageResult list(LayUiDto dto);
}
