/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.convert.ext;

import org.redkale.convert.Reader;
import org.redkale.convert.SimpledCoder;
import org.redkale.convert.Writer;

/**
 *
 * @author zhangjx
 * @param <R>
 * @param <W>
 */
public final class ByteSimpledCoder<R extends Reader, W extends Writer> extends SimpledCoder<R, W, Byte> {

    public static final ByteSimpledCoder instance = new ByteSimpledCoder();

    @Override
    public void convertTo(W out, Byte value) {
        out.writeByte(value);
    }

    @Override
    public Byte convertFrom(R in) {
        return in.readByte();
    }

}