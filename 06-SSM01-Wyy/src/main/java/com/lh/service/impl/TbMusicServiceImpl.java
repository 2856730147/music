package com.lh.service.impl;

import com.lh.dao.TbMusicMapper;
import com.lh.entity.TbMusic;
import com.lh.entity.TbMusicExample;
import com.lh.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;

    //    查询全部
    @Override
    public List<TbMusic> findAll() {
        //无条件查询全部
        return tbMusicMapper.selectByExample(null);
    }

    //    指定id查询
    @Override
    public TbMusic findById(Integer musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    //    下一首
    @Override
    public TbMusic nextSong(Integer musicId) {
        int maxId = tbMusicMapper.findMaxId();
        if (musicId != maxId ) {
            musicId++;
        } else {
            musicId = tbMusicMapper.findMinId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    //    上一首
    @Override
    public TbMusic prevSong(Integer musicId) {

        if (musicId.equals(tbMusicMapper.findMinId())) {
            musicId= tbMusicMapper.findMaxId();
        } else {
            musicId--;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    //模糊查询
    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();

        criteria.andMusicNameLike("%" + keyword + "%");
        return tbMusicMapper.selectByExample(tbMusicExample);
    }
}
