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
@Path("/register")
public class UserRegisterController implements PageController {
    UserService mUserService = new UserServiceImpl();



    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            return "register.jsp";
        } else {
            if (StringUtils.equals(password, repeatPassword)) return "密码不一致请重新输入";
        }
        if (mUserService.register(new User(name, password, email, phoneNumber))) {
            return "login-form.jsp";
        }
        return "register.jsp";
    }
}
