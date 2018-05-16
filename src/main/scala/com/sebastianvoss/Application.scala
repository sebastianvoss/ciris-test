package com.sebastianvoss

import ciris._
import ciris.Secret
import ciris.refined._
import ciris.enumeratum._
import com.sebastianvoss.AppEnvironment._
import com.sebastianvoss.Config.ApiKey
import com.sebastianvoss.buildinfo.BuildInfo
import eu.timepit.refined.types.net.UserPortNumber
import eu.timepit.refined.auto._

object Application extends App {

  val config =
    withValue(env[AppEnvironment]("APP_ENV")) {

      case Local | Test =>
        loadConfig {
          Config(
            apiKey = Secret("RacrqvWjuu4KVmnTG9b6xyZMTP7jnX"),
            port = 9000
          )
        }

      case Production =>
        loadConfig(
          env[Secret[ApiKey]]("API_KEY").
            orElse(prop("api.key")),
          prop[Option[UserPortNumber]]("http.port")
        ) { (apiKey, port) =>
          Config(
            apiKey,
            port = port getOrElse 4000
          )
        }

    }

  config match {
    case Right(c) =>
      println(c)
      println(BuildInfo)
    case Left(errors) => errors.messages.foreach(println)
  }

}
