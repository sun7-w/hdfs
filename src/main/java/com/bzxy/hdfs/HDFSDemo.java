package com.bzxy.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

//HDFS相关API的使用
public class HDFSDemo {
    //在HDFS中创建目录
    @Test
    public void createDir() throws IOException, InterruptedException {
        //1.加载HDFS的配置信息，获取HDFS的操作对象(FileSystem)
        //参数1：HDFS的连接地址
        //参数2：Configurtion对象，该对象主要用于加载HDFS的相关配置信息
        //参数3：用户权限 root超级管理员用户
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.50.131:9000"),conf,"root");
        //2.指定使用path类指定目录,指定的是在HDFS中需要创建的目录 /test就是在根目录下创建test目录
        Path path= new Path("/test");
        //3.使用FileSystem,也就是使用fs在HDFS中创建目录
        fs.mkdirs(path);
        //关闭HDFS的操作对象
        fs.close();
        System.out.println("目标创建成功");
    }
    //在HDFS中创建文件,并向文件中写入内容
    @Test
    public void writeFile() throws IOException, InterruptedException {
        //1.加载HDFS的配置信息，获取HDFS的操作对象(FileSystem)
        Configuration con = new Configuration();
        FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.50.131:9000"),con,"root");
        //2.使用path类在HDFS中指定文件的路径
        Path path = new Path("/test/abc.txt");
        //IO流：InputOutput流，输入输出流，输出流可以向文件中去写，输入流可以从文件中读
        //3.通过fs获取FSDataOutputStrem对象，改对象具有输出流的属性和功能，使用该对象实现写的操作
        //FSDataOutputStrem可以向HDFS中的文件去写
        FSDataOutputStream os =fs.create(path);
        //4.使用os向文件中进行写操作,向path去写
        os.writeUTF("helloworld\n");
        os.writeUTF("今天是5月18日");
        //5.关闭fs和os
        fs.close();
        os.close();
        System.out.println("写入成功");
    }

}
