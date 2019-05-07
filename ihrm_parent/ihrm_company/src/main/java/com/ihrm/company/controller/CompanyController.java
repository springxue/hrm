package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    //保存企业
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.add(company);
        Result result=new Result(ResultCode.SUCCESS);

        return result;
    }
    //根据id更新企业
    @RequestMapping(value = "/${id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id,@RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id删除企业
    @RequestMapping(value = "/${id}",method = RequestMethod.DELETE)
    public Result update(@PathVariable String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id查询企业
    @RequestMapping(value = "/${id}",method = RequestMethod.GET)
    public Result getCompanyById(@PathVariable String id){
        Result result=new Result(ResultCode.SUCCESS);
        result.setData(companyService.getCompanyById(id));
        return result;
    }
    //查询全部企业列表
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        Result result=new Result(ResultCode.SUCCESS);
        result.setData(companyService.findAll());
        return result;
    }
}
