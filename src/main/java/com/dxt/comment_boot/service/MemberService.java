package com.dxt.comment_boot.service;

import com.dxt.comment_boot.entity.Member;

public interface MemberService {
    public Member selectMember(String username);
}
