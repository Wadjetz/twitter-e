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
      Long dstatus = status.getCreatedAt().getTime() / 1000l;
      Long dnow = new Date().getTime() / 1000l;
      Long Ddif = dnow-dstatus;
            Long seconds = Ddif % 60;
            Long minutes= (Ddif / 60)%60;
            Long heures= ((Ddif / 60) / 60) %24;
            Long jours= (((Ddif / 60) / 60) /24 ) %30;
            Long mois= ((((Ddif / 60) / 60) /24) /30 ) %365;
            Long annee= (((((Ddif / 60) / 60) /24) /30 ) /365) % 365;

            String str ="Il y a ";
            if(annee >0)
              str+=" "+annee+ " ans ";
            if(mois >0)
              str+=" "+mois+ " mois ";
            if(jours >0)
              str+=" "+jours+ " jours ";
            if(heures >0)
              str+=" "+heures+ " heures ";
            if(minutes >0)
              str+=" "+minutes+ " minutes ";
            if(seconds >0)
              str+=" "+seconds+ " seconds ";



      lblCreatedAt.setText(str);
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
