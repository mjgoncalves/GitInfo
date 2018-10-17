package model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("following")
    private String following;

    @SerializedName("followers")
    private String followers;

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar;

    public GitHubUser(String username, String email, String following, String followers, String login, String avatar) {
        this.name = username;
        this.email = email;
        this.following = following;
        this.followers = followers;
        this.login = login;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
