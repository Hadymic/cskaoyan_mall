package com.cskaoyan.mall.controller.goods;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.goods.GoodsService;
import com.cskaoyan.mall.util.ListBean;
import com.cskaoyan.mall.util.Page;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.BaseValueLabel;
import com.cskaoyan.mall.vo.goodsmanagement.CategoryList;
import com.cskaoyan.mall.vo.goodsmanagement.GoodsEditVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商品管理
 * @author stark_h
 */
@RestController
@RequestMapping("admin/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("list")
    @RequiresPermissions(value = "admin:goods:list")
    public BaseRespVo GoodsList(Page page, Goods goods) {
            ListBean listBean = goodsService.selectGoods(page, goods);
            return BaseRespVo.success(listBean);

    }

    @RequestMapping("catAndBrand")
    @RequiresPermissions(value = "admin:goods:catAndBrand")
    public BaseRespVo CatAndBrand() {
        List<BaseValueLabel> brandList = goodsService.selectBrandList();
        List<CategoryList> categoryList = goodsService.selectCategory();
        Map map = new HashMap<>();
        map.put("categoryList", categoryList);
        map.put("brandList", brandList);
        return BaseRespVo.success(map);
    }

    @RequestMapping("delete")
    @RequiresPermissions(value = "admin:goods:delete")
    public BaseRespVo deleteGoods(@RequestBody Goods goods) {
        goodsService.deleteGoods(goods);
        return BaseRespVo.success(null);
    }

    @RequestMapping("detail")
    @RequiresPermissions(value = "admin:goods:detail")
    public BaseRespVo GoodsDetail(int id) {
        GoodsEditVo goodsEditVo = goodsService.selectGoodsDetail(id);
        return BaseRespVo.success(goodsEditVo);
    }

    /**
     * 更新商品信息，对输入参数进行判断
     */
    @RequestMapping("update")
    @RequiresPermissions(value = "admin:goods:update")
    public BaseRespVo updateGoods(@Valid @RequestBody GoodsEditVo goodsEditVo) {
        String message = goodsService.updateGoods(goodsEditVo);
        return "success".equals(message) ? BaseRespVo.success(null) : BaseRespVo.fail(message);
    }
    @RequestMapping("create")
    @RequiresPermissions(value = "admin:goods:create")
    public BaseRespVo createGoods(@Valid @RequestBody GoodsEditVo goodsEditVo){
        String message = goodsService.createGoods(goodsEditVo);//返回错误信息
        return "success".equals(message) ? BaseRespVo.success(null) : BaseRespVo.fail(message);
    }
}
