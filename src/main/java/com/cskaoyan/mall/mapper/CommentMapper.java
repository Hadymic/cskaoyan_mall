package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectCommentList(@Param("comment") Comment comment);

    //设置deleted=1
    void updateCommentDeleted(@Param("id") Integer id);
}
