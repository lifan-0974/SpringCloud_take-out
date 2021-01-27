package com.lllfff.controller;

import com.lllfff.entity.Menu;
import com.lllfff.entity.MenuVO;
import com.lllfff.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuFeign menuFeign;
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public  MenuVO findAll(@RequestParam("page")int page, @RequestParam("limit")int limit){
        int index=(page-1) * limit;
        return menuFeign.findAll(index,limit);
    }
    /*删除meno某个菜品*/
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
         menuFeign.deleteById(id);
         return "redirect:/menu/redirect/menu_manage";
    };
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
       ModelAndView model=new ModelAndView();
       model.setViewName("menu_add");
       model.addObject("list",menuFeign.findTypes());
       return  model;
    }
    //添加菜品
    @PostMapping("/save")
   public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    /*查询单个产品*/
    @GetMapping("/findById/{id}")
    public ModelAndView  findById(@PathVariable("id")long id){
        ModelAndView model=new ModelAndView();
        model.addObject("menu",menuFeign.findById(id));
        model.addObject("list",menuFeign.findTypes());
        model.setViewName("menu_update");
        return  model;
    }


    /*修改菜品*/
    @PostMapping("update")
    String update(Menu menu){
    menuFeign.update(menu);
    return "redirect:/menu/redirect/menu_manage";
    }
}
