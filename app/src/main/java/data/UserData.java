package data;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    Map<Integer, User> userList = new HashMap<>();

    private String[] accountNumber = {
            "KonDBin", "LinSSi", "HuJinHao", "LuSY", "LeeYanN", "SunXiao", "HanXueQiao"
    };

    private String[] userName = {
            "孔德彬", "林思思", "胡锦浩", "卢思怡", "李妍霓", "孙潇", "韩雪侨"
    };

    private String[] password = {
            "123", "123", "123", "123", "123", "123", "123"
    };

    private String[] gender = {
            "男", "女", "男", "女", "女", "女", "女"
    };

    private String[] phone = {
            "130 **** 1100"
    };
    private void setUser(){
        for(int i = 0; i < accountNumber.length; i++){
            userList.put(i, new User(accountNumber[i], password[i], userName[i], gender[i], phone[0]));
        }
    }

    public Map<Integer, User> getUser(){
        return userList;
    }

    public UserData(){
        setUser();
    }

    public void addUser(String accountNumber, String password, String userName, String gender, String phone){
        userList.put(this.userList.size() + 1, new User(accountNumber, password, userName, gender, phone));
    }

}