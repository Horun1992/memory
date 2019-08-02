package zone.shuhrat.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchModel {

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("width")
        @Expose
        private int width;
        @SerializedName("height")
        @Expose
        private int height;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("alt_description")
        @Expose
        private String altDescription;
        @SerializedName("urls")
        @Expose
        private Urls urls;
        @SerializedName("links")
        @Expose
        private Links links;
        @SerializedName("categories")
        @Expose
        private List<Object> categories = null;
        @SerializedName("likes")
        @Expose
        private int likes;
        @SerializedName("liked_by_user")
        @Expose
        private boolean likedByUser;
        @SerializedName("current_user_collections")
        @Expose
        private List<Object> currentUserCollections = null;
        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("tags")
        @Expose
        private List<Tag> tags = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAltDescription() {
            return altDescription;
        }

        public void setAltDescription(String altDescription) {
            this.altDescription = altDescription;
        }

        public Urls getUrls() {
            return urls;
        }

        public void setUrls(Urls urls) {
            this.urls = urls;
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }

        public List<Object> getCategories() {
            return categories;
        }

        public void setCategories(List<Object> categories) {
            this.categories = categories;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public boolean isLikedByUser() {
            return likedByUser;
        }

        public void setLikedByUser(boolean likedByUser) {
            this.likedByUser = likedByUser;
        }

        public List<Object> getCurrentUserCollections() {
            return currentUserCollections;
        }

        public void setCurrentUserCollections(List<Object> currentUserCollections) {
            this.currentUserCollections = currentUserCollections;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }
    }

    public class ProfileImage {

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

    }

    public class Tag {

        @SerializedName("title")
        @Expose
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

    public class User {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("twitter_username")
        @Expose
        private Object twitterUsername;
        @SerializedName("portfolio_url")
        @Expose
        private String portfolioUrl;
        @SerializedName("bio")
        @Expose
        private String bio;
        @SerializedName("location")
        @Expose
        private Object location;
        @SerializedName("links")
        @Expose
        private Links_ links;
        @SerializedName("profile_image")
        @Expose
        private ProfileImage profileImage;
        @SerializedName("instagram_username")
        @Expose
        private String instagramUsername;
        @SerializedName("total_collections")
        @Expose
        private int totalCollections;
        @SerializedName("total_likes")
        @Expose
        private int totalLikes;
        @SerializedName("total_photos")
        @Expose
        private int totalPhotos;
        @SerializedName("accepted_tos")
        @Expose
        private boolean acceptedTos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Object getTwitterUsername() {
            return twitterUsername;
        }

        public void setTwitterUsername(Object twitterUsername) {
            this.twitterUsername = twitterUsername;
        }

        public String getPortfolioUrl() {
            return portfolioUrl;
        }

        public void setPortfolioUrl(String portfolioUrl) {
            this.portfolioUrl = portfolioUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public Links_ getLinks() {
            return links;
        }

        public void setLinks(Links_ links) {
            this.links = links;
        }

        public ProfileImage getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(ProfileImage profileImage) {
            this.profileImage = profileImage;
        }

        public String getInstagramUsername() {
            return instagramUsername;
        }

        public void setInstagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
        }

        public int getTotalCollections() {
            return totalCollections;
        }

        public void setTotalCollections(int totalCollections) {
            this.totalCollections = totalCollections;
        }

        public int getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(int totalLikes) {
            this.totalLikes = totalLikes;
        }

        public int getTotalPhotos() {
            return totalPhotos;
        }

        public void setTotalPhotos(int totalPhotos) {
            this.totalPhotos = totalPhotos;
        }

        public boolean isAcceptedTos() {
            return acceptedTos;
        }

        public void setAcceptedTos(boolean acceptedTos) {
            this.acceptedTos = acceptedTos;
        }

    }

    public class Links {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("download")
        @Expose
        private String download;
        @SerializedName("download_location")
        @Expose
        private String downloadLocation;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownloadLocation() {
            return downloadLocation;
        }

        public void setDownloadLocation(String downloadLocation) {
            this.downloadLocation = downloadLocation;
        }

    }

    public class Links_ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("photos")
        @Expose
        private String photos;
        @SerializedName("likes")
        @Expose
        private String likes;
        @SerializedName("portfolio")
        @Expose
        private String portfolio;
        @SerializedName("following")
        @Expose
        private String following;
        @SerializedName("followers")
        @Expose
        private String followers;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public String getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(String portfolio) {
            this.portfolio = portfolio;
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

    }
}