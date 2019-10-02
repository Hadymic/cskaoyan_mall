package com.cskaoyan.mall.service.promotion.impl;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.service.promotion.AdService;
import com.cskaoyan.mall.util.ListBean;
import com.cskaoyan.mall.util.Page;
import com.cskaoyan.mall.util.PageUtils;
import com.cskaoyan.mall.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 广告管理Service实现类
 *
 * @author hadymic
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;

    @Override
    public ListBean<Ad> queryAds(Page page, String name, String content) {
        PageUtils.startPage(page);
        if (!StringUtils.isEmpty(name)) {
            name = name.trim();
        }
        if (!StringUtils.isEmpty(content)) {
            content = content.trim();
        }
        List<Ad> ads = adMapper.queryAds(name, content);
        return PageUtils.page(ads);
    }

    @Override
    public Ad updateAd(Ad ad) {
        ad.setUpdateTime(new Date());
        return adMapper.updateByPrimaryKeySelective(ad) == 1 ? ad : null;
    }

    @Override
    public boolean deleteAd(Integer id) {
        Ad ad = new Ad();
        ad.setId(id);
        ad.setDeleted(true);
        ad.setUpdateTime(new Date());
        return adMapper.updateByPrimaryKeySelective(ad) == 1;
    }

    @Override
    public Ad insertAd(Ad ad) {
        ad.setAddTime(new Date());
        ad.setDeleted(false);
        return adMapper.insertSelectKey(ad) == 1 ? ad : null;
    }
}
