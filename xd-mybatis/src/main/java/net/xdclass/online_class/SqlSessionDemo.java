package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {
        String resource = "config/mabatis-config.xml";

        // The Resources class comes from mybatis/ibatis
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // Project Settings -> Modules -> Sources -> Language level -> JDK8
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

            // 1 调用 VideoMapper 接口的 selectById() 方法
            // 2 将@Param("video_id")映射到 VideoMapper.xml 的 VideoMapper namespace 中的 #{video_id}
            // 3 将 SQL 的执行结果映射到 resultType
            // Video video = videoMapper.selectById(31);

            //System.out.println(video);

            // List<Video> videoList = videoMapper.selectVideoList();
            // System.out.println(videoList);

            List<Video> videoList = videoMapper.selectByScoreAndTitle(8.7, "HTML");
            System.out.println(videoList);


//            Video video = new Video();
//            video.setTitle("小滴课堂面试专题900道");
//            video.setCoverImg("xdclass.net/aaa.png");
//            video.setScore(9.4);
//            video.setCreationTime(new Date());
//            video.setPrice(9900);
//            video.setSummary("这个是面试专题概要");
//
//            int rows = videoMapper.addVideo(video);
//
//            System.out.println(rows);
//            System.out.println(video.toString());

            
//            video1.setCreationTime(new Date());
//            video1.setPrice(900);
//            video1.setSummary("Java Web");
//
//            Video video2 = new Video();
//            video2.setTitle("小滴课堂JVM面试专题");
//            video2.setCoverImg("xdclass.net/aaa.png");
//            video2.setScore(9.2);
//            video2.setCreationTime(new Date());
//            video2.setPrice(900);
//            video2.setSummary("JVM");
//
//            List<Video> newVideoList = new ArrayList<>();
//            newVideoList.add(video1);
//            newVideoList.add(video2);
//
//            int rows = videoMapper.addVideoInBulk(newVideoList);
//            System.out.println(rows);


            Video video = new Video();
            video.setId(51);
            video.setSummary("Java Virtual Machine");
            videoMapper.updateVideoSelective(video);
        }

    }
}
