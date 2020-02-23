package sa;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TimetableSA {
    
    public static void main(String[] args) throws IOException {
    	
    	long startTime= System.currentTimeMillis();
    	long xtime= System.currentTimeMillis();
    	List<Double> al=new ArrayList<Double>();    	
        Schedule timetable = initializeTimetable();
        
        double temperature=1000;
        double coolingRate=0.05;
        
        SimulatedAnnealing sa = new SimulatedAnnealing(100, 0.9, 2, 5);
        
        // Initialize population
        Population population = sa.initPopulation(timetable);
        
        // Evaluate population
        sa.evalPopulation(population, timetable); //evaluates indiv fitness and calculates total fitness
        
        // Keep track of current iteration
        int iteration = 1;
        double fitnessarr[]=new double[30];
        int it=1,c=0;
        double t,val=0.0;
        double currEnergy,secondEnergy;
        int inc=0;
        
        

        
        long newtime;
        
        
        // Start iteration loop
        while (sa.isTerminationConditionMet(iteration, 1000) == false && sa.isTerminationConditionMet(population) == false && temperature > 0 && (val!=1.0)) {
            // Print fitness
            t=(population.getFittest(0).getFitness());
            currEnergy = population.getFittest(0).getFitness();
            al.add(t);
            fitnessarr[c]=t;
            c++;
            inc++;
            newtime= System.currentTimeMillis();
            
        
        	xtime=newtime;
                
            // finding neighbors of current solution
            population = sa.findNeighbors(population);

            // Evaluate population
            secondEnergy=sa.evalPopulation(population, timetable);


            // Increment the current iteration
            iteration++;
            
            if(currEnergy > secondEnergy)
    			val= 1.0;
            else
            	val = Math.exp((currEnergy - secondEnergy) / temperature); 
            
            temperature=temperature*coolingRate;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));																
        
        // Print classes
        System.out.println();
        ArrayList<Double> roomnum = new ArrayList<>();
        
        Class classes[] = timetable.getClasses();
        int classIndex = 1;
         String sx1="", sx2="", sx3="", sx4="", sx5="", sx6="", sx7="", sx8="";
         String sx9="", sx10="", sx11="", sx12="", sx13="", sx14="", sx15="", sx16="";
         String sx17="",sx18="",sx19="",sx20="",sx21="",sx22="",sx23="",sx24="";
         String sx25="",sx26="",sx27="",sx30="",sx28="",sx29="";
         String  sx31="", sx32="", sx33="", sx34="", sx35="", sx36="", sx37="", sx38="", sx39="", sx40="";
         String sx41="",sx42="",sx43="",sx44="",sx45="",sx46="",sx47="",sx48="",sx49="",sx50="",sx51="",sx52="",sx53="",sx54="",sx55="",sx56="",sx57="",sx58="",sx59="",sx60="";																																											    Collections.sort(al);	
               
         System.out.println();
         for(Double num: al){
        	 	System.out.println("Iteration : "+it+" Fitness value : "+num);
        	 	it++;
         }
         System.out.println("Solution found in Iteration Number: " + iteration );
         System.out.println("Final Fitness Value for Iteration "+ iteration +" : " + population.getFittest(0).getFitness());
         System.out.println("Total Number of Penalties: " + timetable.calcClashes());

        for (Class bestClass : classes) {
           // System.out.println("Class " + classIndex + ":");
            String room ="";
            String module ="";
            String prof ="";
            String time ="";
            int group;

            
            room= timetable.getRoom(bestClass.getRoomId()).getRoomNumber();
            group=timetable.getGroup(bestClass.getGroupId()).getGroupId();
            module=timetable.getModule(bestClass.getModuleId()).getModuleName();
            prof= timetable.getProfessor(bestClass.getProfessorId()).getProfessorName();
            time= timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot();
            
            if(room.equals("TW1TF3"))
        	{
        		if(time.equals("Mon 08:00 - 09:00"))
        		{
        			sx1=module;
        		}
        		if(time.equals("Mon 09:00 - 10:00"))
        		{
        			sx2=module;
        		}
        		if(time.equals("Mon 10:00 - 11:00"))
        		{
        			sx3=module;
        		}
        		if(time.equals("Mon 11:00 - 12:00"))
        		{
        			sx4=module;
        		}
        		
        		if(time.equals("Tue 08:00 - 09:00"))
        		{
        			sx5=module;
        		}
        		if(time.equals("Tue 09:00 - 10:00"))
        		{
        			sx6=module;
        		}
        		if(time.equals("Tue 10:00 - 11:00"))
        		{
        			sx7=module;
        		}
        		if(time.equals("Tue 11:00 - 12:00"))
        		{
        			sx8=module;
        		}
        		
        		
        		if(time.equals("Wed 08:00 - 09:00"))
        		{
        			sx9=module;
        		}
        		if(time.equals("Wed 09:00 - 10:00"))
        		{
        			sx10=module;
        		}
        		if(time.equals("Wed 10:00 - 11:00"))
        		{
        			sx11=module;
        		}
        		if(time.equals("Wed 11:00 - 12:00"))
        		{
        			sx12=module;
        		}
        		
        		if(time.equals("Thu 08:00 - 09:00"))
        		{
        			sx13=module;
        		}
        		if(time.equals("Thu 09:00 - 10:00"))
        		{
        			sx14=module;
        		}
        		if(time.equals("Thu 10:00 - 11:00"))
        		{
        			sx15=module;
        		}
        		if(time.equals("Thu 11:00 - 12:00"))
        		{
        			sx16=module;
        		}
        		
        		if(time.equals("Fri 08:00 - 09:00"))
        		{
        			sx17=module;
        		}
        		if(time.equals("Fri 09:00 - 10:00"))
        		{
        			sx18=module;
        		}
        		if(time.equals("Fri 10:00 - 11:00"))
        		{
        			sx19=module;
        		}
        		if(time.equals("Fri 11:00 - 12:00"))
        		{
        			sx20=module;
        		}
        		
 
        	}
        	if(room.equals("TW2GF2"))
        	{
        		
         		if(time.equals("Mon 08:00 - 09:00"))
        		{
        			sx21=module ;
        		}
        		if(time.equals("Mon 09:00 - 10:00"))
        		{
        			sx22=module;
        		}
        		if(time.equals("Mon 10:00 - 11:00"))
        		{
        			sx23=module;
        		}
        		if(time.equals("Mon 11:00 - 12:00"))
        		{
        			sx24=module;
        		}
        		
        		if(time.equals("Tue 08:00 - 09:00"))
        		{
        			sx25=module ;
        		}
        		if(time.equals("Tue 09:00 - 10:00"))
        		{
        			sx26=module;
        		}
        		if(time.equals("Tue 10:00 - 11:00"))
        		{
        			sx27=module;
        		}
        		if(time.equals("Tue 11:00 - 12:00"))
        		{
        			sx28=module;
        		}
        		
        		
        		if(time.equals("Wed 08:00 - 09:00"))
        		{
        			sx29=module;
        		}
        		if(time.equals("Wed 09:00 - 10:00"))
        		{
        			sx30=module;
        		}
        		if(time.equals("Wed 10:00 - 11:00"))
        		{
        			sx31=module;
        		}
        		if(time.equals("Wed 11:00 - 12:00"))
        		{
        			sx32=module;
        		}
        		
        		if(time.equals("Thu 08:00 - 09:00"))
        		{
        			sx33=module;
        		}
        		if(time.equals("Thu 09:00 - 10:00"))
        		{
        			sx34=module;
        		}
        		if(time.equals("Thu 10:00 - 11:00"))
        		{
        			sx35=module;
        		}
        		if(time.equals("Thu 11:00 - 12:00"))
        		{
        			sx36=module;
        		}
        		
        		if(time.equals("Fri 08:00 - 09:00"))
        		{
        			sx37=module;
        		}
        		if(time.equals("Fri 09:00 - 10:00"))
        		{
        			sx38=module;
        		}
        		if(time.equals("Fri 10:00 - 11:00"))
        		{
        			sx39=module;
        		}
        		if(time.equals("Fri 11:00 - 12:00"))
        		{
        			sx40=module;
        		}
        		
        		
}

        	if(room.equals("TW3TF3"))
        	{
            		
        		
         		if(time.equals("Mon 08:00 - 09:00"))
        		{
        			sx41=module;
        		}
        		if(time.equals("Mon 09:00 - 10:00"))
        		{
        			sx42=module;
        		}
        		if(time.equals("Mon 10:00 - 11:00"))
        		{
        			sx43=module ;
        		}
        		if(time.equals("Mon 11:00 - 12:00"))
        		{
        			sx44=module;
        		}
        		
        		if(time.equals("Tue 08:00 - 09:00"))
        		{
        			sx45=module ;
        		}
        		if(time.equals("Tue 09:00 - 10:00"))
        		{
        			sx46=module;
        		}
        		if(time.equals("Tue 10:00 - 11:00"))
        		{
        			sx47=module;
        		}
        		if(time.equals("Tue 11:00 - 12:00"))
        		{
        			sx48=module;
        		}
        		
        		
        		if(time.equals("Wed 08:00 - 09:00"))
        		{
        			sx49=module;
        		}
        		if(time.equals("Wed 09:00 - 10:00"))
        		{
        			sx50=module;
        		}
        		if(time.equals("Wed 10:00 - 11:00"))
        		{
        			sx51=module;
        		}
        		if(time.equals("Wed 11:00 - 12:00"))
        		{
        			sx52=module;
        		}
        		
        		if(time.equals("Thu 08:00 - 09:00"))
        		{
        			sx53=module ;
        		}
        		if(time.equals("Thu 09:00 - 10:00"))
        		{
        			sx54=module ;
        		}
        		if(time.equals("Thu 10:00 - 11:00"))
        		{
        			sx55=module ;
        		}
        		if(time.equals("Thu 11:00 - 12:00"))
        		{
        			sx56=module;
        		}
        		
        		if(time.equals("Fri 08:00 - 09:00"))
        		{
        			sx57=module;
        		}
        		if(time.equals("Fri 09:00 - 10:00"))
        		{
        			sx58=module;
        		}
        		if(time.equals("Fri 10:00 - 11:00"))
        		{
        			sx59=module;
        		}
        		if(time.equals("Fri 11:00 - 12:00"))
        		{
        			sx60=module;
        		}
        		
     
            	
        	}
        
            
           // System.out.println("-----");
            classIndex++;
        }
        long endTime= System.currentTimeMillis();
        System.out.println("Execution Time : "+(endTime-startTime)+" milli seconds");
        System.out.println("                                                           ");

        System.out.println("----------------------Room: TW1TF3-----------------------------------");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("  Monday:    08:00 -09:00 : "+sx1);
        System.out.println("  Monday:    09:00 -10:00 : "+sx2);
        System.out.println("  Monday:    10:00 -11:00 : "+sx3);
        System.out.println("  Monday:    11:00 -12:00 : "+sx4);
  
        System.out.println("  Tuesday:    08:00 -09:00 : "+sx5);
        System.out.println("  Tuesday:    09:00 -10:00 : "+sx6);
        System.out.println("  Tuesday:    10:00 -11:00 : "+sx7);
        System.out.println("  Tuesday:    11:00 -12:00 : "+sx8);
       
        System.out.println("  Wednesday:    08:00 -09:00 : "+sx9);
        System.out.println("  Wednesday:    09:00 -10:00 : "+sx10);
        System.out.println("  Wednesday:    10:00 -11:00 : "+sx11);
        System.out.println("  Wednesday:    11:00 -12:00 : "+sx12);
       
        System.out.println("  Thursday:    08:00 -09:00 : "+sx13);
        System.out.println("  Thursday:    09:00 -10:00 : "+sx14);
        System.out.println("  Thursday:    10:00 -11:00 : "+sx15);
        System.out.println("  Thursday:    11:00 -12:00 : "+sx16);
         
        System.out.println("  Friday:    08:00 -09:00 : "+sx17);
        System.out.println("  Friday:    09:00 -10:00 : "+sx18);
        System.out.println("  Friday:    10:00 -11:00 : "+sx19);
        System.out.println("  Friday:    11:00 -12:00 : "+sx20);
         
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                                                           ");

        System.out.println("----------------------Room: TW2GF2------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        
        
        System.out.println("  Monday:    08:00 -09:00 : "+sx21);
        System.out.println("  Monday:    09:00 -10:00 : "+sx22);
        System.out.println("  Monday:    10:00 -11:00 : "+sx23);
        System.out.println("  Monday:    11:00 -12:00 : "+sx24);
  
        System.out.println("  Tuesday:    08:00 -09:00 : "+sx25);
        System.out.println("  Tuesday:    09:00 -10:00 : "+sx26);
        System.out.println("  Tuesday:    10:00 -11:00 : "+sx27);
        System.out.println("  Tuesday:    11:00 -12:00 : "+sx28);
       
        System.out.println("  Wednesday:    08:00 -09:00 : "+sx29);
        System.out.println("  Wednesday:    09:00 -10:00 : "+sx30);
        System.out.println("  Wednesday:    10:00 -11:00 : "+sx31);
        System.out.println("  Wednesday:    11:00 -12:00 : "+sx32);
       
        System.out.println("  Thursday:    08:00 -09:00 : "+sx33);
        System.out.println("  Thursday:    09:00 -10:00 : "+sx34);
        System.out.println("  Thursday:    10:00 -11:00 : "+sx35);
        System.out.println("  Thursday:    11:00 -12:00 : "+sx36);
         
        System.out.println("  Friday:    08:00 -09:00 : "+sx37);
        System.out.println("  Friday:    09:00 -10:00 : "+sx38);
        System.out.println("  Friday:    10:00 -11:00 : "+sx39);
        System.out.println("  Friday:    11:00 -12:00 : "+sx40);
          
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                                                           ");

        System.out.println("----------------------Room: TW3TF3------------------------------------");
  
        System.out.println("  Monday:    08:00 -09:00 : "+sx41);
        System.out.println("  Monday:    09:00 -10:00 : "+sx42);
        System.out.println("  Monday:    10:00 -11:00 : "+sx43);
        System.out.println("  Monday:    11:00 -12:00 : "+sx44);
  
        System.out.println("  Tuesday:    08:00 -09:00 : "+sx45);
        System.out.println("  Tuesday:    09:00 -10:00 : "+sx46);
        System.out.println("  Tuesday:    10:00 -11:00 : "+sx47);
        System.out.println("  Tuesday:    11:00 -12:00 : "+sx48);
       
        System.out.println("  Wednesday:    08:00 -09:00 : "+sx49);
        System.out.println("  Wednesday:    09:00 -10:00 : "+sx50);
        System.out.println("  Wednesday:    10:00 -11:00 : "+sx51);
        System.out.println("  Wednesday:    11:00 -12:00 : "+sx52);
       
        System.out.println("  Thursday:    08:00 -09:00 : "+sx53);
        System.out.println("  Thursday:    09:00 -10:00 : "+sx54);
        System.out.println("  Thursday:    10:00 -11:00 : "+sx55);
        System.out.println("  Thursday:    11:00 -12:00 : "+sx56);
         
        System.out.println("  Friday:    08:00 -09:00 : "+sx57);
        System.out.println("  Friday:    09:00 -10:00 : "+sx58);
        System.out.println("  Friday:    10:00 -11:00 : "+sx59);
        System.out.println("  Friday:    11:00 -12:00 : "+sx60);
                
        System.out.println("-----------------------------------------------------------------");
        
        
        //create file
        FileWriter fileWriter = null;
        
        File f = new File("/Users/Aparna/Documents/researchwork/ttsa_e_tf1tf3.csv");
        if(f.exists())
        {
        	f.delete();
        	}
        
        try 
        {
    		f.createNewFile();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	fileWriter = new FileWriter("/Users/Aparna/Documents/researchwork/ttsa_e_tf1tf3.csv");
    	
    	if(sx1.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}

    	
    	else
    	{
    		fileWriter.append(sx1);
    		fileWriter.append(',');
    	}

    	
    	if(sx2.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}

    	else
    	{
    		fileWriter.append(sx2);
    		fileWriter.append(',');
    	}

    	
    	if(sx3.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx3);
    		fileWriter.append(',');
    	}
    	
    	if(sx4.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	
    	else
    	{
    		fileWriter.append(sx4);
    		fileWriter.append(',');
    	}
    	
    	fileWriter.append("\n");
        
    	if(sx5.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx5);
    		fileWriter.append(',');
    	}
    	
    	if(sx6.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx6);
    		fileWriter.append(',');
    	}
    	
    	if(sx7.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx7);
    		fileWriter.append(',');
    	}
    	
    	if(sx8.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx8);
    		fileWriter.append(',');
    	}
    	
        fileWriter.append("\n");
        
    	if(sx9.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx9);
    		fileWriter.append(',');
    	}
    	
    	if(sx10.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx10);
    		fileWriter.append(',');

    	}
    	
    	if(sx11.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx11);
    		fileWriter.append(',');
    	}
    	
    	if(sx12.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx12);
    		fileWriter.append(',');
    	}
        fileWriter.append("\n");
        
    	if(sx13.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx13);
    		fileWriter.append(',');
    	}
    	
    	if(sx14.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx14);
    		fileWriter.append(',');
    	}
    	
    	if(sx15.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx15);
    		fileWriter.append(',');
    	}
    	
    	if(sx16.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx16);
    		fileWriter.append(',');
    	}
        fileWriter.append("\n");
        
    	if(sx17.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx17);
    		fileWriter.append(',');
    	}
    	
    	if(sx18.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx18);
    		fileWriter.append(',');
    	}
    	
    	if(sx19.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	else
    	{
    		fileWriter.append(sx19);
    		fileWriter.append(',');
    	}
    	
    	if(sx20.isEmpty())
    	{
    		fileWriter.append(" ");
    		fileWriter.append(',');
    	}
    	
    	else
    	{
    		fileWriter.append(sx20);
    		fileWriter.append(',');
    	}
        

        fileWriter.flush();
        fileWriter.close();
        
        FileWriter fw2 = null;
        
        File f2 = new File("/Users/Aparna/Documents/researchwork/ttsa_e_tf2gf2.csv");
        if(f2.exists())
        {
        	f2.delete();
        	}
        
        try 
        {
    		f2.createNewFile();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	fw2 = new FileWriter("/Users/Aparna/Documents/researchwork/ttsa_e_tf2gf2.csv");
    	
    	if(sx21.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}

    	
    	else
    	{
    		fw2.append(sx21);
    		fw2.append(',');
    	}

    	
    	if(sx22.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}

    	else
    	{
    		fw2.append(sx22);
    		fw2.append(',');
    	}

    	
    	if(sx23.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx23);
    		fw2.append(',');
    	}
    	
    	if(sx24.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	
    	else
    	{
    		fw2.append(sx24);
    		fw2.append(',');
    	}
    	
    	fw2.append("\n");
        
    	if(sx25.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx25);
    		fw2.append(',');
    	}
    	
    	if(sx26.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx26);
    		fw2.append(',');
    	}
    	
    	if(sx27.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx27);
    		fw2.append(',');
    	}
    	
    	if(sx28.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx28);
    		fw2.append(',');
    	}
    	
    	fw2.append("\n");
        
    	if(sx29.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx29);
    		fw2.append(',');
    	}
    	
    	if(sx30.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx30);
    		fw2.append(',');

    	}
    	
    	if(sx31.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx31);
    		fw2.append(',');
    	}
    	
    	if(sx32.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx32);
    		fw2.append(',');
    	}
        fw2.append("\n");
        
    	if(sx33.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx33);
    		fw2.append(',');
    	}
    	
    	if(sx34.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx34);
    		fw2.append(',');
    	}
    	
    	if(sx35.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx35);
    		fw2.append(',');
    	}
    	
    	if(sx36.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx36);
    		fw2.append(',');
    	}
    	fw2.append("\n");
        
    	if(sx37.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx37);
    		fw2.append(',');
    	}
    	
    	if(sx38.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx38);
    		fw2.append(',');
    	}
    	
    	if(sx39.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	else
    	{
    		fw2.append(sx39);
    		fw2.append(',');
    	}
    	
    	if(sx40.isEmpty())
    	{
    		fw2.append(" ");
    		fw2.append(',');
    	}
    	
    	else
    	{
    		fw2.append(sx40);
    		fw2.append(',');
    	}
        

    	fw2.flush();
        fw2.close();
        
        
        
FileWriter fw3 = null;
        
        File f3 = new File("/Users/Aparna/Documents/researchwork/ttsa_e_tf3tf3.csv");
        if(f3.exists())
        {
        	f3.delete();
        	}
        
        try 
        {
    		f3.createNewFile();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

        fw3 = new FileWriter("/Users/Aparna/Documents/researchwork/ttsa_e_tf3tf3.csv");
    	
    	if(sx41.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}

    	
    	else
    	{
    		fw3.append(sx41);
    		fw3.append(',');
    	}

    	
    	if(sx42.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}

    	else
    	{
    		fw3.append(sx42);
    		fw3.append(',');
    	}

    	
    	if(sx43.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx43);
    		fw3.append(',');
    	}
    	
    	if(sx44.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	
    	else
    	{
    		fw3.append(sx44);
    		fw3.append(',');
    	}
    	
    	fw3.append("\n");
        
    	if(sx45.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx45);
    		fw3.append(',');
    	}
    	
    	if(sx46.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx46);
    		fw3.append(',');
    	}
    	
    	if(sx47.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx47);
    		fw3.append(',');
    	}
    	
    	if(sx48.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx48);
    		fw3.append(',');
    	}
    	
    	fw3.append("\n");
        
    	if(sx49.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx49);
    		fw3.append(',');
    	}
    	
    	if(sx50.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx50);
    		fw3.append(',');

    	}
    	
    	if(sx51.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx51);
    		fw3.append(',');
    	}
    	
    	if(sx52.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx52);
    		fw3.append(',');
    	}
    	fw3.append("\n");
        
    	if(sx53.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx53);
    		fw3.append(',');
    	}
    	
    	if(sx54.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx54);
    		fw3.append(',');
    	}
    	
    	if(sx55.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx55);
    		fw3.append(',');
    	}
    	
    	if(sx56.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx56);
    		fw3.append(',');
    	}
    	fw3.append("\n");
        
    	if(sx57.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx57);
    		fw3.append(',');
    	}
    	
    	if(sx58.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx58);
    		fw3.append(',');
    	}
    	
    	if(sx59.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	else
    	{
    		fw3.append(sx59);
    		fw3.append(',');
    	}
    	
    	if(sx60.isEmpty())
    	{
    		fw3.append(" ");
    		fw3.append(',');
    	}
    	
    	else
    	{
    		fw3.append(sx60);
    		fw3.append(',');
    	}
        

    	fw3.flush();
    	fw3.close();
        
    }
   

    /**
     * Creates a Timetable with all the necessary course information.
     * 
     * Normally you'd get this info from a database.
     * 
     * @return
     */
	private static Schedule initializeTimetable() {
		// Create timetable
		Schedule timetable = new Schedule();

		// Set up rooms
				timetable.addRoom(1, "TW1TF3", 200);
				timetable.addRoom(2, "TW2GF2", 200);
				timetable.addRoom(3, "TW3TF3", 300);


				// Set up timeslots
				timetable.addTimeslot(1, "Mon 08:00 - 09:00");
				timetable.addTimeslot(2, "Mon 09:00 - 10:00");
				timetable.addTimeslot(3, "Mon 10:00 - 11:00");
				timetable.addTimeslot(4, "Mon 11:00 - 12:00");


				timetable.addTimeslot(5, "Tue 08:00 - 09:00");
				timetable.addTimeslot(6, "Tue 09:00 - 10:00");
				timetable.addTimeslot(7, "Tue 10:00 - 11:00");
				timetable.addTimeslot(8, "Tue 11:00 - 12:00");

				timetable.addTimeslot(9, "Wed 08:00 - 09:00");
				timetable.addTimeslot(10, "Wed 09:00 - 10:00");
				timetable.addTimeslot(11, "Wed 10:00 - 11:00");
				timetable.addTimeslot(12, "Wed 11:00 - 12:00");
				
				timetable.addTimeslot(13, "Thu 08:00 - 09:00");
				timetable.addTimeslot(14, "Thu 09:00 - 10:00");
				timetable.addTimeslot(15, "Thu 10:00 - 11:00");
				timetable.addTimeslot(16, "Thu 11:00 - 12:00");
				
				timetable.addTimeslot(17, "Fri 08:00 - 09:00");
				timetable.addTimeslot(18, "Fri 09:00 - 10:00");
				timetable.addTimeslot(19, "Fri 10:00 - 11:00");
				timetable.addTimeslot(20, "Fri 11:00 - 12:00");

				// Set up professors
				timetable.addProfessor(1, "KS ");
				timetable.addProfessor(2, "NJ");
				timetable.addProfessor(3, "AB");





				// Set up modules and define the professors that teach them
				timetable.addModule(1, "ml1", "ML Theory", new int[] { 3 });
				timetable.addModule(2, "ml2", "ML Theory", new int[] { 3 });
				timetable.addModule(3, "ml3", "ML Theory", new int[] { 3 });
				timetable.addModule(4, "ml4", "ML -T- G1", new int[] { 3 });
				timetable.addModule(5, "ml5", "ML -T- G2", new int[] { 3 });
				timetable.addModule(6, "ml6", "ML -T- G3", new int[] { 3 });
				timetable.addModule(7, "ml7", "ML -T- G4", new int[] { 3 });
				timetable.addModule(8, "cfcc1", "CFCC A Theory", new int[] { 3 });
				timetable.addModule(9, "cfcc2", "CFCC A Theory", new int[] { 3 });
				timetable.addModule(10, "cfcc3", "CFCC A Theory", new int[] { 3 });

				timetable.addModule(11, "cfcc4", "CFCC B Theory", new int[] { 3 });
				timetable.addModule(12, "cfcc5", "CFCC B Theory", new int[] { 3 });
				timetable.addModule(13, "cfcc6", "CFCC B Theory", new int[] { 3 });
				timetable.addModule(14, "cfcc7", "CFCC - A- T- G1", new int[] { 3 });
				timetable.addModule(15, "cfcc8", "CFCC - B- T- G1", new int[] { 3 });
				timetable.addModule(16, "cfcc9", "CFCC - A- T- G2", new int[] { 3 });
				timetable.addModule(17, "cfcc10", "CFCC - B- T- G2", new int[] { 3 });
				
				
				// Set up student groups and the modules they take.
				timetable.addGroup(1, 256, new int[] { 1});
				timetable.addGroup(2, 256, new int[] { 2});
				timetable.addGroup(3, 256, new int[] { 3});

				timetable.addGroup(4, 64, new int[] { 4});
				timetable.addGroup(5, 64, new int[] { 5});
				timetable.addGroup(6, 64, new int[] { 6 });
				timetable.addGroup(7, 64, new int[] { 7 });

				timetable.addGroup(8, 128, new int[] {  8 });
				timetable.addGroup(9, 128, new int[] {  9 });
				timetable.addGroup(10, 128, new int[] {  10 });

				timetable.addGroup(11, 128, new int[] { 11 });
				timetable.addGroup(12, 128, new int[] { 12 });
				timetable.addGroup(13, 128, new int[] { 13 });

				timetable.addGroup(14, 64, new int[] { 14 });
				timetable.addGroup(15, 64, new int[] { 15 });
				timetable.addGroup(16, 64, new int[] { 16 });
				timetable.addGroup(17, 64, new int[] { 17 });




				return timetable;
	}
}
