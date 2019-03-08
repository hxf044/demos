package com.neo.web;

import com.neo.entity.SysPermission;
import com.neo.entity.SysRole;
import com.neo.entity.UserInfo;
import com.neo.sevice.SysPermissionServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@SessionAttributes("user")
public class HomeController {
    @Resource
    private SysPermissionServer SysPermissionServerImpl;
    @RequestMapping({"/","/index"})
    public String index(HttpSession session){
        return "/index";
    }

    /**
     * 获取菜单，树形结构
     * @param session session对象
     * @return 成功返回l数据，否则返回null
     */
     @RequestMapping("/static/list")
     @ResponseBody
     public List<Object> list(HttpSession session){
         UserInfo userInfo =   (UserInfo)session.getAttribute("user");
         List<Object> list = new ArrayList<>();
         list.add(SysPermissionServerImpl.getPermissionTree(userInfo.getUid()));
         return list;
    }
    @RequestMapping("/login")
    public String login( Map<String, Object> map) throws Exception{

        return "/login";
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @param session  session对象
     * @return  成功保存session，然后返回正确的数据，否则不保存session，返回提示信息
     * @throws Exception
     */
    @RequestMapping(value="/submitlogin1",method=RequestMethod.GET)
    @ResponseBody
    public String submitLogin1(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) throws Exception{
        System.out.println("HomeController.login()");
        System.out.println("username=" + username+" passwoed"+ password);
        String msg = "";
        if (username != null || password != null) {
            if (UnknownAccountException.class.getName().equals(username)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(password)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            }else{
                //用户名和密码都对，登录成功，记录session
            }
        }else {
            msg = "else >> "+username+"password";
            System.out.println("else -- >" + username);
        }
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            UserInfo user=(UserInfo) subject.getPrincipal();
            session.setAttribute("user", user);
            return "登录成功";
        } catch(Exception e) {
            return "登录失败";//返回登录页面
        }

    }
    @RequestMapping(value="/submitlogin",method=RequestMethod.GET)
    @ResponseBody
    public String submitLogin(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) throws Exception{
        String msg = "";
//        if (UnknownAccountException.class.getName().equals(username)) {
//            System.out.println("UnknownAccountException -- > 账号不存在：");
//            msg = "UnknownAccountException -- > 账号不存在：";
//        } else if (IncorrectCredentialsException.class.getName().equals(password)) {
//            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//            msg = "IncorrectCredentialsException -- > 密码不正确：";
//        }else{
//            //用户名和密码都对，登录成功，记录session
//        }
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            UserInfo user=(UserInfo) subject.getPrincipal();
            session.setAttribute("user", user);
            System.out.printf("用户信息"+user.toString());
            return "登录成功";
        } catch(Exception e) {
            System.out.printf("错误信息"+e);
            return "登录失败";//返回登录页面
        }
    }
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}