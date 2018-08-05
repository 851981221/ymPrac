package com.ymPrac.netty.demo;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by Yan Meng on 2016/9/24.
 */
public class HelloClientHandler extends SimpleChannelHandler {

    /**
     * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println("Hello world, I'm client.");

    }

}
