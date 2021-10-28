package com.sgtesting.programs;
interface University
{
	void displayUniversityName(String name);
}

interface College
{
	void displayCollegeName(String name);
}

class SLNEngg implements University,College
{
	public void displayUniversityName(String name)
	{
		System.out.println("University Name :"+name);
	}
	
	public void displayCollegeName(String name)
	{
		System.out.println("Enginerring College Name :"+name);
	}
}
public class InterfaceDemo {
	public static void main(String[] args) {
		University obj=new SLNEngg();
		
		College obj1=(College) obj;
		obj1.displayCollegeName("SLN Engg College");

	}

}
