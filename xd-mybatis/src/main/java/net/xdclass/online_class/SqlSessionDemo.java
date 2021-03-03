package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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
            Video video = videoMapper.selectById(31);

            //System.out.println(video);

            List<Video> videoList = videoMapper.selectVideoList();
            System.out.println(videoList);
        }
    }
}
