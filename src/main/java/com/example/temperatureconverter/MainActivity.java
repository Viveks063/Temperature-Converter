package com.example.temperatureconverter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputEditText=findViewById(R.id.inputEditText);
        RadioGroup radioGroup=findViewById(R.id.radioGroup);
        Button convertButton=findViewById(R.id.convertButton);
        final TextView resultTextView=findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=inputEditText.getText().toString();
                if(!inputText.isEmpty())
                {
                    double inputTemp=Double.parseDouble(inputText);
                    RadioButton celciusRadioButton=findViewById(R.id.celciusRadioButton);
                    boolean isCelcius=celciusRadioButton.isChecked();

                    double convertTemp;
                    if(isCelcius)
                    {
                        convertTemp=celciusToFarenheit(inputTemp);
                        resultTextView.setText(inputTemp+" °C is "+convertTemp+" °F");
                    }
                    else
                    {
                        convertTemp=farenheitToCelcius(inputTemp);
                        resultTextView.setText(inputTemp+" °F is "+convertTemp+" °C");
                    }
                }
                else
                {
                    resultTextView.setText("Please enter the temperature!");
                }
            }
        });
    }

    private double celciusToFarenheit(double celsius)
    {
        return (celsius*9/5)+32;
    }
    private double farenheitToCelcius(double fahrenheit)
    {
        return (fahrenheit-32)*5/9;
    }


}