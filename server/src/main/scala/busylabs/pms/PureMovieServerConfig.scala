package busylabs.pms

import busylabs.config.ConfigLoader
import cats.effect.Sync

/**
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 20 Jun 2018
  *
  */
final case class PureMovieServerConfig(
  port: Int,
  host: String,
  apiRoot: String,
)

object PureMovieServerConfig extends ConfigLoader[PureMovieServerConfig] {
  override def default[F[_]: Sync]: F[PureMovieServerConfig] =
    this.load[F]("busylabs.pms.server")
}