package com.myconcurrent.thread.test01;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * redis 分布式锁
 * 
 * @author Administrator
 *
 */
public class RedisTool {

	private RedisManager redisManager = RedisManager.getInstance();
	private Jedis jedis = redisManager.getJedisPool().getResource();
	private static RedisTool redisTool = new RedisTool();

	private static final String LOCK_SUCCESS = "OK";
	private static final String SET_IF_NOT_EXIST = "NX";
	private static final String SET_WITH_EXPIRE_TIME = "PX";

	private static final Long RELEASE_SUCCESS = 1L;

	public static RedisTool getInstance(){
		return redisTool;
	}

	/**
	 * 尝试获取分布式锁
	 * 
	 * @param lockKey    锁
	 * @param requestId  请求标识
	 * @param expireTime 超期时间  ms 毫秒
	 * @return 是否获取成功 
	 */
	public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
		//getJedis();
		String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
		if (LOCK_SUCCESS.equals(result)) {
			return true;
		}
		return false;

	}

	/**
	 * 释放分布式锁, 原子操作
	 * 
	 * @param lockKey
	 * @param requestId
	 * @return
	 */
	public boolean releaseDistributedLock(String lockKey, String requestId) {
		//getJedis();
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
		if (RELEASE_SUCCESS.equals(result)) {
			return true;
		}
		return false;

	}
	
	/**
	 * 获取 流水号
	 * @param lockKey
	 * @return
	 */
	public String getSerialNumber(String lockKey) {
		//getJedis();
		String value = jedis.get(lockKey);
		return value;

	}
	
	/**
	 * 设置 流水号
	 * @param lockKey
	 * @return
	 */
	public String setSerialNumber(String lockKey,String serialNumber) {
		//getJedis();
		String value = jedis.set(lockKey, serialNumber);
		return value;

	}
	

	private void getJedis() {
		if (jedis == null) {
			// jedis = (Jedis)
			// redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
			jedis = redisManager.getJedisPool().getResource();
		}
	}

	
	
	
	
	
	
	
	/**
	 * 释放分布式锁,不是 原子操作
	 * 
	 * @param lockKey   锁
	 * @param requestId 请求标识
	 * @return 是否释放成功
	 */
	private boolean releaseDistributedLock1(String lockKey, String requestId) {
		getJedis();
		if (jedis.get(lockKey).equals(requestId)) {
			System.out.println("释放锁..." + Thread.currentThread().getName() + ",identifierValue:" + requestId);
			jedis.del(lockKey);
			return true;
		}
		return false;
	}

}
