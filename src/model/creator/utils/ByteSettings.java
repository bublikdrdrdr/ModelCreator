package model.creator.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Bublik on 20-Feb-16.
 */

public class ByteSettings {

    private class DataStruct {
        int tag;
        int size;
        int type; // {0,1,2... = boolean, byte, short, char, int, long, float, double, byte[], int[], double[], String, Bitmap
        //                         0       1       2     3    4     5     6       7      8      9        10       11      12
        Object object;
    }

    public static class ByteConverter {
        public static void insertArray(byte[] main_array, byte[] small_array, int position) {
            int to = small_array.length;
            if (small_array.length + position > main_array.length)
                to = main_array.length - position;

            for (int i = 0; i < to; i++) {
                main_array[i + position] = small_array[i];
            }
        }

        public static byte[] getArray(boolean b) {
            byte[] TR = new byte[1];
            if (b) TR[0] = 1;
            else TR[0] = 0;
            return TR;
        }

        public static byte[] getArray(byte b) {
            byte[] TR = new byte[1];
            TR[0] = b;
            return TR;
        }

        public static byte[] getArray(short s) {
            return ByteBuffer.allocate(2).putShort(s).array();
        }

        public static byte[] getArray(char c) {
            return ByteBuffer.allocate(2).putChar(c).array();
        }

        public static byte[] getArray(int i) {
            return ByteBuffer.allocate(4).putInt(i).array();
        }

        public static byte[] getArray(long l) {
            return ByteBuffer.allocate(8).putLong(l).array();
        }

        public static byte[] getArray(float f) {
            return ByteBuffer.allocate(4).putFloat(f).array();
        }

        public static byte[] getArray(double d) {
            return ByteBuffer.allocate(8).putDouble(d).array();
        }

        public static byte[] getArray(byte[] b) {
            return b;
        }

        public static byte[] getArray(int[] i) {
            byte[] TR = new byte[i.length * 4];
            byte[] target;
            for (int j = 0; j < i.length; j++) {
                target = getArray(i[j]);
                insertArray(TR, target, j * 4);
            }
            return TR;
        }

        public static byte[] getArray(double[] d) {
            byte[] TR = new byte[d.length * 8];
            byte[] target;
            for (int j = 0; j < d.length; j++) {
                target = getArray(d[j]);
                insertArray(TR, target, j * 4);
            }
            return TR;
        }

        public static byte[] getArray(String s) {
            return s.getBytes();
        }


        public static boolean getBoolean(byte[] bytes, int index) {
            if (bytes[index] == 1) return true;
            else return false;
        }

        public static byte getByte(byte[] bytes, int index) {
            return bytes[index];
        }

        public static short getShort(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 2);
            return bb.getShort();
        }

        public static char getChar(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 2);
            return bb.getChar();
        }

        public static int getInt(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 4);
            return bb.getInt();
        }

        public static long getLong(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 8);
            return bb.getLong();
        }

        public static float getFloat(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 4);
            return bb.getFloat();
        }

        public static double getDouble(byte[] bytes, int index) {
            ByteBuffer bb = ByteBuffer.wrap(bytes, index, 8);
            return bb.getDouble();
        }

        public static int[] getIntArray(byte[] bytes, int index, int byteArraySize) {
            int[] TR = new int[byteArraySize / 4];
            for (int i = 0; i < TR.length; i++) {
                TR[i] = getInt(bytes, index + i * 4);
            }
            return TR;
        }

        public static double[] getDoubleArray(byte[] bytes, int index, int byteArraySize) {
            double[] TR = new double[byteArraySize / 8];
            for (int i = 0; i < TR.length; i++) {
                TR[i] = getDouble(bytes, index + i * 8);
            }
            return TR;
        }

        public static String getString(byte[] bytes, int index, int byteArraySize) {
            byte[] subArray = Arrays.copyOfRange(bytes, index, index + byteArraySize);
            return new String(subArray);
        }
    }

    public String ERROR_TEXT = "";
    public boolean ERROR = false;

    private String key = "bublik_key";
    private LinkedList<DataStruct> list;
    private int VERSION = 2;
    public boolean Encode = false;

    private String FILE_NAME;
    

}