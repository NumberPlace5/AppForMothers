package events.tgh2020.slidemap;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CalendarActivity2 extends AppCompatActivity {
    private Calendar lastSelectDate = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamaprofileschedule);
        String name = getIntent().getStringExtra("name");
        setTitle(name);
        CalendarView calendarView = findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dateOfMonth) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, dateOfMonth);
                if (date.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                    Toast.makeText(CalendarActivity2.this, "その日付は予定がすでに入っています", Toast.LENGTH_SHORT).show();
                    view.setDate(lastSelectDate.getTimeInMillis());
                } else {
                    lastSelectDate.set(year, month, dateOfMonth);
                }
            }
        });
    }
}