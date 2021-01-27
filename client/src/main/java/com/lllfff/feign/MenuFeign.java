package com.lllfff.feign;

import com.lllfff.entity.Menu;
import com.lllfff.entity.MenuVO;
import com.lllfff.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
    /*查询所有信息并且分页*/
    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuVO findAll(@PathVariable("index")Integer index, @PathVariable("limit")Integer limit);
    /*删除meno某个菜品*/
    @GetMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id")long id);
    @GetMapping("/menu/findTypes")
     List< Type> findTypes();
    /*查询单个产品*/
    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id")long id);


    /*修改菜品*/
    @PutMapping("/menu/update")
    void update(@RequestBody Menu menu);

    //添加菜品
    @PostMapping("/menu/save")
    void save(@RequestBody Menu menu);
}
