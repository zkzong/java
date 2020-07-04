package com.zkzong.sb.security2.core.security;

import com.zkzong.sb.security2.sysmanager.entity.AclResources;
import com.zkzong.sb.security2.sysmanager.service.AclResourcesService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/5/31.
 */
@Component("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static Map<String, Collection<ConfigAttribute>> aclResourceMap = null;
    private AclResourcesService aclResourcesService;

    public MySecurityMetadataSource(AclResourcesService aclResourcesService) {
        this.aclResourcesService = aclResourcesService;
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        List<AclResources> aclResourceses = aclResourcesService.selectAclResourcesTypeOfRequest();
        aclResourceMap = new HashMap<>();
        for (AclResources aclResources : aclResourceses) {
            ConfigAttribute ca = new SecurityConfig(aclResources.getAuthority().toUpperCase());
            String url = aclResources.getUrl();
            if (aclResourceMap.containsKey(url)) {
                Collection<ConfigAttribute> value = aclResourceMap.get(url);
                value.add(ca);
                aclResourceMap.put(url, value);
            } else {
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                atts.add(ca);
                aclResourceMap.put(url, atts);
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Iterator<String> iter = aclResourceMap.keySet().iterator();
        while (iter.hasNext()) {
            String resURL = iter.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if (requestMatcher.matches(request)) {
                return aclResourceMap.get(resURL);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        System.out.println("metadata : getAllConfigAttributes");
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("metadata : supports");
        return true;
    }
}
