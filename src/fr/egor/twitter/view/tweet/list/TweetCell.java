package fr.egor.twitter.view.tweet.list;

import fr.egor.twitter.async.Async;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import twitter4j.Status;

import java.util.Date;

public class TweetCell extends ListCell<Status> {
  @Override
  protected void updateItem(Status status, boolean empty) {
    super.updateItem(status, empty);
    if (status != null) {

      HBox hb1 = new HBox();
      hb1.setPadding(new Insets(5,15,0,0));

      HBox hb2 = new HBox();

      VBox vb1 = new VBox();
      vb1.setPadding(new Insets(0, 15, 0, 15));

      // simple displays ImageView the image as is
      ImageView iv1 = new ImageView();

      // load the image
      Async.async(() -> {
        Image image = new Image(status.getUser().getProfileImageURL());
        Platform.runLater(() -> iv1.setImage(image) );
        return null;
      });

      Label lblName = new Label(status.getUser().getName());
      lblName.setPadding(new Insets(5,15,0,0));
      hb2.getChildren().add(lblName);

      Label lblScreenName = new Label("@"+status.getUser().getScreenName());
      lblScreenName.setPadding(new Insets(5,15,0,0));
      hb2.getChildren().add(lblScreenName);


      Label lblCreatedAt = new Label();
      DateTime date = new DateTime(status.getCreatedAt().getTime());
      Period period = new Period(date, DateTime.now());
      PeriodFormatter formatter = new PeriodFormatterBuilder()
        .appendYears().appendSuffix(" years ")
        .appendMonths().appendSuffix(" months ")
        .appendWeeks().appendSuffix(" weeks ")
        .appendDays().appendSuffix(" days ")
        .appendHours().appendSuffix(" hours ")
        .appendMinutes().appendSuffix(" minutes ")
        .appendSuffix(" ago ")
        .printZeroNever()
        .toFormatter();

      String elapsed = formatter.print(period);

      lblCreatedAt.setText(elapsed);

      lblCreatedAt.setPadding(new Insets(5,15,0,0));
      hb2.getChildren().add(lblCreatedAt);

      Label lblStatus = new Label(status.getText());
      vb1.getChildren().add(hb2);
      vb1.getChildren().add(lblStatus);


      hb1.getChildren().add(iv1);
      hb1.getChildren().add(vb1);

      setGraphic(hb1);
    }
  }
}
