package com.example.book_crud.config.talent;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 管理当前租户的ID
 *
 * @author yangtao3@shein.com
 * @date 2023/1/28 5:32 PM
 */

@Component
public class TenantIdManager{
    /** 当前用户租户 KEY */
    private static final String KEY_CURRENT_TENANT_ID = "KEY_CURRENT_PROVIDER_ID";
    /** 保存当前租户ID */
    private static final Map<String, Object> TENANT_MAP = new ConcurrentHashMap<>();

    /**
     * 设置租户- 这里的使用场景一般是用户登陆时候设置cache,特殊场景例外。其实还缺少一个充值的方法，用户登出的话，重置tenantId
     * @param tenantId 租户ID
     */
    public void setCurrentTenantId(Long tenantId) {
        TENANT_MAP.put(KEY_CURRENT_TENANT_ID, tenantId);
    }

    /**
     * 返回当前用户租户ID
     * @return
     */
    public Long getCurrentTenantId() {
        return (Long) TENANT_MAP.get(KEY_CURRENT_TENANT_ID);
    }

}
