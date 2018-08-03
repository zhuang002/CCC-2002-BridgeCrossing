/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecrossing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class BridgeCrossing {
    static Record[] records;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        records=new Record[n];
        
        for (int i=0;i<n;i++) {
            sc.nextLine();
            Record record=new Record();
            record.name=sc.nextLine();
            record.time=sc.nextInt();
            records[i]=record;
        }
        
        Arrays.sort(records, (a,b)->{
            return a.time-b.time;
        });
        
        int timeRequired=0;
        ArrayList<ArrayList<Record>> groups=new ArrayList();
        int i=records.length-1;
        while (i>=0)
        {
            ArrayList<Record> group=new ArrayList();
            for (int j=0;j<m;j++) {
                if (j==0)
                    timeRequired+=records[i].time;
                group.add(records[i]);
                i--;
                if (i<0) break;
            }
            groups.add(group);
        }
        
        System.out.println("Total Time: "+timeRequired);
        for (i=groups.size()-1;i>=0;i--) {
            ArrayList<Record> group=groups.get(i);
            for (int j=0;j<group.size();j++) {
                System.out.print(group.get(j).name+" ");
            }
            System.out.println();
        }
    }
    
}

class Record {
    String name;
    Integer time;
}
