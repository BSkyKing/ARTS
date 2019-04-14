Mac的mysql8安装
=========
    最近刚买了mac电脑。。在电脑上装mysql8

一、下载安装
-------


打开官网https://www.mysql.com/downloads/拉到最下面，选择“MySQL Community Server”

![MySQL Community Server](https://img-blog.csdn.net/20180515143823207)

打开后，继续拉到最下面
![点击download](https://img-blog.csdn.net/20180515144011829)
下载以后，双击打开，进行安装

注意 1 安装的选项 strong/legacy 选第二个

     2 这次和以前的版本不同，不再是随机密码 ，需要自己设定密码，记住密码即可


二、路径的配置
------
  打开terminal终端，输入
  sudo vim ~/.bash_profile  
  加入
  PATH=$PATH:/usr/local/mysql/bin 
  然后重新刷新配置
  source ~/.bash_profile  

三、安装可视化工具
------
  [navicat破解版](https://www.waitsun.com/navicat-premium.html)
  安装后，启动会出现问题，会总是提示“已损坏，移至废纸篓”这类信息，根本无法打开。
  其实，这是新系统（macOS Sierra 10.12.X）惹的祸。新系统加强了安全机制，默认不允许用户自行下载安装应用程序，只能从Mac App Store里安装应用。
  
  解决办法：
    1. 打开mac的terminal终端
    2. 输入代码：sudo spctl --master-disable
    3. 按回车输入自己电脑密码，再次回车
    4 打开系统偏好设置 » 安全性与隐私，若显示任何来源，大功告成；若没有此选项，一定是你前面的步骤不对
      ![如图所示]（https://upload-images.jianshu.io/upload_images/4387205-88ca91c04d911aca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/665）
 