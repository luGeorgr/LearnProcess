package www.george.com.netty.chapter4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author rouqiu
 *
 */
public class TimeClient_4_3_1 {
    private void connect(final int port, final String address) throws InterruptedException {
        final EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(final NioSocketChannel nioSocketChannel)
                                throws Exception {
                            nioSocketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            nioSocketChannel.pipeline().addLast(new StringDecoder());
                            nioSocketChannel.pipeline().addLast(new TimeClientHandler_4_3_1());
                        }
                    });
            final ChannelFuture future = bootstrap.connect(address, port).sync();
            future.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        new TimeClient_4_3_1().connect(4545, "127.0.0.1");
    }
}
