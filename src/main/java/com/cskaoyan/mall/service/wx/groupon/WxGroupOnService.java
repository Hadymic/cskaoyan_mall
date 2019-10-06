package com.cskaoyan.mall.service.wx.groupon;

import com.cskaoyan.mall.util.Page;
import com.cskaoyan.mall.util.WxListBean;
import com.cskaoyan.mall.vo.wx.groupon.WxGrouponDetailVo;
import org.springframework.stereotype.Service;

/**
 * 团购模块service
 *
 * author Zeng-jz
 */
@Service
public interface WxGroupOnService {
    WxListBean selectByPage(Page page);

    WxListBean selectMyGroupOn(int showType);

    WxGrouponDetailVo selectGrouponById(int grouponId);
}
