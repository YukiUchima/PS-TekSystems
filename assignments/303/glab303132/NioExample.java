package glab303132;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;


public class NioExample {
    public static void main(String[] args) {
        //        multiChannel();
        fileTransferring();

    }

    private static void multiChannel() {

        String rootPath = System.getProperty("user.dir");
        Path file1 = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "file1.txt");
        Path file2 = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "file2.txt");

        Path[] files = {file1, file2};

        Path outputFile = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "outputFile.txt");

//        Get Channel
        try (FileOutputStream outputStream = new FileOutputStream(String.valueOf(outputFile));
             FileChannel targetchannel = outputStream.getChannel();
        ) {
            for (int i = 0; i < files.length; i++) {
//                Create input stream
                FileInputStream inputStreams = new FileInputStream(String.valueOf(files[i]));
//                Open channel on that inputstream
                FileChannel inputchannel = inputStreams.getChannel();
//                determine size of the channel
                long size = inputchannel.size();

//                Allocate bytebuffer size
                ByteBuffer buf = ByteBuffer.allocate((int) size);
                System.out.print("Buffer: " + (char) buf.get());

//                keep reading buffer if buf has content
                while (inputchannel.read(buf) > 0) {
//                    Flipped from read to write, to write to outputFile
                    buf.flip();
                    while (buf.hasRemaining()) {
                        targetchannel.write(buf);
                    }
                }
                inputStreams.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileTransferring() {
        String rootPath = System.getProperty("user.dir");
        Path file1 = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "file1.txt");
        Path file2 = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "file2.txt");

        Path[] files = {file1, file2};

        Path outputFile = Paths.get(rootPath, "PracticeAssignments", "src", "glab303132", "example2.txt");

        try (FileOutputStream outputStream = new FileOutputStream(String.valueOf(outputFile))) {
            WritableByteChannel targetChannel = outputStream.getChannel();

            for (int i = 0; i < files.length; i++) {
//                Get channels for input files
                FileInputStream inputStream = new FileInputStream(String.valueOf(files[i]));
                FileChannel inputChannel = inputStream.getChannel();

//                Transfer data to example2 file
                inputChannel.transferTo(0, inputChannel.size(), targetChannel);

//                close the inputchannel and the stream
                inputChannel.close();
                inputStream.close();
            }

//            close output stream and output channel
            outputStream.close();
            targetChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
