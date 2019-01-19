package videoRecording.video;

/*author - Saurabh bhandari
email - sourabhsingh66@gmail.com
ping me once if you any doubt 
Thanks
*/
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

public class VideoUtlity extends ScreenRecorder {

	public VideoUtlity(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder) throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);

	}

	public static ScreenRecorder screenRecorder;
	public static String filename = "user.dir";

	public static void videostart() throws Exception, Exception {

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screensize.width;
		int height = screensize.height;
		Rectangle capture = new Rectangle(0, 0, width, height);

		screenRecorder = new VideoUtlity(gc, capture, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, new File(filename)

		);

		screenRecorder.start(); // method to start the video recording

	}

	public static void videostops() {
		try {
			System.out.println(screenRecorder.getState()); // it will show the message in console about the current
															// state of video recording

			screenRecorder.stop(); // it will stop the video
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(screenRecorder.getStateMessage());
	}

}