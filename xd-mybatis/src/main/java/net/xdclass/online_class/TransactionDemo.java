package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.dao.VideoOrderMapper;
import net.xdclass.online_class.domain.Video;
import net.xdclass.online_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TransactionDemo {

    public static void main(String[] args) throws IOException {
        String resource = "config/mabatis-config.xml";

        // The Resources class comes from mybatis/ibatis
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // autoCommit = true, 无需commit
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            Video video1 = new Video();
            video1.setTitle("微服务架构");
            videoMapper.addVideo(video1);

            // autoCommit = true, 无需commit
            // sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}