package com.phonemarket.controller;

import com.phonemarket.entity.Goods;
import com.phonemarket.entity.Users;
import com.phonemarket.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("findGoodsByType")
    @ResponseBody
    public List<Goods> findGoodsByType(Integer typeId){
        List<Goods> list = goodsService.findGoodsByType(typeId);
        return list;
    }
    @RequestMapping("findAll")
    @ResponseBody
    public List<Goods> findAll(Integer typeId){
        List<Goods> list = goodsService.findAll();
        return list;
    }

    @RequestMapping("findGoodsByVolume")
    @ResponseBody
    public List<Goods> findGoodsByVolume(Integer limit){
        List<Goods> list = goodsService.findGoodsByVolume(limit);
        return list;
    }

    @RequestMapping("addGoods")
    @ResponseBody
    public Integer addGoods(Goods goods){
        Integer integer = goodsService.addGoods(goods);
        return integer;
    }
    @RequestMapping("update")
    @ResponseBody
    public Integer update(Goods goods){
        Integer integer = goodsService.update(goods);
        return integer;
    }

    @RequestMapping("deleteGoods")
    @ResponseBody
    public Integer deleteGoods(Integer goodsId){
        Integer integer = goodsService.deleteGoods(goodsId);
        return integer;
    }

    @RequestMapping("findGoodsLikeName")
    @ResponseBody
    public List<Goods> findGoodsByVolume(String name){
        List<Goods> list = goodsService.findGoodsLikeName(name);
        return list;
    }
    @RequestMapping("findHotGoods")
    @ResponseBody
    public List<Goods> findHotGoods(Integer num,HttpServletRequest request){
        HttpSession session = request.getSession();
        Goods goods = (Goods) session.getAttribute("goods");
        List<Goods> list = goodsService.findHotGoods(goods.getGoodsNum());
        return list;
    }

    @RequestMapping(value = "detail",method = {RequestMethod.GET})
    public String detail(Integer goodsId, Model model, HttpServletRequest request){
        Goods goods = goodsService.findById(goodsId);
//        HttpSession session = request.getSession();
//        session.setAttribute("goods", goods);
        model.addAttribute("goods", goods);
        return "userview/product_detail";
    }

    @RequestMapping(value = "search",method = {RequestMethod.POST})
    public String search(String goodsName, Model model, HttpServletRequest request){
        List<Goods> goodsLike = goodsService.findGoodsLikeName(goodsName);
        HttpSession session = request.getSession();
        session.setAttribute("searchList", goodsLike);
        model.addAttribute("searchList", goodsLike);
        return "userview/search";
    }
}
