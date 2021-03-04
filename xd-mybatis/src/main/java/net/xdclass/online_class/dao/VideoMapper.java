package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoMapper {

    // 单一参数可以省略@Param，但多个参数一定要指定
    Video selectById(@Param("video_id") int videoId);

    // 使用注解，就不再与Mapper.xml文件交互
    @Select("SELECT * FROM video")
    List<Video> selectVideoList();

    List<Video> selectByScoreAndTitle(@Param("score") double score, @Param("title") String title);

    int addVideo(Video video);

    int addVideoInBulk(List<Video> newVideoList);

    int updateVideoSelective(Video video);

    Video selectBasicFieldByIdWithResultMap(@Param("video_id") int id);
}
