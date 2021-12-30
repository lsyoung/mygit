package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {

	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO notice);
	int noticeInsert(NoticeVO notice);
	int noticeUpdate(NoticeVO notice);
	int noticeDelete(NoticeVO notice);

	void noticeHitUpdate(int id);
	void noticeIdUpdate(int id);
	
	List<NoticeVO> noticeSearch(@Param("key")String key, @Param("val")String val);
} 
