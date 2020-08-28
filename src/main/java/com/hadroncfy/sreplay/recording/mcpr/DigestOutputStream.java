package com.hadroncfy.sreplay.recording.mcpr;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Checksum;

public class DigestOutputStream extends OutputStream {
    private final Checksum sum;
    private final OutputStream out;

    public DigestOutputStream(OutputStream out, Checksum sum) {
        this.out = out;
        this.sum = sum;
    }

    @Override
    public void write(int b) throws IOException {
        sum.update(b);
        out.write(b);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        sum.update(b);
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        sum.update(b, off, len);
        out.write(b, off, len);
    }
}