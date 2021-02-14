package com.ncu.samsahil.MavenSpring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewLoan {
	private Sourcing sourcing;
	private DataEntry de;
	

	public DataEntry getDe() {
		return de;
	}

	public void setDe(DataEntry de) {
		this.de = de;
	}

	public Sourcing getSourcing() {
		return sourcing;
	}

	public void setSourcing(Sourcing sourcing) {
		this.sourcing = sourcing;
	}
	
	public boolean loanStatus(DataEntry de,Sourcing sourcing) throws IOException {
		boolean status = true;
		String loanInfo = de.getAdhar()+de.getPan()+sourcing.getPhoneNum() + sourcing.getEmail();
		BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Loan.txt"));
		String line1 = reader1.readLine();
		  int lineNum = 1;
	         
	        while (line1 != null)
	        {
	            if(line1 == null)
	            {
	                status = false;

	                break;
	            }
	            else if(! line1.equalsIgnoreCase(loanInfo))
	            {
	                status = false;
	                 
	                break;
	            }
	             
	            line1 = reader1.readLine();
       
	            lineNum++;
	        }
		return status;
	}
	
	public int Scoring(DataEntry de,Sourcing sourcing) {
		int score =0;
		if(sourcing.getAge()<=20) {
			score+=2;
		}else if (sourcing.getAge()<30) {
			score+=1;
		}
		
		if(de.getEducation().equalsIgnoreCase("graduate")) {
			score +=2;
		}else if(de.getEducation().equalsIgnoreCase("undergraduate")) {
			score +=1;
		}
		
		if(de.generateIncome()>=10000) {
			score+=2;
		}else if(de.generateIncome()<10000) {
			score+=2;
		}
		return score;
	}
}
