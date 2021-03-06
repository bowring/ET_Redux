/*
 * SingleCollectorAcquisition.java
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
package org.earthtime.Tripoli.dataModels.inputParametersModels;

import java.util.Map;
import org.earthtime.Tripoli.massSpecSetups.AbstractMassSpecSetup;
import org.earthtime.dataDictionaries.AcquisitionTypesEnum;
import org.earthtime.isotopes.IsotopesEnum;

/**
 *
 * @author James F. Bowring
 */
public class SingleCollectorAcquisition extends AbstractAcquisitionModel {

    // Class variables
   // private static final long serialVersionUID = 1l;//-1164757885416000963L;

    private Map<IsotopesEnum, Double> isotopeNameToIntegrationTimesMap;

    /**
     *
     */
    public SingleCollectorAcquisition () {
        acquisitionType = AcquisitionTypesEnum.SINGLE_COLLECTOR;
    }

    /**
     *
     * @param massSpec
     */
    @Override
    public void updateMassSpecIntegrationTimes ( AbstractMassSpecSetup massSpec ) {
        massSpec.assignIntegrationTimesToCollectors( isotopeNameToIntegrationTimesMap );
    }

    /**
     * @return the isotopeNameToIntegrationTimesMap
     */
    public Map<IsotopesEnum, Double> getIsotopeNameToIntegrationTimesMap () {
        return isotopeNameToIntegrationTimesMap;
    }

    /**
     * @param isotopeNameToIntegrationTimesMap the isotopeNameToIntegrationTimesMap to set
     */
    public void setIsotopeNameToIntegrationTimesMap ( Map<IsotopesEnum, Double> isotopeNameToIntegrationTimesMap ) {
        this.isotopeNameToIntegrationTimesMap = isotopeNameToIntegrationTimesMap;
    }
}
