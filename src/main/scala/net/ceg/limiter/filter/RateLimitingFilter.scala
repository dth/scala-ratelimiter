package net.ceg.limiter.filter

import javax.servlet._
import http.{HttpServletRequest, HttpServletResponse}
import net.ceg.limiter.{SimpleRateLimiter, RateLimiter}

/**
 */
class RateLimitingFilter extends Filter {

  var limiter = null: RateLimiter

  def init(config: FilterConfig) {
    limiter = new SimpleRateLimiter
  }

  def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {

    val key = extractKey(request)
    val t = limiter.isUnderLimit(key)
    response.asInstanceOf[HttpServletResponse].setHeader("X-RateLimit", t._2.toString)
    response.asInstanceOf[HttpServletResponse].setHeader("X-RateCount", t._3.toString)

    if (t._1) {
      chain.doFilter(request, response)
    } else {
      response.asInstanceOf[HttpServletResponse].setStatus(HttpServletResponse.SC_FORBIDDEN)
    }
  }

  def destroy() {}

  def extractKey(request: ServletRequest): String = {
    "foo"
  }
}