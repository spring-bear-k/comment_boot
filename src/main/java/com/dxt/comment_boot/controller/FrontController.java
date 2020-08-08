package com.dxt.comment_boot.controller;

import com.dxt.comment_boot.entity.Member;
import com.dxt.comment_boot.service.*;
import com.dxt.comment_boot.util.JwtUtil;
import com.dxt.comment_boot.util.MD5Test;
import com.dxt.comment_boot.util.RespBean;
import com.dxt.comment_boot.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api")
public class FrontController {

    @Autowired
    private AdService adService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrdersService ordersService;

    //超值特惠
    @GetMapping("homead")
    public List<AdVo> getAdList(){
        return adService.getAdList();
    }

    //猜你喜欢
    @GetMapping("homelist/{city}/{page}")
    public HomeList<BusinessVo> getBusinessList(@PathVariable String city, @PathVariable Integer page){
       return businessService.getBusinessList(page,7,city,null,null);
    }

    //搜索
    @GetMapping("search/{page}/{city}/{category}/{keyword}")
    public HomeList<BusinessVo> getLikeBusiness(@PathVariable Integer page,
                                                @PathVariable String city,
                                                @PathVariable String category,
                                                @PathVariable String keyword){
        return businessService.getBusinessList(page,7,city,category.trim(),keyword);
    }
    //搜索
    @GetMapping("search/{page}/{city}/{category}")
    public HomeList<BusinessVo> getCategoryBusiness(@PathVariable Integer page,
                                                @PathVariable String city,
                                                @PathVariable String category){
        return businessService.getBusinessList(page,7,city,category.trim(),null);
    }

    //商家详情
    @GetMapping("detail/info/{id}")
    public BusinessVo getBusiness(@PathVariable Integer id){
        return businessService.getBusiness(id);
    }

    //用户点评
    @GetMapping("detail/comment/{page}/{id}")
    public HomeList<CommentVo> getCommentList(@PathVariable Integer page, @PathVariable Integer id){
        return commentService.getCommentList(page,5,id);
    }

    //用户验证
    @PostMapping("sms")
    public RespBean sms(@RequestParam("username") String username, HttpSession session){
        Member member=memberService.selectMember(username);
        if (member!=null&&member.getPhone()!=null){
            Random random = new Random();
            String result="";
            for (int i=0;i<6;i++)
            {
                result+=random.nextInt(10);
            }
            System.out.println("验证码=============================>>>"+result);
            session.setAttribute(""+member.getPhone(), MD5Test.md5(result));
            session.setMaxInactiveInterval(60);
            return RespBean.ok(result);
        }else {
            return RespBean.error("用户不存在！");
        }
    }
    //登录
    @PostMapping("login")
    public RespBean login(@RequestParam("username") String username,
                          @RequestParam("code") String code,
                          HttpSession session,
                          HttpServletResponse response){
        if (session.getAttribute(""+username).toString().trim().equals(code.trim())){
            response.setHeader("accessToken",JwtUtil.sign(username));
            session.setAttribute("username",username);
            return RespBean.ok("ok", JwtUtil.sign(username));
        }else {
            return RespBean.error("验证失败！");
        }
    }
    //添加订单
    @PostMapping("order")
    public RespBean buyOrder(@RequestParam("id") Integer id,
                             @RequestParam("username") String username,
                             @RequestParam("num") Integer num,
                             @RequestParam("price") BigDecimal price){
        if (ordersService.insertOrder(id,username,num,price)){
            return RespBean.ok("ok");
        }else {
            return RespBean.error("创建订单出错！");
        }
    }
    //订单列表
    @GetMapping("orderlist/{username}")
    public List<OrdersVo> getOrdersList(@PathVariable String username){
        return ordersService.getOrdersList(username);
    }
    //评论
    @PostMapping("submitComment")
    public RespBean insertComment(@RequestParam Integer id,
                                  @RequestParam String comment,
                                  @RequestParam Integer star,
                                  @RequestParam String username,
                                  HttpSession session){
        if (session.getAttribute("username").equals(username)){
            if (commentService.insertComment(id,comment,star)){
                return RespBean.ok("ok");
            }
        }
    return RespBean.error("评论失败");
    }
}
