package com.man4fun.game.rpc.core.filter.server;

import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.common.annotations.SPI;
import com.man4fun.game.rpc.core.common.utils.CommonUtil;
import com.man4fun.game.rpc.core.filter.ServerFilter;
import com.man4fun.game.rpc.core.server.ServiceWrapper;

import static com.man4fun.game.rpc.core.common.cache.CommonServerCache.PROVIDER_SERVICE_WRAPPER_MAP;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: 简单版本的token校验
 */
@SPI("before")
public class ServerTokenFilterImpl implements ServerFilter {

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        String token = String.valueOf(rpcInvocation.getAttachments().get("serviceToken"));
        if (!PROVIDER_SERVICE_WRAPPER_MAP.containsKey(rpcInvocation.getTargetServiceName())) {
            return;
        }
        ServiceWrapper serviceWrapper = PROVIDER_SERVICE_WRAPPER_MAP.get(rpcInvocation.getTargetServiceName());
        String matchToken = String.valueOf(serviceWrapper.getServiceToken());
        if (CommonUtil.isEmpty(matchToken)) return;
        if (CommonUtil.isNotEmpty(token) && token.equals(matchToken)) return;
        throw new RuntimeException("token is " + token + " , verify result is false!");
    }
}