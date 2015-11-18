import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class FileWorker {
	private static final String DOWNLOAD_DIR = "/Users/uladzimir_paliakou/Desktop/MyRep/";
	private static final int TYPE_FILE = 0;
	private static FTPClient client = Connector.get();
	private final static String ADRESS = "ftp.mccme.ru";
	private final static String USER = "anonymous";
	private final static String PASSWORD = "ftp4j";

	public static void connect() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {

		try {
			client.connect(ADRESS);
			client.login(USER, PASSWORD);
			Connector.get();

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect"+e.getMessage());
		}

	}

	public static void showFiles() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FTPFile[] list = client.list();
		for (FTPFile f : list) {

			System.out.println(f.getName() + f.getType());
		}

	}

	public static void DirViewer(String name) throws IllegalStateException, IOException, FTPIllegalReplyException,
			FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException {
		FTPFile[] list = client.list();
		Boolean indicate = false;
		
		for (FTPFile f : list) {
			if (f.getType() != TYPE_FILE && name.equals(f.getName())) {
				client.changeDirectory(name);
				showFiles();
				indicate = true;

			}
			if (f.getType() == TYPE_FILE && name.equals(f.getName())) {
				System.out.println("Object is a file, not a directory");
				indicate = true;
			}

		}
		if (!indicate) {
			System.out.println("File isnt existed");
		}

	}

	public static void upDir() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {
		client.changeDirectoryUp();
		showFiles();
	}

	public static void downloadFile(String FileName)
			throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException,
			FTPAbortedException, FTPListParseException {

		FTPFile[] list = client.list();
		for (FTPFile f : list) {

			if (f.getType() == 0 && f.getName().equals(FileName)) {

				client.download(f.getName(),
						new java.io.File(DOWNLOAD_DIR + f.getName()));
				System.out.println("File is downloaded");
			} else {
				System.out.println("Its not a file!");
			}
		}
	}
}
