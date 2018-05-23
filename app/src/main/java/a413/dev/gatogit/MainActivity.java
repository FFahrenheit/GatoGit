package a413.dev.gatogit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    public void reset(View v)
    {
        masterReset();
    }

    public int Victory()
    {
        if(logicMatriz[0][0]==logicMatriz[1][1] && logicMatriz[2][2]==logicMatriz[0][0] && logicMatriz[0][0]!=2)
        {
            return logicMatriz[0][0];
        }
        else if(logicMatriz[0][2]==logicMatriz[1][1] && logicMatriz[2][0]==logicMatriz[0][2] && logicMatriz[0][2]!=2)
        {
            return logicMatriz[0][2];
        }
        for(int i=0; i<3; i++)
        {
            if(logicMatriz[i][0]==logicMatriz[i][1] && logicMatriz[i][2]==logicMatriz[i][0] && logicMatriz[i][0]!=2)
            {
                return logicMatriz[i][0];
            }
            else if(logicMatriz[0][i]==logicMatriz[1][i] && logicMatriz[2][i]==logicMatriz[0][i] && logicMatriz[0][i]!=2)
            {
                return logicMatriz[0][i];
            }
        }
        return 2;
    }
    public void checkVictory()
    {
        if(counter%2==1)
        {
            message.setText("Turno de X");
        }
        else
        {
            message.setText("Turno de O");
        }
        if(counter==8)
        {
            message.setText("Empate, presione reset.");
        }
        if(Victory()!=2)
        {
            if(Victory()==0)
            {
                message.setText("GANÓ X, presione reset.");
            }
            else
            {
                message.setText("GANÓ O, presione reset.");
            }
        }
        else
        {
            counter++;
        }
    }

    public void onClick0X0(View v)
    {
        Turno(0,0);
    }
    public void onClick0X1(View v)
    {
        Turno(0,1);
    }

    public void onClick0X2(View v)
    {
        Turno(0,2);
    }
    public void onClick1X0(View v)
    {
        Turno(1,0);
    }
    public void onClick1X1(View v)
    {
        Turno(1,1);
    }
    public void onClick1X2(View v)
    {
        Turno(1,2);
    }
    public void onClick2X0(View v)
    {
        Turno(2,0);
    }
    public void onClick2X1(View v)
    {
        Turno(2,1);
    }
    public void onClick2X2(View v)
    {
        Turno(2,2);
    }
    public void Turno(int i, int j)
    {
        if(logicMatriz[i][j]==2 && Victory()==2)
        {
            logicMatriz[i][j] = counter%2;
            if(counter%2==0)
            {
                matriz[i][j].setText("X");
            }
            else
            {
                matriz[i][j].setText("O");
            }
            checkVictory();
        }
    }
}
