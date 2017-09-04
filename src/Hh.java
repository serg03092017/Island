import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;

public class Hh {
    public static void main(String args[]) {
        IO_use num1 = new IO_use(new BufferedReader(new InputStreamReader(System.in)));
        byte IN = 1;
        IN = num1.readByte(System.in);
        if (IN == 0) {
            return;
        }
        //System.out.print(IN);
        Process[] island1 = new Process [IN];
        //System.out.println();
        for (int inum = 0; inum < IN; inum++) {
            int[] v = num1.readInt(System.in, 2, 1, 50);
            //System.out.println(v[0]+" "+v[1]);
            if (v == null) return;

            int[][] island2dfill = new int[v[0]][v[1]];
            for (int p = 0; p<v[0]; p++) {
                int spliter[];
                spliter = num1.readInt(System.in, v[1], 1, 1000);
                for (int n = 0; n < v[1]; n++) {
                    island2dfill[p][n] = spliter[n];
                }
            }

                    //
                    int max_height=0;
                    int max_dept= island2dfill.length;
                    int max_width= island2dfill[0].length;
                    int min_height=1;
                    int min_dept= 0;
                    int min_width= 0;

                    for (int i=0; i < island2dfill.length;i++){
                        for (int j=0; j < island2dfill[0].length;j++){
                            //System.out.print(island2dfill[i][j]+" ");
                            if (max_height<=island2dfill[i][j]) {max_height=island2dfill[i][j];}
                        }
                        //System.out.println();
                    }

                    Create_island[] island3d = new Create_island[max_height*max_dept*max_width];
                    int counter=0;
                    for (int i=0; i < island2dfill.length;i++){
                        for (int j=0; j < island2dfill[0].length;j++){
                            for (int k=1; k < max_height+1;k++){
                                island3d[counter]=new Create_island(island2dfill[i][j],i,j,max_height,k);
                                counter++;
                            }
                        }
                    }

                    int a[]=new int [max_height*max_dept*max_width];
                    int b[]=new int [max_height*max_dept*max_width];
                    int c[]=new int [max_height*max_dept*max_width];
                    String d[]= new String[max_height * max_dept * max_width];

                    for (int k=0; k < max_height*max_dept*max_width;k++) {
                        a[k]=island3d[k].x;
                        b[k]=island3d[k].y;
                        c[k]=island3d[k].z;
                        d[k]=island3d[k].condition;
                    }

            island1[inum] = new Process(a, b, c, d, max_height * max_dept * max_width, min_width, min_dept, min_height, max_width, max_dept, max_height);
            //System.out.println("volume_of_water=" + island1[inum].volume);
                }
        for (int inum = 0; inum < IN; inum++) {
            System.out.println("volume_of_water=" + island1[inum].volume);
        }
            }
        }




