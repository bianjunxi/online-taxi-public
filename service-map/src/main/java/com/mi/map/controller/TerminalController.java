package com.mi.map.controller;


import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TerminalResponse;
import com.mi.map.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:  TerminalController
 * Description: 终端管理
 *
 * @author Jay
 * @version v1.0
 */
@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    /**
     * 添加终端
     * @param name
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<TerminalResponse> add(String name){
        return terminalService.add(name);
    }
}