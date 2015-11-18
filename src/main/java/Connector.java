import it.sauronsoftware.ftp4j.FTPClient;
// 
public class Connector {
	
private static FTPClient client;
		private  Connector(){
			
		}
		public static synchronized FTPClient get() {
			if (client == null) {
				client = new FTPClient();
			}
			return client;
		}
	}

