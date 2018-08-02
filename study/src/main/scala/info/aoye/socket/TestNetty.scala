package info.aoye.socket

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel // NioSocket

object TestNetty extends scala.App {
  val parentGroup = new NioEventLoopGroup()
  val childGroup = new NioEventLoopGroup()

  //启动程序
  val b = new ServerBootstrap()
    .group(parentGroup, childGroup)//设置组
    .channel(classOf[NioServerSocketChannel])//设置通道
    .option(ChannelOption.SO_BACKLOG, new Integer(1024))//设置选项
//    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
//    .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
//    .childOption(ChannelOption.AUTO_READ, Boolean.TRUE)
//    .childHandler(new Socks5ClientInitializer(acceptorEventLoopGroup, workerEventLoopGroup, socks5Config))
}
