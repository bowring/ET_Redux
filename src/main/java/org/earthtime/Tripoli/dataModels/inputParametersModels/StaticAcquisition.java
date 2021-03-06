/*
 * StaticAcquisition.java
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

import org.earthtime.Tripoli.massSpecSetups.AbstractMassSpecSetup;
import org.earthtime.dataDictionaries.AcquisitionTypesEnum;

/**
 *
 * @author James F. Bowring
 */
public class StaticAcquisition extends AbstractAcquisitionModel {

    // Class variables
    private static final long serialVersionUID = 2945397018570073142L;
    // instance variables

    /**
     *
     */
        protected double cycleDurationInSeconds;

    /**
     *
     */
    public StaticAcquisition () {
        acquisitionType = AcquisitionTypesEnum.STATIC;
    }

    /**
     * @return the cycleDurationInSeconds
     */
    public double getCycleDurationInSeconds () {
        return cycleDurationInSeconds;
    }

    /**
     * @param cycleDurationInSeconds the cycleDurationInSeconds to set
     */
    public void setCycleDurationInSeconds ( double cycleDurationInSeconds ) {
        this.cycleDurationInSeconds = cycleDurationInSeconds;
    }

    /**
     *
     * @param massSpec
     */
    @Override
    public void updateMassSpecIntegrationTimes ( AbstractMassSpecSetup massSpec ) {
        massSpec.assignIntegrationTime( cycleDurationInSeconds );
    }
}
