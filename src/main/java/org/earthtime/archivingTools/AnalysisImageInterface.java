/*
 * Copyright 2006-2018 James F. Bowring, CIRDLES.org, and Earth-Time.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.earthtime.archivingTools;

import org.earthtime.dataDictionaries.AnalysisImageTypes;

/**
 *
 * @author James F. Bowring <bowring at gmail.com>
 */
public interface AnalysisImageInterface {

    /**
     * @return the imageType
     */
    AnalysisImageTypes getImageType();

    /**
     * @return the imageURL
     */
    String getImageURL();

    /**
     * @param imageType the imageType to set
     */
    void setImageType(AnalysisImageTypes imageType);

    /**
     * @param imageURL the imageURL to set
     */
    void setImageURL(String imageURL);
    
}
