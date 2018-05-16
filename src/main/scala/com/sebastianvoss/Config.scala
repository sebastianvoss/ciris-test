package com.sebastianvoss

import ciris.Secret
import com.sebastianvoss.Config.ApiKey
import eu.timepit.refined.api.Refined
import eu.timepit.refined.string.MatchesRegex
import eu.timepit.refined.types.net.UserPortNumber
import eu.timepit.refined.W

object Config {
  type ApiKey = String Refined MatchesRegex[W.`"[a-zA-Z0-9]{25,40}"`.T]
}

case class Config(apiKey: Secret[ApiKey], port: UserPortNumber)
