package com.cskaoyan.mall.service.userserver.userserverimpl;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.userserver.UserManageService;
import com.cskaoyan.mall.util.ListBean;
import com.cskaoyan.mall.util.Page;
import com.cskaoyan.mall.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserMapper userMapper;
    @Override
    public ListBean getDispalyList(Page utipage) {
        PageHelper.startPage(utipage.getPage(), utipage.getLimit());
        String username = utipage.getUsername();
        String mobile = utipage.getMobile();
        if (username==null)username="";
        if (mobile==null)mobile="";
        username = "%"+username+"%";
        mobile = "%"+mobile+"%";
        List<User> users = userMapper.selectByNameAndMobile(username, mobile);
//        PageInfo<User> pageInfo = new PageInfo<User>(users);
//        int total =  (int)pageInfo.getTotal();
//        ListBean listBean = new ListBean(users,total);
        return PageUtils.page(users);
       // return listBean;
    }

}
