Mac下redis的安装
====

一、下载 redis
------
    我下的是最新版 redis-5.0.4.tar.gz
    [官网地址](https://redis.io/)
    我放在  /usr/local 下
二、解压安装
------
   进行解压缩

   tar -zxvf redis-5.0.4.tar.gz  会自动生成一个redis-5.0.4的目录

    删掉redis-5.0.4.tar.gz
    rm -rf redis-5.0.4.tar.gz

    进入src目录下面编译redis
    # 编译
    sudo make test
    # 安装
    sudo make install
    # 建立相应目录
    sudo mkdir bin etc db
    # 拷贝启动文件
    sudo cp src/mkreleasehdr.sh src/redis-benchmark src/redis-check-rdb src/redis-cli src/redis-server bin/

    如果在编译时报错了，清理了再编译一下：
    sudo make distclean && sudo make && sudo make test

三、配置
----------
    # 拷贝配置文件（在redis目录下）
    sudo cp redis.conf etc/
    sudo vi etc/redis.conf

    ####内容参照如下：(选择性修改就好了，不用全都照着改)

    #修改为守护模式（后台启动）
    daemonize yes
    #设置进程锁文件
    pidfile /usr/local/redis-5.0.4/redis.pid
    #端口
    port 6379
    #客户端超时时间
    timeout 300
    #日志级别
    loglevel debug
    #日志文件位置
    logfile /usr/local/redis-5.0.4/log-redis.log
    #设置数据库的数量，默认数据库为0，可以使用SELECT <dbid>命令在连接上指定数据库id
    databases 16
    ##指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合
    #save <seconds> <changes>
    #Redis默认配置文件中提供了三个条件：
    save 900 1
    save 300 10
    save 60 10000
    #指定存储至本地数据库时是否压缩数据，默认为yes，Redis采用LZF压缩，如果为了节省CPU时间，
    #可以关闭该#选项，但会导致数据库文件变的巨大
    rdbcompression yes
    #指定本地数据库文件名
    dbfilename dump.rdb
    #指定本地数据库路径
    dir /usr/local/redis-5.0.4/db/
    #指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能
    #会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有
    #的数据会在一段时间内只存在于内存中
    appendonly no
    #指定更新日志条件，共有3个可选值：
    #no：表示等操作系统进行数据缓存同步到磁盘（快）
    #always：表示每次更新操作后手动调用fsync()将数据写到磁盘（慢，安全）
    #everysec：表示每秒同步一次（折衷，默认值）
    appendfsync everysec
    # 设置连接密码
    requirepass aaa(aaa就是你连接redis的密码)


四、服务的启动
------
sudo /usr/local/redis-4.0.10/src/redis-server /usr/local/redis-4.0.10/etc/redis.conf

命令太长了。。可以去 ～/.bash_profile 文件中添加别名(输入下面这行)<br/>
   alias ro='sudo /usr/local/redis-5.0.4/src/redis-server /usr/local/redis-5.0.4/etc/redis.conf'<br/>
   这样，在终端就可以直接打ro 就能启动redis服务

五、客户端
   # 进入相应目录
    cd /usr/local/redis-5.0.4/src/
   # 启动客户端连接
    sudo ./redis-cli 
   # 如果有密码
    sudo ./redis-cli auth aaa(这是密码)

  [Redis桌面管理工具Mac版]（http://www.pc6.com/mac/486661.html）


