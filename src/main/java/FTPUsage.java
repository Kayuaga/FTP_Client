import java.io.IOException;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class FTPUsage {

	private final static String QUIT = "q";
	private static String COMMAND = "";
	private static String INSTRUCTION = "Welcome to FTP Client \n if you want to choose folder \n"
			+ " type 'go' than folders name \n if you want to go to the upper directory type 'up ' \n "
			+ "if you want to download file \n" + "type d than file's name" + "if you want to quit type 'q '";
	private static Scanner scanner = new Scanner(System.in);

	private FTPUsage() {

	}

	public static void usage() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FileWorker.connect();
		FileWorker.showFiles();
		System.out.println(INSTRUCTION);
		while (!COMMAND.equals(QUIT)) {

			System.out.println("Enter the command");
			COMMAND = scanner.next();
			switch (COMMAND) {
			case "go":
				System.out.println("Enter the folder's name");
				COMMAND = scanner.next();
				FileWorker.DirViewer(COMMAND);

				break;
			case "up":
				FileWorker.upDir();

				break;
			case "q":
				COMMAND = "q";
				break;
			case "d":
				System.out.println("Enter the file's name");
				COMMAND = scanner.next();
				FileWorker.downloadFile(COMMAND);

			default:
				System.out.println("Unknown command");
				break;
			}

		}
		System.out.println("You have quit");

	}
}
