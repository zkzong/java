package com.zkzong.sb.security2.core.security;

import com.zkzong.sb.security2.sysmanager.entity.AclResources;
import com.zkzong.sb.security2.sysmanager.entity.AclUser;
import com.zkzong.sb.security2.sysmanager.service.AclResourcesService;
import com.zkzong.sb.security2.sysmanager.service.AclRoleResourcesService;
import com.zkzong.sb.security2.sysmanager.service.AclUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2017/5/31.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private AclUserService aclUserService;
    @Resource
    private AclRoleResourcesService aclRoleResourcesService;
    @Resource
    private AclResourcesService aclResourcesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        AclUser aclUser = aclUserService.findAclUserByName(username);
        String resourceIds = aclRoleResourcesService.selectResourceIdsByRoleIds(aclUser.getRoleIds());
        List<AclResources> aclResourcesList = aclResourcesService.selectAclResourcesByResourceIds(resourceIds);
        for (AclResources aclResources : aclResourcesList) {
            auths.add(new SimpleGrantedAuthority(aclResources.getAuthority().toUpperCase()));
        }
//        auths.addAll(aclResourcesList.stream().map(resources -> new SimpleGrantedAuthority(resources.getAuthority().toUpperCase())).collect(Collectors.toList()));
        return new User(aclUser.getUserName().toLowerCase(), aclUser.getUserPwd().toLowerCase(), true, true, true, true, auths);
    }
}
