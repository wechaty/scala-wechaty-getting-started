import org.apache.commons.lang3.StringUtils
import wechaty.{Wechaty, WechatyOptions}

/**
 *
 * @author <a href="mailto:jcai@ganshane.com">Jun Tsai</a>
 * @since 2020-06-02
 */
object DingDongBot {
  def main(args: Array[String]): Unit = {
    val token: String = sys.props.getOrElse("WECHATY_PUPPET_HOSTIE_TOKEN",
      throw new Exception(s"Error: WECHATY_PUPPET_HOSTIE_TOKEN is not found in the environment variable!" +
        s"You need a TOKEN to run the Scala Wechaty." +
        s"Please goto our README for details https://wechaty.js.org/docs/puppet-services/padlocal/"))
    TokenValidator.isValidToken(token)

    val option = new WechatyOptions

    try {
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


    } catch {
      case _: java.io.FileNotFoundException =>
        System.out.println(s"TOKEN is NOT registered successfully, please refer to https://wechaty.js.org/docs/puppet-services/diy/")
    }

  }
}

object TokenValidator {
  def isValidToken(token: String): Unit = {
    import java.util.regex.Pattern
    val p = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")
    val valid = p.matcher(token).matches()


    if (valid) {
      System.out.println("token format correct, creating Wechaty instance...")
    } else {
      throw new Exception(s"Error: Wrong token format, WECHATY_PUPPET_HOSTIE_TOKEN should be in UUID v4 format!")
    }
  }


}
