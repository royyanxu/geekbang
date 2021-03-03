package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

/**
 * <class description>
 *
 * @version: 1.0, 2021年03月03日
 */
public class UserServiceImpl implements UserService {
    UserRepository mUserRepository = new DatabaseUserRepository(new DBConnectionManager());



    /**
     * 注册用户
     *
     * @param user 用户对象
     * @return 成功返回<code>true</code>
     */
    @Override
    public boolean register(User user) {
        User oldUser = mUserRepository.getByName(user.getName());
        if (oldUser != null) {
            //用已注册
            return false;
        }
        return mUserRepository.save(user);
    }



    /**
     * 注销用户
     *
     * @param user 用户对象
     * @return 成功返回<code>true</code>
     */
    @Override
    public boolean deregister(User user) {
        return false;
    }



    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return
     */
    @Override
    public boolean update(User user) {
        return false;
    }



    @Override
    public User queryUserById(Long id) {
        return null;
    }



    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return mUserRepository.getByNameAndPassword(name,password);
    }
}
