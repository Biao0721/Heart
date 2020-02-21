package data;

public class User{
    private String accountNumber;
    private String userName;
    private String password;
    private String gender;
    private String phone;

    public User(String accountNumber, String password, String userName, String gender, String phone){
        this.accountNumber = accountNumber;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.phone = phone;
    }

    public String getAccountNumber(){return this.accountNumber;}
    public String getPassword(){return this.password;}
    public String getUserName(){return this.userName;}
    public String getGender(){return this.gender;}
    public String getPhone(){return this.phone;}
}