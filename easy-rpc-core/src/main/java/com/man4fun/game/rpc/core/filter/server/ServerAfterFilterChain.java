package com.man4fun.game.rpc.core.filter.server;

import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.filter.ServerFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author peng
 * @Date 2023/3/11
 * @description: 服务端模块的后置过滤链设计
 */
public class ServerAfterFilterChain {

    private static List<ServerFilter> serverFilters = new ArrayList<>();

    public void addServerFilter(ServerFilter iServerFilter) {
        serverFilters.add(iServerFilter);
    }

    public void doFilter(RpcInvocation rpcInvocation) {
        for (ServerFilter serverFilter : serverFilters) {
            serverFilter.doFilter(rpcInvocation);
        }
    }
}
