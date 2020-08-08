package com.dxt.comment_boot.controller;

import com.dxt.comment_boot.entity.Ad;
import com.dxt.comment_boot.entity.Business;
import com.dxt.comment_boot.entity.SysUser;
import com.dxt.comment_boot.service.*;
import com.dxt.comment_boot.util.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class AfterController {

    @Autowired
    private AdService adService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/log")
    public String log(){
        return "login";
    }
    //登录
    @GetMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpSession session){
        SysUser sysUser=sysUserService.login(name,password);
        if (sysUser!=null&&sysUser.getName()!=null){
            session.setAttribute("user",sysUser);
            session.setAttribute("menu",sysMenuService.selectSysMenu(sysUser.getGroupId()));
            System.out.println(sysMenuService.selectSysMenu(sysUser.getGroupId()).get(1).getParent_id());
            return "index";
        }
        return "<script>alert('登录失败!');history.go(-1)</script>";
    }
    //退出登录
    @GetMapping("/loginOut")
    @ResponseBody
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "<script>alert('已退出!');location.href='/login.jsp'</script></script>";
    }
    //首页初始化
    @GetMapping("/auth")
    public String index(){
        return "index";
    }
    //广告管理初始化
    @GetMapping("/ad")
    public ModelAndView ad(@RequestParam(value = "title",required = false) String title,
                           @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize,
                           ModelAndView modelAndView){
        modelAndView.addObject("adPage",adService.selectAdList(title,pageNum,pageSize));
        modelAndView.addObject("title",title);
        modelAndView.setViewName("ad");
        return modelAndView;
    }
    //广告管理修改添加初始化 0修改 1添加
    @GetMapping("/ad/init")
    public ModelAndView adInit(@RequestParam("id") Integer id, ModelAndView modelAndView){
        if (id!=null){
            modelAndView.addObject("ad",adService.getAd(id));
            modelAndView.addObject("is",0);
        }else {
            modelAndView.addObject("is",1);
        }
        modelAndView.setViewName("operateAd");
        return modelAndView;
    }
    //修改广告
    @PostMapping("/ad/modify")
    @ResponseBody
    public boolean updateAd(Ad ad){
        return adService.updateAd(ad);
    }
    //添加广告
    @PostMapping("/ad/add")
    @ResponseBody
    public boolean insertAd(Ad ad){
        return adService.insertAd(ad);
    }
    //删错广告
    @ResponseBody
    @DeleteMapping("/ad/remove/{id}")
    public RespBean deleteAd(@PathVariable Integer id){
        if (adService.deleteAd(id)){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    //商户管理初始化
    @GetMapping("/businesses")
    public ModelAndView business(@RequestParam(value = "title",required = false) String title,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize,
                                 ModelAndView modelAndView){
        modelAndView.addObject("busPage",businessService.selectBusiness(title,pageNum,pageSize));
        modelAndView.setViewName("business");
        return modelAndView;
    }
    //商户管理添加修改初始化
    @GetMapping("/businesses/init")
    public ModelAndView businessInit(@RequestParam("id") Integer id, ModelAndView modelAndView){
        if (id!=null){
            modelAndView.addObject("business",businessService.selectBusiness(id));
            modelAndView.addObject("is",0);
        }else {
            modelAndView.addObject("is",1);
        }
        modelAndView.setViewName("operateBusiness");
        return modelAndView;
    }
    //修改广告
    @PostMapping("/business/modify")
    @ResponseBody
    public boolean updateBusiness(Business business){
        return businessService.updateBusiness(business);
    }
    //添加广告
    @PostMapping("/business/add")
    @ResponseBody
    public boolean insertBusiness(Business business){
        return businessService.insertBusiness(business);
    }
    //删除广告
    @ResponseBody
    @DeleteMapping("/business/remove/{id}")
    public RespBean deleteBusiness(@PathVariable Integer id){
        if (businessService.deleteBusiness(id)){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    //评论查询初始化
    @GetMapping("/comments")
    public ModelAndView comment(@RequestParam(value = "title",required = false) String title,
                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize,
                                ModelAndView modelAndView){
        modelAndView.addObject("comPage",commentService.selectComment(title,pageNum,pageSize));
        modelAndView.setViewName("comment");
        return modelAndView;
    }
    //删除评论
    @ResponseBody
    @DeleteMapping("/comments/remove/{id}")
    public RespBean deleteComment(@PathVariable Integer id){
        if (commentService.deleteComment(id)){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    //订单查询初始化
    @GetMapping("/orders")
    public ModelAndView order(@RequestParam(value = "title",required = false) String title,
                              @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize,
                              ModelAndView modelAndView){
        modelAndView.addObject("ordPage",commentService.selectComment(title,pageNum,pageSize));
        modelAndView.setViewName("orders");
        return modelAndView;
    }
    //订单统计初始化
    @GetMapping("/orderReport")
    public String orderReport(){
        return "orderReport";
    }
    @PostMapping("/orderReportData")
    @ResponseBody
    public List<Map<String,Object>> orderReportData(){
        System.out.println("==========================>"+ordersService.getOrders().get(0));
        return ordersService.getOrders();
    }
    //异步上传
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile, HttpServletRequest request, @RequestParam("act") String act){
        //1、获得上传文件夹的真实路径（是文件在tomcat服务上id的路径）
        String realPath=null;
        if (act.equals("ad")) {
            realPath=request.getSession().getServletContext().getRealPath("/upload/ad/");
        }else if (act.equals("business")){
            realPath=request.getSession().getServletContext().getRealPath("/upload/business/");
        }
        //2、如果上传的文件夹不存在就创建
        File realPathFolder=new File(realPath);
        if(!realPathFolder.exists()){
            realPathFolder.mkdirs();
        }
        //3、上传文件的原始文件名
        String oldName=uploadFile.getOriginalFilename();
        //4、创建新文件名，防止上传的文件同名覆盖之前上传的文件
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            uploadFile.transferTo(new File(realPath,newName));
            //返回资源的路径 http://localhost:8080/
            String filePath=null;
            if (act.equals("ad")) {
                filePath =
                        //request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                        "/upload/ad/" + newName;
            }else if (act.equals("business")){
                filePath =
                        //request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                        "/upload/business/" + newName;
            }
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "<script>alert('上传失败!');";
    }
}
