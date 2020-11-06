package com.codeworld.fc.dept.controller;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.dept.dto.DeptRequestDTO;
import com.codeworld.fc.dept.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ClassName DeptController
 * Description 部门接口管理
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
**/
@RestController
@RequestMapping("system-dept")
@Api(tags = "部门接口管理")
public class DeptController {

    @Autowired(required = false)
    private DeptService deptService;

    @PostMapping("tree-dept")
    @ApiOperation("获取部门树")
    public FCResponse<Object> treeDept(){
        return this.deptService.treeDept();
    }

    @PostMapping("add-dept")
    @ApiOperation("添加部门")
    public FCResponse<Void> addDept(@RequestBody @Valid DeptRequestDTO deptRequestDTO){
        return this.deptService.addDept(deptRequestDTO);
    }

    @PostMapping("update-dept")
    @ApiOperation("修改部门")
    public FCResponse<Void> updateDept(@RequestBody @Valid DeptRequestDTO deptRequestDTO){
        return this.deptService.updateDept(deptRequestDTO);
    }

}
