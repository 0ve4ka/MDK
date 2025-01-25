
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

class LastLikeInfo {
    // ваш код
    private String user;
    private Integer hours;

    private Integer minutes;

    public LastLikeInfo() {}

    public LastLikeInfo(String user, Integer hours,Integer minutes) {
        this.user = user;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getUser() {
        return user;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        String lastLikeInfoStr = "{ \"user\": \"Алексей\", \"hours\": 12, \"minutes\": 30}";

        // код для десериализации
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        LastLikeInfo lastLikeInfo = gson.fromJson(lastLikeInfoStr,LastLikeInfo.class);

        LikesInfo likesInfo = new LikesInfo();
        likesInfo.setRepostsCount(10);
        likesInfo.setHasOwnerLiked(true);
        likesInfo.setLikes(new Like[]{
                new Like("Алексей", "http://example.com/avatars/aleksey.jpg"),
                new Like("Елена", "http://example.com/avatars/elena.jpg"),
                new Like("Света", "http://example.com/avatars/sveta.jpg"),
        });

        likesInfo.setLastLikeInfo(lastLikeInfo);

        // код сериализации и вывода на экран
        String LI = gson.toJson(likesInfo);
        System.out.println(LI);
    }
}

class LikesInfo {
    private boolean hasOwnerLiked;
    private Like[] likes;
    private int repostsCount;
    private LastLikeInfo lastLikeInfo;

    public boolean isHasOwnerLiked() {
        return hasOwnerLiked;
    }

    public void setHasOwnerLiked(boolean hasOwnerLiked) {
        this.hasOwnerLiked = hasOwnerLiked;
    }

    public Like[] getLikes() {
        return likes;
    }

    public void setLikes(Like[] likes) {
        this.likes = likes;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public LastLikeInfo getLastLikeInfo() {
        return lastLikeInfo;
    }

    public void setLastLikeInfo(LastLikeInfo info) {
        this.lastLikeInfo = info;
    }
}

class Like {
    private String name;
    private String avatarUrl;

    public Like() {}

    public Like(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
