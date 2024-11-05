package com.framework.server.naming.util;

import com.framework.server.naming.exception.ServerException;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.register.RegisterService;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

public final class NamingUtils {
    private NamingUtils(){}

    public static void checkServiceName(String serviceName) {
        String name = Optional.ofNullable(serviceName).orElse("");
        String[] split = name.split(NamingConstant.NAME_SEPA);
        if (split.length <= 1) {
            throw new ServerException("service name format error, 需要形如groupName@@serviceName的组合");
        }
        if (ObjectUtils.isEmpty(split[0]) || ObjectUtils.isEmpty(split[1])) {
            throw new ServerException("service name format error, groupName or serviceName is empty");
        }
    }

    public static InstanceServicePo convertInstancePo(RegisterService.RegisterRequest request) {
        // todo 待实现
        return new InstanceServicePo();
    }
}
