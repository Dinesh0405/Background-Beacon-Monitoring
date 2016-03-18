package uk.ac.lancaster.library.backgroundbeacons;

import uk.ac.lancaster.library.backgroundbeacons.SharedPreferencesUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import android.util.Log;
import java.net.URL;
import java.net.HttpURLConnection;

import uk.ac.lancaster.library.backgroundbeacons.BeaconTrackingEvent;

public class BeaconTrackingService {

  private SharedPreferencesUtility settings;
  private final String apiUrl;
  private final String apiVersion;

  public BeaconTrackingService(SharedPreferencesUtility settings) {

    this.settings = settings;
    this.apiUrl = this.settings.getApiUrl();
    this.apiVersion = this.settings.getApiVersion();

  }

  public void EnterRegionEvent(BeaconTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.apiUrl + this.apiVersion + "/tracking/locations/beacons/regions");

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("X-USER-EMAIL", this.settings.getApiUser());
        conn.setRequestProperty("X-USER-TOKEN", this.settings.getApiToken());

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }
    }

  }

  public void ExitRegionEvent(BeaconTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.apiUrl + this.apiVersion + "/tracking/locations/beacons/regions");

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("X-USER-EMAIL", this.settings.getApiUser());
        conn.setRequestProperty("X-USER-TOKEN", this.settings.getApiToken());

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }
    }

  }

  public void RangeBeaconEvent(BeaconTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.apiUrl + this.apiVersion + "/tracking/locations/beacons");

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("X-USER-EMAIL", this.settings.getApiUser());
        conn.setRequestProperty("X-USER-TOKEN", this.settings.getApiToken());

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }
    }

  }

}
