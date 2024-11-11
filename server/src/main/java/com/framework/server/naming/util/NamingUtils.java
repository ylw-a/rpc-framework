package com.framework.server.naming.util;

import cn.hutool.core.bean.BeanUtil;
import com.framework.server.naming.exception.ServerException;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.register.RegisterService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
        InstanceServicePo instanceServicePo = new InstanceServicePo();
        BeanUtil.copyProperties(request, instanceServicePo, true);

        // 如果有其他逻辑再往下加
        return instanceServicePo;
    }

    public static void checkInstance(InstanceServicePo instancePo) {
        if (ObjectUtils.isEmpty(instancePo)) {
            throw new ServerException("instancePo is empty");
        }

        // 其他校验
    }

    public static String getGroupName(final String serviceNameWithGroup) {
        if (StringUtils.isEmpty(serviceNameWithGroup)) {
            return "";
        }
        if (!serviceNameWithGroup.contains(NamingConstant.NAME_SEPA)) {
            return NamingConstant.DEFAULT_GROUP;
        }
        return serviceNameWithGroup.split(NamingConstant.NAME_SEPA)[0];
    }

    public static String getServiceName(final String serviceNameWithGroup) {
        if (StringUtils.isEmpty(serviceNameWithGroup)) {
            return "";
        }
        if (!serviceNameWithGroup.contains(NamingConstant.NAME_SEPA)) {
            return serviceNameWithGroup;
        }
        return serviceNameWithGroup.split(NamingConstant.NAME_SEPA)[1];
    }
}
