package com.testproj.mvc.services;

import com.testproj.mvc.generic.ClasesInterface;
import com.testproj.mvc.to.UserTo;

/**
 * Created by Николай on 21.06.2016.
 */
public abstract class AbstractUserService implements ClasesInterface<UserTo> {
   public abstract void update(UserTo userTo, int id);
   public abstract void enable(int id, boolean enabled);
}
