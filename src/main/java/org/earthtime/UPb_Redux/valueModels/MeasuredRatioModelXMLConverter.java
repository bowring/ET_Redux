/*
 * MeasuredRatioModelXMLConverter.java
 *
 * Created on August 6, 2007, 8:50 PM
 *
 *
 * Copyright 2006-2018 James F. Bowring, CIRDLES.org, and Earth-Time.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.earthtime.UPb_Redux.valueModels;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.math.BigDecimal;

/**
 * A <code>MeasuredRatioModelXMLConverter</code> is used to marshal and
 * unmarshal data between <code>MeasuredRatioModel</code> objects and XML files.
 * 
 * @imports <a href=http://xstream.codehaus.org/javadoc/com/thoughtworks/xstream/converters/Converter.html>
 *          com.thoughtworks.xstream.converters.Converter</a>
 * @imports <a href=http://xstream.codehaus.org/javadoc/com/thoughtworks/xstream/converters/MarshallingContext.html>
 *          com.thoughtworks.xstream.converters.MarhsallingContext</a>
 * @imports <a href=http://xstream.codehaus.org/javadoc/com/thoughtworks/xstream/converters/UnmarshallingContext.html>
 *          com.thoughtworks.xstream.converters.UnmarshallingContext</a>
 * @imports <a href=http://xstream.codehaus.org/javadoc/com/thoughtworks/xstream/io/HierarchicalStreamReader.html>
 *          com.thoughtworks.xstream.io.HierachicalSreamReader</a>
 * @imports <a href=http://xstream.codehaus.org/javadoc/com/thoughtworks/xstream/io/HierarchicalStreamWriter.html>
 *          com.thoughtworks.xstream.io.HierarchicalStreamWriter</a>
 * @author James F. Bowring, javaDocs by Stan Gasque
 */
public class MeasuredRatioModelXMLConverter implements Converter {

    /**
     * checks the argument <code>clazz</code> against this <code>MeasuredRatioModel</code>'s
     * <code>Class</code>. Used to ensure that the object about to be
     * marshalled/unmarshalled is of the correct type.
     * 
     * @pre     argument <code>clazz</code> is a valid <code>Class</code>
     * @post    <code>boolean</code> is returned comparing <code>clazz</code>
     *          against <code>MeasuredRatioModel.class</code>
     * @param   clazz   <code>Class</code> of the <code>Object</code> you wish
     *                  to convert to/from XML
     * @return  <code>boolean</code> - <code>true</code> if <code>clazz</code> matches
     *          <code>MeasuredRatioModel</code>'s <code>Class</code>; else <code>false</code>.
     */
    public boolean canConvert(Class clazz) {
        return clazz.equals(MeasuredRatioModel.class);
    }

    /**
     * writes the argument <code>value</code> to the XML file specified through <code>writer</code>
     * 
     * @pre     <code>value</code> is a valid <code>MeasuredRatioModel</code>,
     *          <code>writer</code> is a valid <code>HierarchicalStreamWriter</code>,
     *          and <code>context</code> is a valid <code>MarshallingContext</code>
     * @post    <code>value</code> is written to the XML file specified via <code>writer</code>
     * @param   value   <code>MeasuredRatioModel</code> that you wish to write to a file
     * @param   writer  stream to write through
     * @param   context <code>MarshallingContext</code> used to store generic data
     */
    public void marshal(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) {

        ValueModel measuredRatio = (MeasuredRatioModel) value;

        writer.startNode("name");
        writer.setValue(measuredRatio.getName());
        writer.endNode();

        writer.startNode("value");
        writer.setValue(measuredRatio.getValue().toPlainString());
        writer.endNode();

        writer.startNode("uncertaintyType");
        writer.setValue(measuredRatio.getUncertaintyType());
        writer.endNode();

        writer.startNode("oneSigma");
        writer.setValue(measuredRatio.getOneSigma().toPlainString());
        writer.endNode();

        writer.startNode("fracCorr");
        writer.setValue(Boolean.toString(((MeasuredRatioModel) measuredRatio).isFracCorr()));
        writer.endNode();

        writer.startNode("oxideCorr");
        writer.setValue(Boolean.toString(((MeasuredRatioModel) measuredRatio).isOxideCorr()));
        writer.endNode();

    }

    /**
     * reads a <code>MeasuredRatioModel</code> from the XML file specified
     * through <code>reader</code>
     * 
     * @pre     <code>reader</code> leads to a valid <code>MeasuredRatioModel</code>
     * @post    returns the <code>MeasuredRatioModel</code> read from the XML file
     * @param   reader  stream to read through
     * @param   context <code>UnmarshallingContext</code> used to store generic data
     * @return  <code>MeasuredRatioModel</code> - <code>MeasuredRatioModel</code>
     *          read from file specified by <code>reader</code>
     */
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {

        ValueModel measuredRatio = new MeasuredRatioModel();
        
        reader.moveDown();
        measuredRatio.setName(reader.getValue());
        reader.moveUp();
        
        reader.moveDown();
        measuredRatio.setValue(new BigDecimal(reader.getValue()));
        reader.moveUp();

        // temp hack dec 2007 during transition to new data format
        reader.moveDown();
        if ("uncertaintyType".equals(reader.getNodeName())) {
            measuredRatio.setUncertaintyType(reader.getValue());
            reader.moveUp();

            reader.moveDown();
        }
        measuredRatio.setOneSigma(new BigDecimal(reader.getValue()));
        reader.moveUp();
        
        reader.moveDown();
        ((MeasuredRatioModel)measuredRatio).setFracCorr( (reader.getValue().equalsIgnoreCase("true")) ? true : false);
        reader.moveUp();

        reader.moveDown();
        ((MeasuredRatioModel)measuredRatio).setOxideCorr( (reader.getValue().equalsIgnoreCase("true")) ? true : false);
        reader.moveUp();
        
        return measuredRatio;
    }
}
