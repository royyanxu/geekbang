package org.geektimes.projects.user.web.controller;

import org.apache.commons.lang.StringUtils;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/user")
public class UserRegisterController implements PageController {
    UserService mUserService = new UserServiceImpl();



    @GET
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        if (StringUtils.isBlank(name)) return "用户名不能为空";
        if (StringUtils.isBlank(password)) return "密码不能为空";
        if (StringUtils.isBlank(email)) return "电子邮箱不能为空";
        if (StringUtils.isBlank(phoneNumber)) return "手机号不能为空";
        if (mUserService.register(new User(name, password, email, phoneNumber))) {
            return "login-form.jsp";
        }
        return "register.jsp";
    }
}
