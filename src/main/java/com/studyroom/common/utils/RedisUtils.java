package com.studyroom.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * ================== Key操作 ==================
     */

    /**
     * 设置过期时间
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("设置Redis key过期时间失败: {}", key, e);
            return false;
        }
    }

    /**
     * 获取过期时间
     */
    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire != null ? expire : -1;
    }

    /**
     * 判断key是否存在
     */
    public boolean hasKey(String key) {
        try {
            Boolean hasKey = redisTemplate.hasKey(key);
            return hasKey != null && hasKey;
        } catch (Exception e) {
            log.error("判断Redis key是否存在失败: {}", key, e);
            return false;
        }
    }

    /**
     * 删除key
     */
    public boolean delete(String key) {
        try {
            Boolean deleted = redisTemplate.delete(key);
            return deleted != null && deleted;
        } catch (Exception e) {
            log.error("删除Redis key失败: {}", key, e);
            return false;
        }
    }

    /**
     * 批量删除key
     */
    public long delete(Collection<String> keys) {
        Long deleted = redisTemplate.delete(keys);
        return deleted != null ? deleted : 0;
    }

    /**
     * 匹配删除key（支持通配符）
     */
    public long deleteByPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            return delete(keys);
        }
        return 0;
    }

    /**
     * ================== String操作 ==================
     */

    /**
     * 设置缓存
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置Redis缓存失败: {}", key, e);
            return false;
        }
    }

    /**
     * 设置缓存并指定过期时间
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("设置Redis缓存（带过期时间）失败: {}", key, e);
            return false;
        }
    }

    /**
     * 获取缓存
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存并更新过期时间
     */
    public Object getAndExpire(String key, long time) {
        Object value = get(key);
        if (value != null && time > 0) {
            expire(key, time);
        }
        return value;
    }

    /**
     * 递增
     */
    public long increment(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        Long value = redisTemplate.opsForValue().increment(key, delta);
        return value != null ? value : 0;
    }

    /**
     * 递减
     */
    public long decrement(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        Long value = redisTemplate.opsForValue().decrement(key, delta);
        return value != null ? value : 0;
    }

    /**
     * ================== Hash操作 ==================
     */

    /**
     * 设置Hash
     */
    public boolean hset(String key, String hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            log.error("设置Redis Hash失败: {} - {}", key, hashKey, e);
            return false;
        }
    }

    /**
     * 设置Hash并指定过期时间
     */
    public boolean hset(String key, String hashKey, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("设置Redis Hash（带过期时间）失败: {} - {}", key, hashKey, e);
            return false;
        }
    }

    /**
     * 获取Hash
     */
    public Object hget(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 获取Hash所有键值对
     */
    public Map<Object, Object> hgetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 删除Hash中的键
     */
    public long hdelete(String key, Object... hashKeys) {
        Long deleted = redisTemplate.opsForHash().delete(key, hashKeys);
        return deleted != null ? deleted : 0;
    }

    /**
     * 判断Hash中是否存在键
     */
    public boolean hHasKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * ================== Set操作 ==================
     */

    /**
     * 添加Set
     */
    public long sAdd(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            return count != null ? count : 0;
        } catch (Exception e) {
            log.error("添加Redis Set失败: {}", key, e);
            return 0;
        }
    }

    /**
     * 获取Set所有成员
     */
    public Set<Object> sMembers(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error("获取Redis Set成员失败: {}", key, e);
            return Collections.emptySet();
        }
    }

    /**
     * 判断是否是Set成员
     */
    public boolean sIsMember(String key, Object value) {
        try {
            Boolean isMember = redisTemplate.opsForSet().isMember(key, value);
            return isMember != null && isMember;
        } catch (Exception e) {
            log.error("判断Redis Set成员失败: {}", key, e);
            return false;
        }
    }

    /**
     * 获取Set大小
     */
    public long sSize(String key) {
        try {
            Long size = redisTemplate.opsForSet().size(key);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("获取Redis Set大小失败: {}", key, e);
            return 0;
        }
    }

    /**
     * ================== List操作 ==================
     */

    /**
     * 添加到List头部
     */
    public long lPush(String key, Object value) {
        try {
            Long size = redisTemplate.opsForList().leftPush(key, value);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("添加到Redis List头部失败: {}", key, e);
            return 0;
        }
    }

    /**
     * 添加到List尾部
     */
    public long rPush(String key, Object value) {
        try {
            Long size = redisTemplate.opsForList().rightPush(key, value);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("添加到Redis List尾部失败: {}", key, e);
            return 0;
        }
    }

    /**
     * 获取List范围
     */
    public List<Object> lRange(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.error("获取Redis List范围失败: {}", key, e);
            return Collections.emptyList();
        }
    }

    /**
     * 获取List大小
     */
    public long lSize(String key) {
        try {
            Long size = redisTemplate.opsForList().size(key);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("获取Redis List大小失败: {}", key, e);
            return 0;
        }
    }

    /**
     * ================== ZSet操作 ==================
     */

    /**
     * 添加到ZSet
     */
    public boolean zAdd(String key, Object value, double score) {
        try {
            Boolean added = redisTemplate.opsForZSet().add(key, value, score);
            return added != null && added;
        } catch (Exception e) {
            log.error("添加到Redis ZSet失败: {}", key, e);
            return false;
        }
    }

    /**
     * 获取ZSet范围
     */
    public Set<Object> zRange(String key, long start, long end) {
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            log.error("获取Redis ZSet范围失败: {}", key, e);
            return Collections.emptySet();
        }
    }

    /**
     * 获取ZSet按分数范围
     */
    public Set<ZSetOperations.TypedTuple<Object>> zRangeByScore(String key, double min, double max) {
        try {
            return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
        } catch (Exception e) {
            log.error("获取Redis ZSet按分数范围失败: {}", key, e);
            return Collections.emptySet();
        }
    }

    /**
     * ================== 分布式锁 ==================
     */

    /**
     * 获取分布式锁
     */
    public boolean lock(String key, String value, long expireTime) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
        return success != null && success;
    }

    /**
     * 释放分布式锁
     */
    public boolean unlock(String key, String value) {
        String currentValue = (String) redisTemplate.opsForValue().get(key);
        if (currentValue != null && currentValue.equals(value)) {
            Boolean deleted = redisTemplate.delete(key);
            return deleted != null && deleted;
        }
        return false;
    }

    /**
     * ================== 高级功能 ==================
     */

    /**
     * 批量设置缓存
     */
    public boolean multiSet(Map<String, Object> map) {
        try {
            redisTemplate.opsForValue().multiSet(map);
            return true;
        } catch (Exception e) {
            log.error("批量设置Redis缓存失败", e);
            return false;
        }
    }

    /**
     * 批量获取缓存
     */
    public List<Object> multiGet(Collection<String> keys) {
        try {
            return redisTemplate.opsForValue().multiGet(keys);
        } catch (Exception e) {
            log.error("批量获取Redis缓存失败", e);
            return Collections.emptyList();
        }
    }

    /**
     * 发布消息
     */
    public void publish(String channel, Object message) {
        try {
            redisTemplate.convertAndSend(channel, message);
        } catch (Exception e) {
            log.error("发布Redis消息失败: {}", channel, e);
        }
    }

    /**
     * 获取Redis信息
     */
    public Properties info() {
        try {
            return redisTemplate.getRequiredConnectionFactory().getConnection().info();
        } catch (Exception e) {
            log.error("获取Redis信息失败", e);
            return new Properties();
        }
    }

    /**
     * 清空数据库
     */
    public void flushDb() {
        try {
            redisTemplate.getRequiredConnectionFactory().getConnection().flushDb();
        } catch (Exception e) {
            log.error("清空Redis数据库失败", e);
        }
    }
}