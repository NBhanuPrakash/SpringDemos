package com.bank.user;

public class User {
    private Long Aadharr;
    private String Name;
    private String Gender;
    private String dob;
    private String mobile;
    private String pan;
    private String passward;
    private Integer Accountnumber;
    private Integer Accountbalance;
    private String Username;
    private Long Deposit;

    public Long getAadhar(){return Aadharr;}

    public void setAadhar(Long Aadharr){this.Aadharr=Aadharr;}

    public String getName(){return Name;}

    public void setName(String Name){this.Name=Name;}

    public String getgender(){return Gender;}

    public void setgender(String Gender){this.Gender=Gender;}

    public String getDob(){return dob;}

    public void setDob(String dob){this.dob=dob;}

    public String getmobile(){return mobile;}

    public void setmobile(String mobile){this.mobile=mobile;}

    public String getpan(){return pan;}

    public void setpan(String pan){this.pan=pan;}

    public String getpassward(){return passward;}

    public void setpassward(String passward){this.passward=passward;}

    public Integer getaccount_number(){return Accountnumber;}

    public void setaccount_number(Integer Accountnumber){this.Accountnumber=Accountnumber;}

    public Integer getaccountBalance() {
        return Accountbalance;
    }

    public void setaccountBalance(Integer accountBalance) {
        this.Accountbalance= accountBalance;
    }

    public String getUsername(){return Username;}

    public void setUsername(String Username){this.Username=Username;}

    public Long getdeposit(){return Deposit;}

    public void setdeposit(Long Deposit){this.Deposit=Deposit;}

    public User(Long Aadharr,String Name,String Gender,String dob,String mobile,String pan,String passward,Integer Accountnumber,String Username,Long Deposit){
        this.Aadharr=Aadharr;
        this.Name=Name;
        this.Gender=Gender;
        this.dob=dob;
        this.mobile=mobile;
        this.pan=pan;
        this.passward=passward;
        this.Accountnumber=Accountnumber;
        this.Username=Username;
        this.Deposit=Deposit;
    }
    public String toString() {
        return "User [AAdhar"+Aadharr+ "fullName=" + Name + ", gender=" + Gender + ", mobileNumber=" + mobile + ", dob=" + dob
                +"pancard"+pan+ ", password=" + passward + ", accountNumber=" + Accountnumber +"Username "+Username+"Deposit"+Deposit+"]";
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Aadharr == null) ? 0 : Aadharr.hashCode());
        result = prime * result + ((Accountnumber == null) ? 0 : Accountnumber.hashCode());
        result = prime * result + ((dob == null) ? 0 : dob.hashCode());
        result = prime * result + ((Name == null) ? 0 : Name.hashCode());
        result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((pan == null) ? 0 : pan.hashCode());
        result = prime * result + ((passward == null) ? 0 : passward.hashCode());
        result = prime * result + ((Username == null)? 0 : Username.hashCode());
        result = prime * result + ((Deposit == null) ? 0 : Deposit.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (Accountnumber == null) {
            if (other.Accountnumber != null)
                return false;
        } else if (!Accountnumber.equals(other.Accountnumber))
            return false;
        if (dob == null) {
            if (other.dob != null)
                return false;
        } else if (!dob.equals(other.dob))
            return false;
        if (Name == null) {
            if (other.Name != null)
                return false;
        } else if (!Name.equals(other.Name))
            return false;
        if (Gender == null) {
            if (other.Gender != null)
                return false;
        } else if (!Gender.equals(other.Gender))
            return false;
        if (mobile == null) {
            if (other.mobile != null)
                return false;
        } else if (!mobile.equals(other.mobile))
            return false;
        if (passward == null) {
            if (other.passward != null)
                return false;
        } else if (!passward.equals(other.passward))
            return false;
        if (Aadharr == null){
            if (other.Aadharr != null)
                return false;
        } else if (!Aadharr.equals(other.Aadharr))
            return false;
        if (pan == null){
            if (other.pan != null)
                return false;
        }else if (!pan.equals(other.pan)) {
            return false;
        }
        if (Username == null){
            if (other.Username != null)
                return false;
        }else if (!Username.equals(other.Username)) {
            return false;
        }
        if (Deposit == null){
            if(other.Deposit != null)
                return  false;
        }else if(!Deposit.equals(other.Deposit)) {
            return false;
        }


        return true;
    }


}







