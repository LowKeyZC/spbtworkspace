package com.zc.redisstu;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class JedisStu2 {

    private static JedisPool pool = new JedisPool("localhost", 6379);

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = pool.getResource();
        jedis.slaveofNoOne();
    }

    /**
     * 位图
     */
    private static void bitStu() {
        Jedis jedis = pool.getResource();
        String bitkey = "bitkey";
        jedis.del(bitkey);
        jedis.setbit(bitkey, 2, true);
        System.out.println(jedis.getbit(bitkey,2));
        System.out.println(jedis.bitcount(bitkey));
        System.out.println(jedis.bitcount(bitkey,4,6));
        System.out.println(jedis.bitpos(bitkey,true));
        System.out.println(jedis.bitpos(bitkey, false, new BitPosParams(0, 3)));
        //todo 如何以字符形式返回位图
    }

    /**
     * todo 布隆过滤器
     */

    /**
     * 管道--打包发送命令，效率高
     */
    private static void pipelinedStu() {
        Jedis jedis = pool.getResource();
        Pipeline pip = jedis.pipelined();
        pip.multi();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            pip.set(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
        pip.sync();// 同步获取所有的回应

        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            jedis.set(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    /* 性能测试 */
    /* redis-benchmark [option] [option value] */

    /**
     * configGet
     * configSet
     */
    private static void configStu() {
        Jedis jedis = pool.getResource();
        List<String> result = jedis.configGet("dir");
        List<String> result1 = jedis.configGet("requirepass");
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(result1));
    }

    /**
     * 在redis安装目录生成rdb文件，保持当前数据库备份
     * bgsave redis将fork一个子进程处理备份
     * 数据恢复：将rdb文件拷贝到redis安装目录，重启
     */
    private static void saveStu() throws InterruptedException {
        Jedis jedis = pool.getResource();
        // String result = jedis.save();
        String result2 = jedis.bgsave();
        System.out.println(result2 + new Date());
        TimeUnit.SECONDS.sleep(5);
        Long result3 = jedis.lastsave();
        System.out.println(new Date(result3));
    }

    /**
     * info
     */
    private static void infoStu() throws InterruptedException {
        Jedis jedis = pool.getResource();
        Jedis jedis2 = pool.getResource();
        jedis2.quit();
        System.out.println(jedis.info());
        // 缓一下，让jedis2完全退出
        Thread.sleep(200);
        System.out.println(jedis.info());
    }

    /**
     * 事务
     * watch 监视一个(或多个) key ，如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断。
     *
     */
    private static void transactionStu() {
        Jedis jedis = pool.getResource();
        jedis.watch("aaa", "bbb");
        Jedis jedis2 = pool.getResource();
        Transaction transaction = jedis.multi();
        transaction.set("aaa", "123");
        // jedis2.set("aaa", "321");
        transaction.set("bbb", "456");
        List<Object> re = transaction.exec();
        System.out.println(JSON.toJSONString(re));
        jedis.unwatch();
    }

    /**
     * HyperLogLog 统计专用 估计值
     * 好处：节省空间 每个key 12kb
     */
    private static void hyperLogLogStu() {
        Jedis jedis = pool.getResource();
        String hyperKey = "hyperKey";
        String hyperKey2 = "hyperKey2";
        String hyperKey3 = "hyperKey3";
        jedis.del(hyperKey, hyperKey2, hyperKey3);
        for (int i = 0; i < 10000; i++) {
            jedis.pfadd(hyperKey, String.valueOf(i));
        }
        for (int i = 10000; i < 20000; i++) {
            jedis.pfadd(hyperKey2, String.valueOf(i));
        }
        jedis.pfmerge(hyperKey3, hyperKey, hyperKey2);
        System.out.println(jedis.pfcount(hyperKey3));
    }

    /**
     * 发布订阅
     * jedis发布订阅不能使用同一连接
     */
    private static void pubSubStu() throws InterruptedException {
        //频道
        String channel = "mychannel";
        Jedis jedis = pool.getResource();
        //jedis客户端订阅频道
        Subscriber subscriber = new Subscriber();
        Thread t = new Thread(() -> jedis.subscribe(subscriber, channel));
        t.start();
        Thread.sleep(1000);
        Jedis jedis2 = pool.getResource();
        //jedis2客户端发布消息
        for (int i = 0; i < 3; i++) {
            jedis2.publish(channel, "message" + i);
        }
        subscriber.unsubscribe(channel);
    }


}

class Subscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {       //收到消息会调用
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //订阅了频道会调用
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消订阅 会调用
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }
}
