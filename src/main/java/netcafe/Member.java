package netcafe;

public class Member {
    private String username;
    private String password;
    private String fullname;
    private String avatar;
    private int remainTime;
    private String status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = Integer.parseInt(remainTime);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
