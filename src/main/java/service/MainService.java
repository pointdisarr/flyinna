package service;

import menu.Menu;

public class MainService {
    public String menuContent() {
        return new Menu().show();
    }
}
