package com.man4fun.game.rpc.core.filter.client;

import com.man4fun.game.rpc.core.common.ChannelFutureWrapper;
import com.man4fun.game.rpc.core.common.RpcInvocation;
import com.man4fun.game.rpc.core.common.utils.CommonUtil;
import com.man4fun.game.rpc.core.filter.ClientFilter;

import java.util.List;

/**
 * @Author peng
 * @Date 2023/3/4
 * @description: ip直连过滤器
 */
public class DirectInvokeFilterImpl implements ClientFilter {

    @Override
    public void doFilter(List<ChannelFutureWrapper> src, RpcInvocation rpcInvocation) {
        String url = (String) rpcInvocation.getAttachments().get("url");
        if (CommonUtil.isEmpty(url)) return;

        src.removeIf(channelFutureWrapper -> !(channelFutureWrapper.getHost() + ":" + channelFutureWrapper.getPort()).equals(url));
        if (CommonUtil.isEmptyList(src)) {
            throw new RuntimeException("no match provider url for " + url);
        }
    }
}
