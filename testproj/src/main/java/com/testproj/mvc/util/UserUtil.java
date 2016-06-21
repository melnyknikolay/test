package com.testproj.mvc.util;

import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 19.06.2016.
 */
public class UserUtil {
    public static User createFromUserTo(UserTo userTo){
        if (userTo != null) {
            return new User(null, userTo.getUserName(), userTo.getPassword(), userTo.getIsActive(), new Role(null, userTo.getRole()));
        }else return null;
    }

    public static User updateFromUserTo(UserTo userTo){
        if (userTo != null) {
            return new User(userTo.getId(), userTo.getUserName(), userTo.getPassword(), userTo.getIsActive(), new Role(null, userTo.getRole()));
        }else return null;
    }

    public static UserTo fromUser(User user){
        if (user != null){
            return new UserTo(user.getId(), user.getUserName(), user.getPassword(), user.getIsActive(), user.getRole().getName());
        }else return null;
    }

    public static List<UserTo> list(List<User> users){
        if (users.isEmpty())return new ArrayList<UserTo>();

        List<UserTo> list = new ArrayList<UserTo>();
        for (User user: users){
            list.add(UserUtil.fromUser(user));
        }
        return list;
    }

    public static UserTo prepareToSave(UserTo userTo) {
        userTo.setPassword(PasswordUtil.encode(userTo.getPassword()));
        return userTo;
    }
}
