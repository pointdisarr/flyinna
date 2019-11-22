package core;

import DAO.DAOcity;
import DAO.DAOflight;

import java.io.IOException;

public class Database {
    public Database() {
        createInitialData();
    }

    public boolean isExisted() {
        return false;
    }

    public void createInitialData() {
        DAOcity daOcity = new DAOcity();
        daOcity.create();
        DAOflight daOflight = new DAOflight();
        daOflight.create();


    }
}
