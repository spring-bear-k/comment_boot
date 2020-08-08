package com.dxt.comment_boot.service;

import com.dxt.comment_boot.vo.CommentVo;
import com.dxt.comment_boot.vo.HomeList;
import com.github.pagehelper.PageInfo;


public interface CommentService {
    public HomeList<CommentVo> getCommentList(Integer page, Integer pageSize, Integer id);
    public boolean insertComment(Integer id, String comment, Integer star);
    public PageInfo<CommentVo> selectComment(String title, Integer pageNum, Integer pageSize);
    public boolean deleteComment(Integer id);
}
