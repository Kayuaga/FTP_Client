import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class FileWorker {
	private static FTPClient client = Connector.get();
    private final static String adress="ftp.mccme.ru";
    private final static String user="anonymous";
    private final static String password="ftp4j";
	public static void connect() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {

		try {
			client.connect(adress);
			client.login(user, password);
			Connector.get();

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect");
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
		for (FTPFile f : list) {
			if (f.getType() != 0 && name.equals(f.getName())) {
				client.changeDirectory(name);
				showFiles();
			}
			if (f.getType() == 0&&name.equals(f.getName())) {
				System.out.println("Object is a file, not a directory");
			}
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
						new java.io.File("/Users/uladzimir_paliakou/Desktop/MyRep/" + f.getName()));
			} else {
				System.out.println("Its not a file!");
			}
		}
	}
}
