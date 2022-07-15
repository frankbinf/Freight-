package com.bin.realm;

import com.bin.pojo.User;
import com.bin.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的Realm  完成认证和授权
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
    /**
     * 认证的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        System.out.println("登录表单提交的账号:"+username);
        //完成账号的验证
        User user = userService.authLogin(username);
        if(user == null){
            return null;
        }
        String salt = user.getU1();
        return new SimpleAuthenticationInfo(user,user.getPassword(),new SimpleByteSource(salt),"myRealm");
    }

    /**
     * 授权的方法
     * @param principalCollection
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

}
