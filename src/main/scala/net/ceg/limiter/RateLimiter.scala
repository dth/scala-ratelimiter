package net.ceg.limiter

/**
 * @author dth
 */
trait RateLimiter {
  /**
   * Returns a Tuple3 containing:
   * Whether the request is under limit
   * The current count
   * The current limit
   */
  def isUnderLimit(key: String): Tuple3[Boolean, Int, Int]
}