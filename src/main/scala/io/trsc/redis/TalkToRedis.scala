package io.trsc.redis

import java.net.InetSocketAddress

import akka.actor.ActorSystem
import akka.stream.FlowMaterializer
import akka.stream.io.StreamTcp
import akka.stream.scaladsl._
import akka.util.ByteString

import scala.language.postfixOps
import scala.util.Try

object TalkToRedis extends App {

  implicit val system = ActorSystem("talk-to-redis")
  implicit val materializer = FlowMaterializer()

  val (host, port) = Try(args(0) -> args(1).toInt).toOption.getOrElse("localhost" -> 6379)

  val source = Source { () =>
    scala.io.Source.stdin.getLines()
  } map {
    _.replaceAll("\\s", "\r\n") + "\r\n"
  } map {
    ByteString(_)
  } via StreamTcp().outgoingConnection(new InetSocketAddress(host, port)).flow

  source runWith ForeachSink { response =>
    println(response.utf8String)
  }

}
