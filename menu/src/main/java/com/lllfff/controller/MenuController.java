package com.lllfff.controller;

import com.lllfff.entity.Menu;
import com.lllfff.entity.MenuVO;
import com.lllfff.entity.Type;
import com.lllfff.mapper.MenuMapper;
import com.lllfff.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private TypeMapper typeMapper;

    /*查询所有信息并且分页*/
    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index")Integer index, @PathVariable("limit")Integer limit){
        return new  MenuVO(0,"",menuMapper.count(),menuMapper.findAll(index,limit));
    }
    /*查询所有菜品类型*/
    @GetMapping("/findTypes")
    public List< Type> findTypes(){
        return typeMapper.findAll();
    }


    /*删除meno某个菜品*/
    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        menuMapper.deleteById(id);
    }

    /*查询单个产品*/
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id")long id){
        return menuMapper.findById(id);
    }


    /*修改菜品*/
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuMapper.update(menu);
    }

    //添加菜品
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.save(menu);
    }
}
