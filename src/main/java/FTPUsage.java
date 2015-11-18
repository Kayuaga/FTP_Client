import java.io.IOException;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class FTPUsage {
	
private final static String quit = "q";
private static String command="";
private static String instruction= "Welcome to FTP Client \n if you want to choose folder \n"
		+ " type 'go' than folders name \n if you want to go to the upper directory type 'up ' \n "
		+"if you want to download file \n"
		+"type d than file's name"
		+ "if you want to quit type 'q '" ; 
private static Scanner sc = new Scanner(System.in);
private  FTPUsage(){
	
}


public static void Interface() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException{
	FileWorker.connect();
	FileWorker.showFiles();
	System.out.println(instruction);
	while (!command.equals(quit)) {
		
		System.out.println("Enter the command");
		command = sc.next();
		switch(command) {
	    case "go" : 
	    	System.out.println("Enter the folder's name");
	    	command=sc.next();
	    	FileWorker.DirViewer(command);
	    	
		    
			break;
		case "up" :
		   FileWorker.upDir();
		  
			break;
		case "q" :
			  command="q";
				break;
		case "d" :
			System.out.println("Enter the file's name");
			command=sc.next();
			FileWorker.downloadFile(command);
		
		default: 
			System.out.println("Unknown command");
		    break;
	}
		
	}
	System.out.println("You have quit");

}
}

