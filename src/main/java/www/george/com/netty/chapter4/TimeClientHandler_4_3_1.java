package www.george.com.netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author rouqiu
 *
 */
public class TimeClientHandler_4_3_1 extends ChannelInboundHandlerAdapter {
    private int counter = 0;
    private byte[] req;

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause)
            throws Exception {
        System.err.println(cause.toString());
        ctx.close();
    }

    public TimeClientHandler_4_3_1() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is: " + body + " ; the counter is " + ++counter);
    }
}
