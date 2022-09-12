package GmailAPILib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

public class GmailPractice01 {

	private static final String APPLICATION_NAME = "checkersoftware";
	private static final String USER_ID = "me";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	private static final String CREDENTIALS_FILE_PATH =  
    		System.getProperty("user.dir") +
             File.separator + "src" +
             File.separator + "main" +
             File.separator + "resources" +
             File.separator + "credentials" +
             File.separator + "credential.json";
    
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "main" +
            File.separator + "resources" +
            File.separator + "credentials";
	
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
	 
	    private static List<Message> getMessages(ListMessagesResponse response) {
         List<Message> messages = new ArrayList<Message>();
         try {
             final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
             Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                     .setApplicationName(APPLICATION_NAME)
                     .build();
             while (response.getMessages() != null) {
                 messages.addAll(response.getMessages());
                 if (response.getNextPageToken() != null) {
                     String pageToken = response.getNextPageToken();
                     response = service.users().messages().list(USER_ID)
                             .setPageToken(pageToken).execute();
                 } else {
                     break;
                 }
             }
             return messages;
         } catch (Exception e) {
             System.out.println("Exception log " + e);
             return messages;
         }
     }
	 
	public static boolean isMailExist(String messageTitle) {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            ListMessagesResponse response = service.
                    users().
                    messages().
                    list("me").
                    setQ("subject:" + messageTitle).
                    execute();
            List<Message> messages = getMessages(response);
            return messages.size() != 0;
        } catch (Exception e) {
            System.out.println("Exception log" + e);
            return false;
        }
    }
	 public static Gmail getService() throws IOException, GeneralSecurityException {
	        // Build a new authorized API client service.
	        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	                .setApplicationName(APPLICATION_NAME)
	                .build();
	        return service;
	    }
	
	public static String EmailBody(String MessageBody) {
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
					.setApplicationName(APPLICATION_NAME)
					.build();
			ListMessagesResponse response = service.users().messages().list("me").setQ("from:"+"").execute();
			String messageid = response.getMessages().get(0).getId();
			Message message = service.users().messages().get(USER_ID, messageid).execute();
			String emailBody = StringUtils.newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
			System.out.println("Email Body :"+ emailBody);
		}catch(Exception e) {
			
		}
		
		return MessageBody;
	}
	
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		Gmail service = getService();
		
		
	   

	}

}
