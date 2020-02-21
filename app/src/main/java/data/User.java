package data;

public class User{
    private String accountNumber;
    private String userName;
    private String password;
    private String gender;
    private String phone;

    public User(String accountNumber, String userName, String password, String gender, String phone){
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
    }

    public String getAccountNumber(){return this.accountNumber;}
    public String getUserName(){return this.userName;}
    public String getPassword(){return this.password;}
    public String getGender(){return this.gender;}
    public String getPhone(){return this.phone;}
}