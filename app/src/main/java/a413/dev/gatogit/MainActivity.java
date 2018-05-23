package a413.dev.gatogit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button matriz[][];
    private Button reset;
    private TextView message;
    private Integer counter;
    private Integer logicMatriz[][]; //2 to null, 1 to O, 0 to X.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matriz = new Button[3][3];
        matriz[0][0] = (Button) findViewById(R.id.button0X0);
        matriz[0][1] = (Button) findViewById(R.id.button0X1);
        matriz[0][2] = (Button) findViewById(R.id.button0X2);
        matriz[1][0] = (Button) findViewById(R.id.button1X0);
        matriz[1][1] = (Button) findViewById(R.id.button1X1);
        matriz[1][2] = (Button) findViewById(R.id.button1X2);
        matriz[2][0] = (Button) findViewById(R.id.button2X0);
        matriz[2][1] = (Button) findViewById(R.id.button2X1);
        matriz[2][2] = (Button) findViewById(R.id.button2X2);
        reset = (Button) findViewById(R.id.resetButton);
        message = (TextView) findViewById(R.id.notificationText);
        logicMatriz = new Integer[3][3];
        masterReset();
    }
    public void masterReset()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                matriz[i][j].setText("");
                logicMatriz[i][j] = 2;
            }
        }
        message.setText("Turno de X");
        counter = 0;
    }
}
