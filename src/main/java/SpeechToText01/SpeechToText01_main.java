package SpeechToText01;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechToText01_main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SpeechToText service = new SpeechToText();
		IamOptions options = new IamOptions.Builder()
		  .apiKey("＊＊＊＊＊")
		  .build();
		service.setIamCredentials(options);

		File audio = new File("src/test/resources/01-1-01_Drill1.mp3");

		RecognizeOptions options1 = null;
		try {
			options1 = new RecognizeOptions.Builder()
			  .audio(audio)
			  .contentType(HttpMediaType.AUDIO_MP3)
			  .build();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		SpeechRecognitionResults transcript = service.recognize(options1).execute().getResult();
		System.out.println(transcript);

	}

}
