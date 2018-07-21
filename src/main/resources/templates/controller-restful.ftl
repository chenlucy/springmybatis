/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：SwaggerConfig.java
 * 描述：  
 * 修改人：Arber.Lee  
 * 修改时间：2017年11月17日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package ${basePackage}.web;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;

/**
* @describe
* @author ${author}.
* @date ${date}.
*/
@Api(value = "${modelNameUpperCamel}Controller", tags = "${modelNameUpperCamel}")
@Slf4j
@RestController
@RequestMapping("/manage${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    @ApiOperation(value = "新增${modelNameUpperCamel}", tags = "${modelNameUpperCamel}")
    public Result add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        log.debug("新增User.");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除${modelNameUpperCamel}", tags = "${modelNameUpperCamel}")
    public Result delete(@PathVariable Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        log.debug("删除User.");
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value = "修改${modelNameUpperCamel}", tags = "${modelNameUpperCamel}")
    public Result update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        log.debug("修改User.");
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询${modelNameUpperCamel}", tags = "${modelNameUpperCamel}")
    public Result detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        log.debug("查询User.");
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @GetMapping
    @ApiOperation(value = "列表${modelNameUpperCamel}（支持分页）", tags = "${modelNameUpperCamel}")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        log.debug("列表User.");
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
