package com.mxy.booksharing.service.serviceIMPL;

import com.mxy.booksharing.dao.NoticeMapper;
import com.mxy.booksharing.pojo.Notice;
import com.mxy.booksharing.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceIMPL implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> noticeList() {
        return noticeMapper.noticeList();
    }

    @Override
    public int addNotice(String noticeTitle, String noticeContent) {
        return noticeMapper.addNotice(noticeTitle,noticeContent);
    }

    @Override
    public int deleteNotice(int noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public int updateNotice(String noticeTitle, String noticeContent, int noticeId) {
        return noticeMapper.updateNotice(noticeTitle,noticeContent,noticeId);
    }

    @Override
    public Notice noticeListById(int noticeId) {
        return noticeMapper.noticeListById(noticeId);
    }

}
