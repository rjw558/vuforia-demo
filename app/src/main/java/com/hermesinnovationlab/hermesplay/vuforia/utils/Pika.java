/*===============================================================================
Copyright (c) 2016 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.hermesinnovationlab.hermesplay.vuforia.utils;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Properties;


public class Pika extends MeshObject
{

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    Properties properties;


    public Pika(Properties inProperties)
    {
        properties = inProperties;
        setVerts();
        setTexCoords();
    }
    
    
    private void setVerts()
    {
        String arrayString = (String) properties.get("verts");
        String[] sar = arrayString.split(",");
        ArrayList<Double> array = new ArrayList<>();
        for (String s : sar) {
            array.add(new Double(s));
        }
        double[] dub = new double[array.size()];
        int i = 0;
        for(Double d : array) {
            dub[i] = (double) d;
            i++;
        }
        double[] TEAPOT_VERTS = dub;
        mVertBuff = fillBuffer(TEAPOT_VERTS);

        verticesNumber = TEAPOT_VERTS.length / 3;
    }


    private void setTexCoords()
    {
        String arrayString = (String) properties.get("tex");
        String[] sar = arrayString.split(",");
        ArrayList<Double> array = new ArrayList<>();
        for (String s : sar) {
            array.add(new Double(s));
        }
        double[] dub = new double[array.size()];
        int i = 0;
        for(Double d : array) {
            dub[i] = (double) d;
            i++;
        }
        double[] TEAPOT_TEX_COORDS = dub;
        mTexCoordBuff = fillBuffer(TEAPOT_TEX_COORDS);
    }



    public int getNumObjectIndex()
    {
        return indicesNumber;
    }
    
    
    @Override
    public int getNumObjectVertex()
    {
        return verticesNumber;
    }
    
    
    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            default:
                break;
        
        }
        
        return result;
    }
    
}
