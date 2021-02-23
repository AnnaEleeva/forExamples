import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


//dist task3
public class Main {




    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] firstInputLine=reader.readLine().split(" ");
        int n= Integer.parseInt(firstInputLine[0]);
        int k= Integer.parseInt(firstInputLine[1]);
        String [] secondInputLine=reader.readLine().split(" ");
        long m = System.currentTimeMillis();

        // int[][] arrayOfDistances=new int [n][n-1];
        //HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();

        int [] values=new int [n];
        for(int i=0;i<n;i++){
            values[i]=Integer.parseInt(secondInputLine[i]);
            //ArrayList<Integer> resultArray=new ArrayList<>();
            //map.put(i+1,resultArray);
        }


        for(int i=0;i<n;i++){ //для каждой вершины делаем карту ее всех дистанций 1: 1 2 2 1
            ArrayList<Integer> resultArray =searchDistances(values,i,k); //indexOfVertex 0 ==realVertex 1
            //map.put(i+1,resultArray);

            int sum=0;
            for (int j=0;j<k;j++){
                sum+=resultArray.get(j);
            }
            System.out.print(sum+" ");


        }
        System.out.println();
        System.out.print((double) (System.currentTimeMillis() - m));

        reader.close();

    }
    public static  ArrayList<Integer> searchDistances(int [] values, int indexOfVertex,int k){
        //int[] arrK=new int[k];
        ArrayList <Integer>arrK=new ArrayList<>();
        int minFromLast=Integer.MAX_VALUE;
       /* for(int i=0;i<arrK.size();i++){
            arrK.add(Integer.MAX_VALUE;
        }*/
        int indexArrK=0;
        // ArrayList<Integer> resultArray=new ArrayList<>();
        for(int i=0;i<values.length;i++){
            if(i!=indexOfVertex){
                int value=Math.abs(values[indexOfVertex]-values[i]);
                // resultArray.add(0,value);
                if(arrK.size()==0){arrK.add(value);continue;}
                if(value<arrK.get(indexArrK)){
                    minFromLast=value;
                    for(int j=0;j<k;j++){//arrK.size()
                        // if(arrK.size()==0)arrK.add(value);
                        if(arrK.get(j)>=value) {
                            arrK.add(j,value);
                            indexArrK++;
                            break;}
                    }

                }else if(indexArrK<k){
                    arrK.add(value);
                    indexArrK++;
                }

            }
        }
        //     System.out.println("");
        //Collections.sort(resultArray);
        // return resultArray;
        //System.out.println("");
        return arrK;
    }


}
