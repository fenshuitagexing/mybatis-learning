package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

    List<VideoOrder> queryVideoOrderList();

    List<VideoOrder> queryVideoOrderListLazyLoading();
}
