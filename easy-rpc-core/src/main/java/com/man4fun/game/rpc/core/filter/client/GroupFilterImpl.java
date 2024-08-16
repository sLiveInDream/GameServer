package com.man4fun.game.rpc.core.filter.client;

import com.man4fun.game.rpc.core.common.ChannelFutureWrapper;
import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.common.utils.CommonUtil;
import com.man4fun.game.rpc.core.filter.ClientFilter;

import java.util.List;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: 服务分组的过滤链路
 */
public class GroupFilterImpl implements ClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String group = String.valueOf(rpcInvocation.getAttachments().get("group"));
        src.removeIf(channelFutureWrapper -> !channelFutureWrapper.getGroup().equals(group));
        if (CommonUtil.isEmptyList(src)) {
            throw new RuntimeException("no provider match for group " + group);
        }
    }
}