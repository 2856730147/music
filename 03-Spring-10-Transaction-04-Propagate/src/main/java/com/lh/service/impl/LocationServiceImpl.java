package com.lh.service.impl;

import com.lh.dao.LocationDao;
import com.lh.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDao;
    @Override
    public void addLication(String name ) {
        locationDao.addLocation(name);

    }
}
