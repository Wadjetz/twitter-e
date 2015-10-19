package fr.egor.twitter.view.tweet.list;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import twitter4j.Status;


public class TweetCell extends ListCell<Status> {
  @Override
  protected void updateItem(Status status, boolean empty) {
    super.updateItem(status, empty);
    if (status != null) {
      HBox hb1 = new HBox();
      HBox hb2 = new HBox();
      VBox vb1 = new VBox();
      // load the image
      Image image = new Image(status.getUser().getProfileImageURL());

      // simple displays ImageView the image as is
      ImageView iv1 = new ImageView();
      iv1.setImage(image);

      Label lblName = new Label(status.getUser().getName());
      hb2.getChildren().add(lblName);

      Label lblScreenName = new Label(status.getUser().getScreenName());
      hb2.getChildren().add(lblScreenName);

      Label lblCreatedAt = new Label(status.getUser().getCreatedAt().toString());
      hb2.getChildren().add(lblCreatedAt);

      hb1.getChildren().add(iv1);
      hb1.getChildren().add(hb2);

      setGraphic(hb1);
    }
  }
}
