import sbt._

/**
 */
class RateLimiterProject(info: ProjectInfo) extends DefaultProject(info) {
  val servlet_api = "javax.servlet" % "servlet-api" % "2.5"
}