package com.man4fun.game.rpc.core.filter.server;

import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.common.annotations.SPI;
import com.man4fun.game.rpc.core.filter.ServerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: 服务端日志过滤器
 */
@SPI("before")
public class ServerLogFilterImpl implements ServerFilter {

    private final Logger logger = LoggerFactory.getLogger(ServerLogFilterImpl.class);

    @Override
    public void doFilter(RpcInvocation rpcInvocation) {
        logger.info(rpcInvocation.getAttachments().get("c_app_name") + " do invoke -----> " +
                rpcInvocation.getTargetServiceName() + "#" + rpcInvocation.getTargetMethod());
    }
}
