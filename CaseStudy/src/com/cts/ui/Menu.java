package com.cts.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.cts.service.DisplaySummaryService;
import com.cts.service.UploadServiceImpl;

public class Menu {
	public static void main(String[] args) {

		Boolean flag = true;
		Scanner sc = new Scanner(System.in);
		UploadServiceImpl uploadService = new UploadServiceImpl();
		DisplaySummaryService displaySummaryService=new DisplaySummaryService();
		while (flag) {
			System.out.println("1.Upload Report");
			System.out.println("2.Display Summary");
			System.out.println("3.Quit");
			System.out.println("Please choose the option: ");

			int option = sc.nextInt();
			switch (option) {

			case 1:
				try {
					System.out.println("Please enter the file name");
					String filename = sc.next();
					uploadService.uploadData(filename);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Please enter valid file name");
				}
				break;

			case 2:displaySummaryService.displayRecords();
					break;
			case 3:flag=false;
					break;
			default:
				System.out.println("Wrong option entered.Please enter the option again");
			}

		}
	}

}
