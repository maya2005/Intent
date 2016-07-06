package maya.edu.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText etQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();

        etQuery = (EditText) findViewById(R.id.etQuery);

    }
    private boolean isQueryValid (){
        boolean isQueryValid = etQuery.getText().toString().length()>=1;
        if(!isQueryValid){
            etQuery.setError(getString(R.string.edQuery_error));
        }
          return isQueryValid;
    }

    public void googleSearch(View view) {
        if(isQueryValid() == true) {
            Uri data = Uri.parse("https://www.google.co.il/search?q==" + getQuery());
            Intent googleIntent = new Intent(Intent.ACTION_VIEW, data);
            startActivity(googleIntent);
        }
    }

    public void youtubeSearch(View view) {
        if(isQueryValid() == true) {
            Uri data = Uri.parse("https://www.youtube.com/results?search_query=" + getQuery());
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, data);
            startActivity(youtubeIntent);
        }
    }

    public void androidSearch(View view) {
        if(isQueryValid() == true) {
            Uri data = Uri.parse("https://developer.android.com/index.html#q=" + getQuery());
            Intent androidIntent = new Intent(Intent.ACTION_VIEW, data);
            startActivity(androidIntent);
        }
    }

    public String getQuery(){
        return etQuery.getText().toString();
    }
}
