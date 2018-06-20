package pms.server

import pms.effects._

import io.circe.Json
import org.http4s.circe._
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

final class HelloWorldService[F[_]: Effect] extends Http4sDsl[F] {

  val service: HttpService[F] = {
    HttpService[F] {
      case GET -> Root / "hello" / name =>
        Ok(Json.obj("message" -> Json.fromString(s"PMS says: ${name}")))
    }
  }

}