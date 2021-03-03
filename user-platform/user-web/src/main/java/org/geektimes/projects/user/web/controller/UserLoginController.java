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
public class UserLoginController implements PageController {
    UserService mUserService = new UserServiceImpl();



    @GET
    @POST
    @Path("/login")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (StringUtils.isBlank(name)) {
            request.setAttribute("errorMsg", "用户名不能为空");
            return "login-form.jsp";
        }
        if (StringUtils.isBlank(password)) {
            request.setAttribute("errorMsg", "密码不能为空");
            return "login-form.jsp";
        }
        User user = mUserService.queryUserByNameAndPassword(name, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "index.jsp";
        } else {
            request.setAttribute("errorMsg", "账号密码错误");
            return "login-form.jsp";
        }
    }
}
