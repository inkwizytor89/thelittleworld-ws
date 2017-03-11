package com.thelittleworld.dao;

import com.thelittleworld.entity.DBVersion;

public interface DBVersionDAO {

    DBVersion getLastDBVersion();
}