# 后端启动环境配置

## 启动程序

在IDE中运行`webserver\src\main\java\com\sysu\verto\VertoApplication.java`中main方法

![image-20240807182213014](http://typoraimagess.oss-cn-beijing.aliyuncs.com/img/image-20240807182213014.png)

控制台输出如下表示运行成功：

![image-20240807182248537](http://typoraimagess.oss-cn-beijing.aliyuncs.com/img/image-20240807182248537.png)

**注意：如果修改了代码，再次调试之前记得重新run一遍**

## 测试

### 使用curl

打开cmd,输入对应命令行即可测试api

#### 存储相关接口

- 测试文件上传接口 `upload`

  ```
  curl -F "file=@C:/Users/HP/Desktop/temp/test1.png" http://localhost:8000/files/upload
  ```

  - "file=@/path/to/your/file"   待上传的文件路径名  最好用“/”
  - localhost:8000   8000端口 在  `webserver\src\main\resources\application.properties`里可以修改端口
  - 如果路径报错可尝试将 `webserver\src\main\resources\application.properties`里的 `file.upload-dir`改为绝对路径

- 测试文件下载接口 `download`

  ```
  curl -O http://localhost:8000/files/download/test1.png
  ```

  - `-O` 选项将文件下载到当前目录，并使用服务器提供的文件名保存。如果下载成功，您将在当前目录中看到 `test1.png` 文件。

- 测试文件删除接口 `delete`

  ```
  curl -X DELETE http://localhost:8000/files/delete/test1.png
  ```

  