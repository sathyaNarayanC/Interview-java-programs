import java.io.*;
import java.util.*;
public class TaxiApplication {
    static List<Data> bookedDetails = new ArrayList<Data>();
    static List<String> taxiDetails = new ArrayList<String>();
    static Map<String,Integer> pointCode = new HashMap<>();
    static int smallest = 0,smallestDist =0;
    public static void main(String args[])throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        //point code details
        pointCode.put("A",1);
        pointCode.put("B",2);
        pointCode.put("C",3);
        pointCode.put("D",4);
        pointCode.put("E",5);
        pointCode.put("F",6);
        
        
        //taxiInitial Details
        taxiDetails.add("1AA0");
        taxiDetails.add("2AA0");
        taxiDetails.add("3AA0");
        taxiDetails.add("4AA0");
        
        //getting input details
        for(int  i = 0; i < 3 ; i++){
            System.out.println("Input "+(i+1));
            System.out.println("customer ID : ");
            int id = Integer.parseInt(input.readLine());
            System.out.println("pickup : ");
            String pickup = input.readLine();
            System.out.println("drop : ");
            String drop = input.readLine();
            System.out.println("pickupTIme : ");
            int hr = Integer.parseInt(input.readLine());
            allocateTaxi(id, pickup,drop, hr);
        }
        System.out.println(taxiDetails);
        for(Data d : bookedDetails)
        System.out.println(d.custid+" "+d.droppt +" "+d.pickup+ " "+ d.hrs+ " "+d.taxiNum);
    }
    
    static void allocateTaxi(int id, String pickup, String drop, int hrs){
        int taxiNum = avaliableTaxi(pickup,drop,hrs);
        if(taxiNum == 0){
            System.out.println("Taxi booking failed");
        }
        else{
            System.out.println("your taxi is booked successfully");
            System.out.println("your taxi Number is "+taxiNum);
            bookedDetails.add(new Data(id,pickup,drop,hrs,taxiNum));
        }
    }
    
    static int avaliableTaxi(String pick, String drop, int hr){
        for(int i = 0 ; i < taxiDetails.size();i++){
            String taxiDet = taxiDetails.get(i);
            if(taxiDet.substring(2,3).equals(pick) && (Integer.parseInt(taxiDet.substring(3)) == 0 || (Integer.parseInt(taxiDet.substring(3)) <= hr))){
                taxiDetails.set(i,(i+1)+pick+drop+(hr+Math.abs(pointCode.get(drop) - pointCode.get(pick))));
                return i+1;
            }
        }
        int taxiBooked = nearestTaxi(pick,drop,hr);
        if(taxiBooked != 0){
            taxiDetails.set(taxiBooked,taxiBooked+pick+drop+(hr+Math.abs(pointCode.get(taxiDetails.get(taxiBooked).substring(2,3)) - pointCode.get(pick))));
            return taxiBooked;
        }
        for(int i = 0 ; i < taxiDetails.size();i++){
            String taxiDet = taxiDetails.get(i);
            if(Integer.parseInt(taxiDet.substring(3)) == 0){
                taxiDetails.set(i,(i+1)+pick+drop+(hr+Math.abs(pointCode.get(drop) - pointCode.get(pick))));
                return i+1;
            }
        }
        return 0;
    }
    
    static int nearestTaxi(String pick, String drop, int hr){
        for(int  i = 0 ; i < taxiDetails.size();i++){
            String taxiDet = taxiDetails.get(i);
            int totalTime = Integer.parseInt(taxiDet.substring(3)) + Math.abs(pointCode.get(taxiDet.substring(2,3)) - pointCode.get(pick));
            if(pointCode.get(drop) > totalTime && smallestDist > totalTime){
                smallestDist = totalTime;
                smallest = i+1;
            }
        }
        if(smallest != 0)
            return smallest;
        return 0;
    }
    
    static class Data{
        int custid,hrs;
        String pickup,droppt;
        int taxiNum;
        
        Data(int id, String pick, String drop, int hr, int taxiNo){
            custid = id;
            pickup = pick;
            droppt = drop;
            hrs = hr;
            taxiNum = taxiNo;
        }
    }
}
