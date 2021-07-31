import org.apache.commons.lang3.StringUtils
import wechaty.{Wechaty, WechatyOptions}

/**
 *
 * @author <a href="mailto:jcai@ganshane.com">Jun Tsai</a>
 * @since 2020-06-02
 */
object DingDongBot {
  def main(args: Array[String]): Unit = {
    val token: String = System.getenv("WECHATY_PUPPET_HOSTIE_TOKEN")
    if (!TokenValidator.isValidToken(token)) {
      throw new Exception("Error: Wrong token format, WECHATY_PUPPET_HOSTIE_TOKEN should be in UUID v4 format!")
    } else {
      System.out.println("token format correct, creating Wechaty instance...")
    }

    val option = new WechatyOptions
    val bot = Wechaty.instance(option)
    bot
      .onScan(payload => {
        println("Scan QR Code to login: %s\nhttps://api.qrserver.com/v1/create-qr-code/?data=%s\n".format(payload.status, payload.qrcode))
      })
      .onLogin(payload => {
        println("User %s logined\n".format(payload.id))
      })
      .onMessage(message => {
        println(message)
        if (message.payload.`type` != wechaty.puppet.schemas.Message.MessageType || message.payload.text != "ding") {
          println("Message discarded because it does not match ding")
        } else {
          message.say("dong")
          println("dong")
        }
      })


    bot.start()

    Thread.currentThread().join()


  }
}

object TokenValidator {

  import java.util.UUID

  def isValidToken(token: String): Boolean = {
    if (StringUtils.isBlank(token)) {
      System.out.println("Error: WECHATY_PUPPET_HOSTIE_TOKEN is not found in the environment variables")
      System.out.println("You need a TOKEN to run the Scala Wechaty. Please goto our README for details")
      System.out.println("https://wechaty.js.org/docs/puppet-services/padlocal/")
      false

    } else {
      try {
        UUID.fromString(token)
        token.length == 36
      } catch {
        case _: IllegalArgumentException =>
          false
      }
    }
  }
}
