package com.man4fun.game.rpc.core.filter.server;

import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.common.ServerServiceSemaphoreWrapper;
import com.man4fun.game.rpc.core.common.annotations.SPI;
import com.man4fun.game.rpc.core.filter.ServerFilter;

import static com.man4fun.game.rpc.core.common.cache.CommonServerCache.SERVER_SERVICE_SEMAPHORE_MAP;

/**
 * @Author peng
 * @Date 2023/3/11
 * @description: 服务端用于释放semaphore对象
 */
@SPI("after")
public class ServerServiceAfterLimitFilterImpl implements ServerFilter {

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        String serviceName = rpcInvocation.getTargetServiceName();
        if (!SERVER_SERVICE_SEMAPHORE_MAP.containsKey(serviceName)) {
            return;
        }
        ServerServiceSemaphoreWrapper serverServiceSemaphoreWrapper = SERVER_SERVICE_SEMAPHORE_MAP.get(serviceName);
        serverServiceSemaphoreWrapper.getSemaphore().release();
    }
}
