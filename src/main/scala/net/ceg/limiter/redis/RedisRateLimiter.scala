package net.ceg.limiter.redis

import net.ceg.limiter.RateLimiter

/**
 * Created by IntelliJ IDEA.
 * User: dth
 * Date: 11/09/11
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */

class RedisRateLimiter extends RateLimiter {
  def isUnderLimit(key: String) = {
    Tuple3(false, 1, 1)
  }
}