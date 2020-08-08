package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.Member;
import com.dxt.comment_boot.mapper.MemberMapper;
import com.dxt.comment_boot.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member selectMember(String username) {
        Example example=new Example(Member.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(username)){
            criteria.andEqualTo("phone",username);
        }
        return memberMapper.selectOneByExample(example);
    }
}
