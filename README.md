### Codeworld-cloud-system微服务版权限管理系统
前不久将以前的权限管理系统 [线上访问地址](http://123.57.64.9:8000/page/login.html)
改成前后端分离的系统，我们在开发就很方便，我们做后端开发就只关注与后端服务，前端开发就关注与前端服务，这样大大的降低了我们的系统的耦合性
[前端项目](https://github.com/javaenigneer/codeworld-vue-system)
[后端项目](https://github.com/javaenigneer/codeworld-api-system)
这个后端项目没有做成微服务版
用到的技术：
`SpringBoot`、`MyBatis`、`SpringSecurity`、`Redis`等技术
基本的这个项目完成了很多的功能需求

#### 新角色(SpringCloud)
现在呢，将系统改成一个微服务版本，当然呢，以前的版本都还在
为什么要出这样一个微服务版的系统呢
我相信大多数学Java的都知道目前流行的就是微服务吧
我这里就就不多介绍了，会在以后出教程，期待你的关注

学习知识是永远也停不下的，我们学的越多，不知道的就越多

#### 本地部署账号

| 账号 | 密码   | 权限         |
| ---- | ------ | ------------ |
| 1111 | 123456 | 拥有最高权限 |
| code | 123456 | 拥有查看权限 |

#### 系统模块

和原来的系统模块一致的，后面会新增一些系统页面

|—系统管理

​     |—用户管理

​     |—角色管理

​     |—菜单管理

​     |—部门管理

#### 系统特点

```tex
​```
1.本系统使用SpringCloud开发，使用多种组Nacos、SpringGateway、Feign
2.使用SpringSecurity作为权限认证框架，是一个能够为基于Spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架，配合我们的SpringBoot开发更加方便
3.使用MyBatis作为持久层的开发，能够很好的维护我们的SQL语句
4.前后端请求数据校验
5.前端使用Vue作为开发框架，实现了前后端分离的效果
6.前端项目布局多样化，主题多样化
​```
```

#### 项目启动

1. 下载windows的nacos
2. 启动服务(备注里面的服务列表)

#### 项目截图

nacos服务注册中心

![nacos注册中心](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/nacos.png)

登录页面

![登录页面](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/login.png)

首页

![首页](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/index.png)

用户管理

![用户管理](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/user.png)

角色管理

![角色管理](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/role.png)

菜单管理

![菜单管理](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/menu.png)

部门管理

![部门管理](https://codeworld-cloud-system-1300450814.cos.ap-chengdu.myqcloud.com/dept.png)