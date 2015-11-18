import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class MainFTP {

	public static void main(String[] args)
			throws SocketException, IOException, IllegalStateException, FTPIllegalReplyException, FTPException,
			FTPDataTransferException, FTPAbortedException, FTPListParseException {
		// TODO Auto-generated method stub
		FTPUsage.usage();
	}
}