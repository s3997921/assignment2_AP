package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PostController {

    @FXML
    private TextField postId;

    @FXML
    private TextField author;

    @FXML
    private TextField likes;

    @FXML
    private TextField shares;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Post> postListView;

    private final ObservableList<Post> posts = FXCollections.observableArrayList();

    public void initialize() {
        postListView.setItems(posts);
    }

    public void addPost() {
        try {
            int id = Integer.parseInt(postId.getText());
            String authorText = author.getText();
            String content = contentArea.getText();
            int likesCount = Integer.parseInt(likes.getText());
            int sharesCount = Integer.parseInt(shares.getText());

            Post newPost = new Post(id, content, authorText, likesCount, sharesCount);
            posts.add(newPost);
        } catch (NumberFormatException e) {
            showErrorDialog("Please enter valid numeric values for Post ID, Likes, and Shares.");
        }
    }

    public void editPost() {
        Post selectedPost = postListView.getSelectionModel().getSelectedItem();
        if (selectedPost != null) {
            try {
                selectedPost.setId(Integer.parseInt(postId.getText()));
                selectedPost.setAuthor(author.getText());
                selectedPost.setContent(contentArea.getText());
                selectedPost.setLikes(Integer.parseInt(likes.getText()));
                selectedPost.setShares(Integer.parseInt(shares.getText()));
            } catch (NumberFormatException e) {
                showErrorDialog("Please enter valid numeric values for Likes and Shares.");
            }
        }
    }

    public void deletePost() {
        Post selectedPost = postListView.getSelectionModel().getSelectedItem();
        if (selectedPost != null) {
            posts.remove(selectedPost);
        }
    }

    public void exportPost() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (Post post : posts) {
                    writer.println(post.toString());
                }
            } catch (IOException ex) {
                showErrorDialog("Failed to export posts. Please try again.");
            }
        }
    }

    public void visualizeData() {
        // This can be enhanced further depending on the visualization method
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
