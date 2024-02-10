package com.mi.map.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TerminalResponse;
import com.mi.map.remote.TerminalClient;
import com.mi.map.service.TerminalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  TerminalServiceImpl
 * Description: 终端管理
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class TerminalServiceImpl implements TerminalService {
    @Autowired
    TerminalClient terminalClient;

    public ResponseResult<TerminalResponse> add(String name){
        return terminalClient.add(name);
    }
}
