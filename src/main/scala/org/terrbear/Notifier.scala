package org.terrbear

import dispatch._, Defaults._

import scala.collection.JavaConverters._

import com.amazonaws.services.lambda.runtime.Context

object Natertot {
  def main(args: Array[String]): Unit = {
    val notifier = new Notifier
    val answer = notifier.notify(notifier.YES_PLZ)
    println(answer())
  }
}

class Notifier {
  val PUSHOVER_KEY = "your-pushover-key"
  val PUSHOVER_APP_KEY = "your-pushover-app-key"
  val YES_PLZ = "Can you please get J out of bed?"

  def lambda(input: java.io.InputStream, context: Context) : String = {
    val logger = context.getLogger
    logger.log("got a click!")
    logger.log(notify(YES_PLZ)())
    "all done"
  }

  def notify(msg: String): Future[String] = {
    val request = url("https://api.pushover.net/1/messages.json").POST << Map("token" -> PUSHOVER_APP_KEY, "user" -> PUSHOVER_KEY, "message" -> msg)
    Http(request OK as.String)
  }
}
