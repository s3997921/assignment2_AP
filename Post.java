package application;

public class Post {
    private int id;
    private String content;
    private String author;
    private int likes;
    private int shares;

    public Post(int id, String content, String author, int likes, int shares) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.shares = shares;
    }

    // Getters
    // ...

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", likes=" + likes +
                ", shares=" + shares +
                '}';
    }
}
