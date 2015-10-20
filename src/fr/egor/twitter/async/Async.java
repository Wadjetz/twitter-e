package fr.egor.twitter.async;

import javafx.concurrent.Task;
import java.util.concurrent.Callable;

public class Async {
  public static <T> void async(Callable<T> callable) {
    Task<T> task = new Task<T>() {
      @Override
      protected T call() throws Exception {
        return callable.call();
      }
    };

    Thread th = new Thread(task);
    th.setDaemon(true);
    th.start();
  }
}
