package net.ceg.limiter

/**
 * @author dth
 */
class SimpleRateLimiter extends RateLimiter {

  var count = 0
  val limit = 10

  def isUnderLimit(key: String) = {
    count += 1
    Tuple3(count < 10, count, limit)
  }

  def rateLimit(key: String) = 10
  def rateCount(key: String) = count
}