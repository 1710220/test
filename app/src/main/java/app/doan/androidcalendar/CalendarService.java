package app.doan.androidcalendar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class CalendarService
{
    private static com.google.api.services.calendar.Calendar service = null;

    private static com.google.api.services.calendar.Calendar newInstance(GoogleAccountCredential credential)
    {
        HttpTransport transport = AndroidHttp.newCompatibleTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        service = new com.google.api.services.calendar.Calendar.Builder(
                transport, jsonFactory, credential)
                .setApplicationName("GoogleCalendarApi")
                .build();
        return service;
    }

    public static com.google.api.services.calendar.Calendar getInstance(GoogleAccountCredential credential)
    {
        return service == null ? newInstance(credential) : service;
    }
}
