package core;

import DAO.DAOcity;
import DAO.DAOflight;

import java.io.IOException;

public class Database {
    public boolean isExisted() {
        return false;
    }

    public void createInitialData() throws IOException {
        DAOcity daOcity = new DAOcity();
        daOcity.create();
        DAOflight daOflight = new DAOflight();
        daOflight.create();


    }
}
