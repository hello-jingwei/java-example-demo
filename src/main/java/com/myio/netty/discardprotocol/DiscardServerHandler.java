package com.myio.netty.discardprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 无协议处理器
 * @author wjw
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 通道消息读取
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
//        try {
//            logger.info("reading channel handler msg: {}", msg);
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
    }

    /**
     * 异常抓取
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("channel caught exception: {}", cause.getMessage());
        ctx.close();
    }
}
