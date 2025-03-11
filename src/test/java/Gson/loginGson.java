package Gson;

public class loginGson {
    private String username;
    private String password;
    private String deviceId;
    private String clientPublicKey;
    public loginGson(String username, String password, String deviceId, String clientPublickey) {
        this.username = username;
        this.password = password;
        this.deviceId = deviceId;
        this.clientPublicKey = clientPublickey;
    }

    public loginGson() {
    }

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
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getClientPublicKey() {
        return clientPublicKey;
    }

    public void setClientPublicKey(String clientPublicKey) {
        this.clientPublicKey = clientPublicKey;
    }

}
