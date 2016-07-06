package maya.edu.intent;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

public class AlarmClockActivity extends AppCompatActivity {

    EditText edMessage;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);

        Intent intent = getIntent();
        edMessage = (EditText) findViewById(R.id.edMessage);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
    }

    public void alarmClock(View view) {
        int hour = 0, minutes = 0;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            minutes = timePicker.getMinute();
        }else{
            hour = timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();
        }
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, getMessage());
            intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

        startActivity(intent);
    }

    public String getMessage() {
        String message = "";
        try {
            if (edMessage != null)
                message = edMessage.getText().toString();

        } catch (Exception e) {

        }
        return message;
    }

}
