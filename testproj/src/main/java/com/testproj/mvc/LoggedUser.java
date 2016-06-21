package com.testproj.mvc;

import com.testproj.mvc.model.Role;
import com.testproj.mvc.model.User;
import com.testproj.mvc.to.UserTo;
import com.testproj.mvc.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

import static java.util.Objects.requireNonNull;


/**
 * Created by Николай on 21.06.2016.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {
    private UserTo userTo;

    public LoggedUser(User user) {
        super(user.getUserName(), user.getPassword(), user.getRole().asSet());
        this.userTo = UserUtil.fromUser(user);
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int id() {
        return get().userTo.getId();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }
}
