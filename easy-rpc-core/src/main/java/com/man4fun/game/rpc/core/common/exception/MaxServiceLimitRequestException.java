package com.man4fun.game.rpc.core.common.exception;

import com.man4fun.game.rpc.core.common.RpcInvocation;

/**
 * @Author peng
 * @Date 2023/3/11
 * @description: 服务端限流异常
 */
public class MaxServiceLimitRequestException extends RpcException{

    public MaxServiceLimitRequestException(RpcInvocation rpcInvocation) {
        super(rpcInvocation);
    }
}
