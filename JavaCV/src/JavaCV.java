import org.bytedeco.javacpp.indexer.IntRawIndexer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgproc;


import static org.bytedeco.javacpp.opencv_core.CV_PI;
import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.waitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class JavaCV {
    public static void main(String[] args){

        opencv_core.Mat img = imread("img.png");
        opencv_core.Mat gray, blurred, thresholded, edges;
        gray =blurred = thresholded = edges =null;
        gray = new opencv_core.Mat();
        edges = new opencv_core.Mat();
        cvtColor(img, gray, COLOR_BGR2GRAY);
        Canny(gray, edges, 1, 3);


        opencv_core.Mat lines = new opencv_core.Mat();
        HoughLinesP(edges, lines, 1, CV_PI / 180, 550, 30, 10);
        IntRawIndexer indexer= lines.createIndexer();
        for (int i = 0; i < lines.rows(); i++) {
            int x1    = indexer.get(i, 0, 0);
            int y1    = indexer.get(i, 0, 1);
            int x2    = indexer.get(i, 0, 2);
            int y2    = indexer.get(i, 0, 3);

            System.out.println("x1 = "+x1+", y1 = "+y1+", x2 = "+x2+", y2 = "+y2);

            opencv_core.Point pt1 = new opencv_core.Point(x1, y1);
            opencv_core.Point pt2 = new opencv_core.Point(x2, y2);
            opencv_core.Scalar colr  = new opencv_core.Scalar(0, 0, 255, 128);

            opencv_imgproc.line(img, pt1, pt2, colr, 1, LINE_AA, 0);

            }

        imshow("lines", img);
        waitKey(0);
    }
}
