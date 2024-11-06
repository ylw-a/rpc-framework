package com.framework.server.naming.pojo;

import com.framework.server.naming.config.ServerInstanceProperties;
import com.framework.server.naming.util.AppContextUtil;
import com.framework.server.naming.util.NamingConstant;
import lombok.Data;

/**
 * 服务注册实体类
 * todo 待实现
 */
@Data
public class InstanceServicePo {
    // ip地址
    private String ip;

    // 接口
    private int port;

    // 命名空间
    private String namespaceId;

    // 权重
    private int weight;

    // 是否上线
    private boolean enabled;

    // 是否健康
    private boolean healthy;

    // 扩展信息
    private String metadata;

    // 集群名称
    private String clusterName;

    // 服务名称
    private String serviceName;

    // 分组名称
    private String groupName;

    // 是否临时实例
    private boolean ephemeral;

    // 超时时间
    private long timeout;

    private String clientId;

    private String address;

    public long getTimeout() {
        if (timeout <= 0) {
            timeout = AppContextUtil.getBean(ServerInstanceProperties.class).getTimeout();
        }
        return timeout;
    }

    private void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getClientId() {
        return getAddress() + NamingConstant.ID_DELIMITER + isEphemeral();
    }

    public String getAddress() {
        return ip + ":" + port;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
