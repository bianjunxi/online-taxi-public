package com.mi.map.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TerminalResponse;

/**
 * ClassName:  TerminalService
 * Description: 终端管理
 *
 * @author Jay
 * @version v1.0
 */
public interface TerminalService {

    /**
     * 添加终端
     * @param name
     * @return
     */
    ResponseResult<TerminalResponse> add(String name);

}
