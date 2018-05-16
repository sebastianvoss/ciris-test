package com.sebastianvoss

import enumeratum._

sealed trait AppEnvironment extends EnumEntry

object AppEnvironment extends Enum[AppEnvironment] {

  val values = findValues

  case object Local      extends AppEnvironment
  case object Test       extends AppEnvironment
  case object Production extends AppEnvironment

}
