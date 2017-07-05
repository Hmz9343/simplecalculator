package company.hamza.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
    private Button num[]=new Button[10];
    private Button div;
    private Button mul;
    private Button add;
    private Button min;
    private Button equal;
    private Button clears;
    private Button dec;
    private Button all;
    private Button ans;
    double answer;
    private TextView txt;
     double value;
     String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
         txt=(TextView)findViewById(R.id.textView);


        num[0]=(Button)findViewById(R.id.num0);
        num[1]=(Button)findViewById(R.id.num1);
        num[2]=(Button)findViewById(R.id.num2);
        num[3]=(Button)findViewById(R.id.num3);
        num[4]=(Button)findViewById(R.id.num4);
        num[5]=(Button)findViewById(R.id.num5);
        num[6]=(Button)findViewById(R.id.num6);
        num[7]=(Button)findViewById(R.id.num7);
        num[8]=(Button)findViewById(R.id.num8);
        num[9]=(Button)findViewById(R.id.num9);

        answer=0.0d;

        for(int i=0;i<10;i++)
        {


            final int finalI1 = i;
            num[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str=txt.getText().toString();
                    str=str+ finalI1;
                    txt.setText(str);
                }
            });
        }
        div=(Button)findViewById(R.id.divbut);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=txt.getText().toString();
                str=str+"/";
                txt.setText(str);
            }
        });
        mul=(Button)findViewById(R.id.mulbut);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = txt.getText().toString();
                str = str + "*";
                txt.setText(str);
            }
        });
        min=(Button)findViewById(R.id.minbut);
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = txt.getText().toString();
                str = str + "-";
                txt.setText(str);
            }
        });
        add=(Button)findViewById(R.id.sumbut);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = txt.getText().toString();
                str = str + "+";
                txt.setText(str);
            }
        });
        equal=(Button)findViewById(R.id.equalbut);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                str = txt.getText().toString();
                if(str.compareTo("")!=0)
                {
                      try {
                             value = eval(str);
                             answer = eval(str);
                             str = Double.toString(value);
                          }
                      catch(Exception e)
                          {
                              str="ERROR";
                          }
                }
                txt.setText(str);
            }
        });

        dec=(Button)findViewById(R.id.decibut);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = txt.getText().toString();
                str = str + ".";
                txt.setText(str);
            }
        });

        all=(Button)findViewById(R.id.allbut);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str ="";
                txt.setText(str);
            }
        });

        ans=(Button)findViewById(R.id.ansbut);
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = txt.getText().toString();
                str = str + answer;
                txt.setText(str);
            }
        });

        clears=(Button)findViewById(R.id.clearbut);
        clears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txt.getText().toString();
                if(str.compareTo("")!=0)
                {
                    str = str.substring(0, str.length() - 1);
                    txt.setText(str);
                }
                else
                {
                    str="";
                    txt.setText(str);
                }
            }
        });
    }
    public double eval(String str)throws RuntimeException
    {
        str=str+" ";
        int len=str.length();
        String wrd="";
        Double arr[]=new Double[10];
        int p=0;
        char sign[]=new char[10];
        int x=0,f=0;
        for(int i=0;i<10;i++)
        {
            arr[i]=0.0;
            sign[i]=' ';
        }
        char c=str.charAt(0);
        if(c=='+'||c=='-'||c=='*'||c=='/')
            f=1;
        for(int i=0;i<len;i++)
        {
            char ch=str.charAt(i);
            if((ch<='9' && ch>='0')||ch=='.')
            { wrd+=ch;
                wrd.trim();
            }

            else {
                if(f==0)
                {
                    arr[p++]=Double.parseDouble(wrd);
                    wrd="";
                }
                switch (ch)
                {
                    case '+': sign[x++]='+';break;
                    case '-': sign[x++]='-';break;
                    case '*': sign[x++]='*';break;
                    case '/': sign[x++]='/';break;

                }
                f=0;
            }
        }
        int t=0;
        int i=0;
        int poop=0;
        if(c<='9' && c>='0' )
            value=arr[0];
        else if(c=='-') {
            value = -arr[0]; i++;
        }
        else if(c=='+')
        {
            value = arr[0]; i++;
        }
        else if(c=='*'||c=='/')
        {
            value=0.0;
            poop=1;
        }
        if(poop!=1)
        {    for(;sign[i]!=' ';i++)
        {
            switch (sign[i])
            {
                case '+': value=value+arr[++t];break;
                case '-': value=value-arr[++t];break;
                case '*': value=value*arr[++t];break;
                case '/': value=value/arr[++t];break;
            }
        }
        }
        return value;
    }

}
