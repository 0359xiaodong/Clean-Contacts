package me.panavtec.cleancontacts.presentation.outputs;

import android.os.Handler;

public class MainThreadSpec implements ThreadSpec {

  Handler handler = new Handler();

  @Override public <T> void execute(final Action<T> action, final T result) {
    handler.post(new Runnable() {
      @Override public void run() {
        action.onAction(result);
      }
    });
  }
}