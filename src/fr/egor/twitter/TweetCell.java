package fr.egor.twitter;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import twitter4j.Status;

public class TweetCell extends ListCell<Status> {
  @Override
  protected void updateItem(Status status, boolean empty) {
    super.updateItem(status, empty);
    if (status != null) {
      setGraphic(new Label(status.getText()));
    }
  }
}
