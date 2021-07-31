# scala-wechaty-getting-started

![Scala Wechaty](https://wechaty.github.io/scala-wechaty-getting-started/images/scala-wechaty.png)

[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/wechaty/scala-wechaty-getting-started)
[![Wechaty in Scala](https://img.shields.io/badge/Wechaty-Scala-890)](https://github.com/wechaty/scala-wechaty)

Scala Wechaty Starter Project Template that Works Out-of-the-Box

## Connecting Chatbots

[![Powered by Wechaty](https://img.shields.io/badge/Powered%20By-Wechaty-brightgreen.svg)](https://github.com/Wechaty/wechaty)

Wechaty is a RPA SDK for Wechat **Individual** Account that can help you create a chatbot in 6 lines of Scala.

## Requirements

1. sbt
   https://www.scala-sbt.org/1.x/docs/Setup.html
2. Scala 2.12.x
   https://www.scala-lang.org/download/scala2.html

## Quick Start

1. Clone scala-wechaty-getting-started repository

   ```shell
   git clone https://github.com/wechaty/scala-wechaty-getting-started
   cd scala-wechaty-getting-started
   ```

2. Install Dependencies

   ```shell
   make install
   ```

4. Set token and Run the bot

   ```shell
   make bot
   # Make sure you are in the sbt console
   # It must be hostie token
   eval System.setProperty("WECHATY_PUPPET_HOSTIE_TOKEN", "your_token_at_here")
   run
   ```

## The World's Shortest Scala ChatBot: 6 lines of Code

```scala
package wechaty

object DingDongBot {
  def main(args: Array[String]): Unit = {
    Wechaty.instance()
      .onScan(payload     => { println("Scan QR Code to login: %s\nhttps://api.qrserver.com/v1/create-qr-code/?data=%s\n".format(payload.status, payload.qrcode)) })
      .onLogin(payload    => { println("User %s logined\n".format(payload.id)) })
      .onMessage(message  => { println(message) })
      .start()
    Thread.currentThread().join()
  }
}
```

## Wechaty Getting Started in Multiple Languages

- [TypeScript Wechaty Getting Started](https://github.com/wechaty/wechaty-getting-started)
- [Python Wechaty Getting Started](https://github.com/wechaty/python-wechaty-getting-started)
- [Java Wechaty Getting Started](https://github.com/wechaty/java-wechaty-getting-started)
- [Go Wechaty Getting Started](https://github.com/wechaty/go-wechaty-getting-started)
- [Scala Wechaty Getting Started](https://github.com/wechaty/scala-wechaty-getting-started)


## Badge

[![Wechaty in Scala](https://img.shields.io/badge/Wechaty-Scala-890)](https://github.com/wechaty/scala-wechaty)

```md
[![Wechaty in Scala](https://img.shields.io/badge/Wechaty-Scala-890)](https://github.com/wechaty/scala-wechaty)
```

## Maintainers

[@wechaty/scala](https://github.com/orgs/wechaty/teams/scala/members)

## Copyright & License

- Code & Docs © 2020 Wechaty Contributors <https://github.com/wechaty>
- Code released under the Apache-2.0 License
- Docs released under Creative Commons
