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

public class SqlSessionCacheDemo {

    public static void main(String[] args) throws IOException {
        String resource = "config/mabatis-config.xml";

        // The Resources class comes from mybatis/ibatis
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 多个SqlSession对象操作同一个namespace下的Mapper文件
        // 测试二级缓存
        try {

            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            VideoMapper videoMapper1 = sqlSession1.getMapper(VideoMapper.class);
            Video video1 = videoMapper1.selectById(31);
            System.out.println(video1);

            // 会清空一级缓存
            sqlSession1.commit();

            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            VideoMapper videoMapper2 = sqlSession1.getMapper(VideoMapper.class);
            Video video2 = videoMapper2.selectById(31);
            System.out.println(video2);

            // 会清空一级缓存
            sqlSession2.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
