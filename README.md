### wjhemall
linux指令：
/usr/local/nginx/sbin/nginx ---》打开nginx

service  iptables stop  ---》关防火墙

redis-server redis.conf   ---》启动redis服务

 redis-cli -h 192.168.146.134 -p 6379 ---》连接客户端
 redis-cli shutdown

ElasticSearch  ::
vi elasticsearch.yml----network.host: 192.168.146.134   port: 9200

//######wjhemall-user:8080

wjhemall-user-service:8070
wjhemall-user-web:8080

wjhemall-manage-service:8071
wjhemall-manage-web:8081

//######wjhemall-item-service:8072 
wjhemall-item-web:8082

wjhemall-search-service:8073
wjhemall-search-web:8083

wjhemall-cart-service:8074
wjhemall-cart-web:8084
###面向服务的好处(service controller拆开) 可以后期组合实现一个模块

##缓存穿透--Redis分布式锁：
①redis自带set ex nx
②redisson框架(redis的带有juc的lock功能的客户端实现)






配置文件ip地址可能更改相关：！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
vim /etc/fdfs/storage.conf   改trackerServer为虚拟机IP+端口

vim /etc/fdfs/client.conf    tracker_server=192.168.67.163:22122

vim /etc/fdfs/mod_fastdfs.conf tracker_server=192.168.67.163:22122

vim /usr/local/nginx/conf/nginx.conf      改ServerName为虚拟机IP

ElasticSearch  ::
vi elasticsearch.yml----network.host: 192.168.146.134   port: 9200

