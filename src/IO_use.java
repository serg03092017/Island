import java.io.*;
import java.io.IOException;

public class IO_use {


    public IO_use(BufferedReader bufferedReader) {
        bufferedReader=null;
    }

    public byte readByte(InputStream bufferedReader) {
        try {
            char c;
            String str="";
            do {
                c = (char) bufferedReader.read();
                if (c != '\n'){
                    str=str+Character.toString(c);
                }
            }
            while(c != '\n');
            try{
                byte b = Byte.parseByte(str);
                return b;
            }
            catch(NumberFormatException nfe){
                System.err.println("Invalid Byte");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public int [] readInt(InputStream bufferedReader,int cnt, int a_min, int a_max) {
        int[] result = new int[cnt];
        String [] str;
        try {
            char c;
            String s="";
            do {
                c = (char) bufferedReader.read();
                if (c != '\n'){
                    s=s+Character.toString(c);
                }
            }
            while(c != '\n');
            str=s.split(" ");
            if (str.length < cnt) {
                System.err.println("Invalid quantity of parameters");
                return null;
            }
            try{
                for (int i = 0; i < cnt; i++) {
                    result[i] = Integer.parseInt(str[i]);
                    if (result[i] < a_min || result[i] > a_max) {
                        System.err.println("Wrong number");
                        return null;
                    }
                }
                return result;
            }
            catch(NumberFormatException nfe){
                System.err.println("Invalid Int");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}