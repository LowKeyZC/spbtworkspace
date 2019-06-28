package com.zc.redisstu;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.*;

public class JedisStu {
    public static void main(String[] args) throws InterruptedException {
        commandstu();
    }

    public static void commondStu2() {
        Jedis jedis = new Jedis("localhost",6379);
        Long startTm = System.currentTimeMillis();
        /*jedis.zadd("200000rank",56.77777,"aaa");
        jedis.zadd("200000rank",57.77777,"bbb");
        jedis.zadd("200000rank",58.77777,"ccc");
        jedis.zrem("200000rank", "aaa","bbb","ccc");*/
        jedis.del("200000rank");
        Set<String> zsetKeys = jedis.zrange("200000rank", 0, -1);
        Long endTm = System.currentTimeMillis();
        System.out.println(zsetKeys);
    }

    /**
     * 原始连接方式
     */
    public static void StringTest() throws InterruptedException {
        Jedis jedis = new Jedis("localhost",6379);
        System.out.println("==============String==============");
        System.out.println("新增键值:"+jedis.set("aaa","123"));
        System.out.println("新增键值:"+jedis.set("bbb","456"));
        System.out.println("删除键aaa:"+jedis.del("aaa"));
        System.out.println("获取键aaa:"+jedis.get("aaa"));
        System.out.println("修改键bbb:"+jedis.set("bbb","654"));
        System.out.println("获取键bbb:"+jedis.get("bbb"));
        System.out.println("续加键bbb:"+jedis.append("bbb","999"));
        System.out.println("获取键bbb:"+jedis.get("bbb"));
        System.out.println("增多键值对:"+jedis.mset("ccc","111","ddd","222"));
        System.out.println("获多键值对:"+jedis.mget("ccc","ddd"));
        System.out.println("删多键值对:"+jedis.del("ccc","ddd"));
        System.out.println("获多键值对:"+jedis.mget("ccc","ddd"));
        jedis.flushDB();
        System.out.println("新增键eee:"+jedis.setnx("eee","777"));
        System.out.println("新增键eee:"+jedis.setnx("eee","888"));
        System.out.println("获取键eee:"+jedis.get("eee"));
        System.out.println("新增键eee:"+jedis.setex("eee",2,"777"));
        System.out.println("获取键eee:"+jedis.get("eee"));
        Thread.sleep(3000);
        System.out.println("获取键eee:"+jedis.get("eee"));
    }

    public void ListTest(){
        Jedis jedis = new Jedis("localhost",6379);
        System.out.println("==============List==============");
        jedis.lpush("collection","111","222","333");
        jedis.lpush("collection","hashset");
        System.out.println(jedis.lrange("collection",0,-1));
        jedis.lrem("collection",2,"111");
        System.out.println(jedis.lrange("collection",0,-1));
        jedis.lpush("sortedList","3","6","2","0","7","4");
        SortingParams sortingParameters = new SortingParams();
        System.out.println("排序前："+jedis.lrange("sortedList",0,-1));
        System.out.println("升序："+jedis.sort("sortedList",sortingParameters.asc()));
    }

    /**
     * 简单方式连接，线程不安全
     */
    public static void fun01(){
        Jedis jedis = new Jedis("localhost",6379);
//        jedis.setex("xiaohu", user);
    }

    /**
     * 连接池连接方式，线程安全
     */
    public static void delPrefix(String prefix){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.set("pooledJedis123", "hello jedis pool!");
            jedis.set("pooledJedis456", "hhhhhh");
            Set<String> set = jedis.keys("pooledJedis" + "*");
            for (String keyStr : set) {
                System.out.println(keyStr);
                jedis.del(keyStr);
            }
            set = jedis.keys("pooledJedis" + "*");
            System.out.println("redis中存在以pooledJedis开头的键" + set.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //还回pool中
        pool.close();
    }

    public static void commandstu() throws InterruptedException {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.flushAll();
//        jedis.set("hello",String.valueOf(3));
//        System.out.println(jedis.get("hello"));
//        jedis.incr("hello");
//        System.out.println(jedis.get("hello"));
//        jedis.decr("hello");
//        System.out.println(jedis.get("hello"));
//        jedis.incrBy("hello",5);
//        System.out.println(jedis.get("hello"));
//        jedis.decrBy("hello",2);
//        System.out.println(jedis.get("hello"));
//        jedis.incrByFloat("hello",0.5);
//        System.out.println(jedis.get("hello"));
//        jedis.set("hello","world");
//        System.out.println(jedis.get("hello"));
//        jedis.append("hello","apd");
//        System.out.println(jedis.get("hello"));
//        System.out.println(jedis.getrange("hello",0,2));
//        jedis.setrange("hello",0,"aaa");
//        System.out.println(jedis.get("hello"));
//        System.out.println(jedis.getbit("hello",1));
//        jedis.lpush("list-key","last");
//        System.out.println(jedis.lrange("list-key",0,-1));
//        jedis.rpush("list-key","a","b","c");
//        System.out.println(jedis.lrange("list-key",0,-1));
//        jedis.ltrim("list-key",2,-1);
//        System.out.println(jedis.lrange("list-key",0,-1));
//        jedis.rpoplpush("list-key","list-key2");
//        System.out.println(jedis.lrange("list-key",0,-1));
//        System.out.println(jedis.lrange("list-key2",0,-1));
//        System.out.println(jedis.lrange("list-key",0,-1));
//        jedis.brpoplpush("list-key3","list-key",10);
//        System.out.println(jedis.lrange("list-key",0,-1));
//        jedis.sadd("set-key","a","b","c");
//        System.out.println(jedis.smembers("set-key"));
//        System.out.println("移除元素 " + jedis.srem("set-key","a"));
//        System.out.println(jedis.smembers("set-key"));
//        System.out.println(jedis.scard("set-key"));
//        System.out.println(jedis.srandmember("set-key",2));
//        System.out.println(jedis.spop("set-key"));
//        System.out.println(jedis.smove("set-key","set-key1","c"));
//        System.out.println(jedis.smembers("set-key1"));
//        jedis.flushAll();
//        System.out.println(jedis.smembers("set-key"));
//        jedis.sadd("set-key","a","b","c");
//        jedis.sadd("set-key2","b","c","d");
//        jedis.sadd("set-key3","c","d","e");
//        System.out.println(jedis.sdiff("set-key","set-key2","set-key3"));
//        jedis.sdiffstore("set-key4","set-key","set-key2","set-key3");
//        jedis.smembers("set-key4");
//        System.out.println(jedis.sinter("set-key","set-key2","set-key3"));
//        Map<String,String> map = new HashMap<>();
//        map.put("apple","111");
//        map.put("pair","222");
//        jedis.hmset("hmset-key",map);
//        System.out.println(jedis.hmget("hmset-key","apple"));
//        System.out.println(jedis.hdel("hmset-key","pair"));
//        System.out.println(jedis.hlen("hmset-key"));
//        System.out.println(jedis.hexists("hmset-key","apple"));
//        System.out.println(jedis.hexists("hmset-key","banana"));
//        System.out.println(jedis.hkeys("hmset-key"));
//        System.out.println(jedis.hvals("hmset-key"));
//        System.out.println(jedis.hgetAll("hmset-key"));
//        System.out.println(jedis.hincrBy("hmset-key","apple",3));
//        System.out.println(jedis.hincrByFloat("hmset-key","pair",0.5));
        jedis.zadd("z-key",11,"scoreA");
        jedis.zadd("z-key",23,"scoreB");
        jedis.zadd("z-key",34,"scoreC");
        jedis.zadd("z-key",49,"scoreD");
        Long zrank = jedis.zrank("z-key","scoreB");
        Long zReRank = jedis.zrevrank("z-key", "scoreB");
        System.out.println("理论排名："+3);
        System.out.println("zrank排名"+zrank);
        System.out.println("YH排名"+(4-zrank));
        System.out.println("zReRank"+zReRank);
//        System.out.println(jedis.zrem("z-key","scoreC"));
//        System.out.println(jedis.zcard("z-key"));
//        System.out.println(jedis.zincrby("z-key",5,"scoreA"));
//        System.out.println(jedis.zcount("z-key",1,3));
//        System.out.println(jedis.zrank("z-key","scoreA"));
//        System.out.println(jedis.zscore("z-key","scoreB"));
//        System.out.println(jedis.zrevrange("z-key",1,2));
//        jedis.sadd("s-key","5","2","3","4","1");
//        System.out.println(jedis.sort("s-key"));
//        Transaction transaction = jedis.multi();
//        transaction.exec();
//        jedis.set("hello","world");
//        jedis.expire("hello",10);
//        jedis.persist("hello");
//        Thread.sleep(4000);
//        System.out.println(jedis.ttl("hello"));
//        System.out.println(jedis.get("hello"));
//        Thread.sleep(7000);
//        System.out.println(jedis.get("hello"));
        jedis.close();
    }
}
