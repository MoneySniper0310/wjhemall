### wjhemall
linux指令：
/usr/local/nginx/sbin/nginx ---》打开nginx

service  iptables stop  ---》关防火墙

redis-server redis.conf   ---》启动redis服务

 redis-cli -p 6379 ---》连接客户端
 

//######wjhemall-user:8080

wjhemall-user-service:8070
wjhemall-user-web:8080

wjhemall-manage-service:8071
wjhemall-manage-web:8081

//######wjhemall-item-service:8072 
wjhemall-item-web:8082
###面向服务的好处(service controller拆开) 可以后期组合实现一个模块