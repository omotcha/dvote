package org.omotcha.utils;

import jnr.ffi.annotations.In;
import org.jetbrains.annotations.NotNull;

public class Bytes32Util {
    public byte[] str2bytes32(@NotNull String str){
        // length check
        int start = 0;
        if(str.length()==66 && str.startsWith("0x")){
            start = 2;
        }else if(str.length()!=64){
            return null;
        }
        // content check
        for(int i=start;i<str.length();i++){
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                return null;
            }
        }
        byte[] ret = new byte[32];
        int value;
        for(int i=0;i<32;i++){
            value = 16*(str.charAt(start+i*2)-'0') + str.charAt(start+i*2+1) - '0';
            ret[i] = (byte)value;
        }
        return ret;
    }

    public String bytes322str(byte[] bytes){
        //length check
        StringBuilder s = new StringBuilder();
        if(bytes.length!=32){
            return null;
        }
        for (byte aByte : bytes) {
            String hv = Integer.toHexString(aByte & 0xFF);
            if (hv.length() < 2) {
                s.append(0);
            }
            s.append(hv);
        }
        return s.toString();
    }
}
