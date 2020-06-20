package www.george.com.netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author rouqiu
 *
 */
public class TimeServerHandler_4_3_1 extends ChannelInboundHandlerAdapter {
    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final String body = (String) msg;
        System.out.println("The time server receive order: " + body + " ; the counter is :" + ++counter);
//        final String currentTime = ("QUERY TIME ORDER".equalsIgnoreCase(body) ?
//                new Date(System.currentTimeMillis()).toString() : "Bad Request") + System.getProperty("line.separator");
        final String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                new Date(System.currentTimeMillis()).toString() : "Bad Request";
        final ByteBuf response = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause)
            throws Exception {
        ctx.close();
    }


}
