/*
 * ReportSpecificationsUTh_Ign.java
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
package org.earthtime.dataDictionaries.reportSpecifications;

import java.util.HashMap;
import java.util.Map;
import org.earthtime.dataDictionaries.RadDates;
import org.earthtime.dataDictionaries.UThAnalysisMeasures;
import org.earthtime.dataDictionaries.UThCompositionalMeasures;
import org.earthtime.dataDictionaries.UThFractionationCorrectedIsotopicRatios;

/**
 *
 * @author James F. Bowring
 */
public class ReportSpecificationsUTh_Ign extends ReportSpecificationsAbstract {

    // Report column order =
    //  displayName1, displayName2, displayName3, units, retrieveMethodName, retrieveParameterName, uncertaintyType,
    //     footnoteSpec, visible, useArbitrary? for value, digitcount value, unct visible (if required), description where needed,
    //     needsLead, needsUranium
    // details: https://docs.google.com/spreadsheets/d/1w15Nc4uD2WEg_e5KvAsNJrBaIImTPPTM8f33NaKkw34/edit#gid=0
    /**
     *
     */
    public static final String[][] ReportCategory_USeriesReportTable = new String[][]{
        //        {"", "", "IGSN", "", "getCompositionalMeasureByName", UThCompositionalMeasures.conc238U.getName(), "ABS",
        //            "", "true", "true", "3", "", "238U concentration", "false", "false"
        //        },
        //
        {"", "Th", "", "ppm", "getCompositionalMeasureByName", UThCompositionalMeasures.conc232Th.getName(), "ABS",
            "", "true", "false", "3", "true", "232Th concentration", "false", "false"
        },
        {"", "[232Th]", "", "*1e3 dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc232Th.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "232Th concentration activity", "false", "false"
        },
        {"", "U", "", "ppm", "getCompositionalMeasureByName", UThCompositionalMeasures.conc238U.getName(), "ABS",
            "", "true", "false", "3", "true", "238U concentration", "false", "false"
        },
        {"", "[238U]", "", "dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc238U.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "238U concentration activity", "false", "false"
        },
        //
        {"", "230Th", "", "ppt", "getCompositionalMeasureByName", UThCompositionalMeasures.conc230Th.getName(), "ABS",
            "", "false", "false", "3", "true", "230Th concentration", "false", "false"
        },
        //
        {"", "[238U/", " 232Th]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar238U_232Thfc.getName(), "ABS",
            "FN-1", "true", "false", "3", "true", "[238U/232Th]", "false", "false"
        },
        {"", "238U/", "232Th", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r238U_232Thfc.getName(), "ABS",
            "", "false", "false", "3", "true", "238U/232Th", "false", "false"
        },
        //
        {"", "[230Th/", " 232Th]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_232Thfc.getName(), "ABS",
            "FN-1", "true", "false", "3", "true", "[230Th/232Th]", "false", "false"
        },
        {"", "230Th/", "232Th", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_232Thfc.getName(), "ABS",
            "", "false", "false", "3", "true", "230Th/232Th", "false", "false"
        },
        //
        {"", "[230Th/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_238Ufc.getName(), "ABS",
            "FN-1&FN-2", "false", "false", "3", "true", "[230Th/238U] (not detrital Th-corr.)", "false", "false"
        },
        {"", "230Th/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_238Ufc.getName(), "ABS",
            "FN-2", "false", "false", "3", "true", "230Th/238U (not detrital Th-corr.)", "false", "false"
        },
        //
        {"[232Th/", " 238U]", "", "*1e5", "getAnalysisMeasure", UThAnalysisMeasures.ar232Th_238Ufc.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "[232Th/238U]", "false", "false"
        },
        {"232Th/", "238U", "", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r232Th_238Ufc.getName(), "ABS",
            "", "false", "false", "3", "true", "232Th/238U", "false", "false"
        },
        //
        {"", "", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234U.getName(), "ABS",
            "FN-3", "false", "false", "3", "true", "delta234U (not detrital Th-corr.)", "false", "false"
        },
        {"", "[234U/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Ufc.getName(), "ABS",
            "FN-1&FN-3", "true", "false", "3", "true", "[234U/238U] (not detrital Th-corr.)", "false", "false"
        },
        {"", "234U/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Ufc.getName(), "ABS",
            "FN-3", "false", "false", "3", "true", "234U/238U (not detrital Th-corr.)", "false", "false"
        },
        //
        {"", "[230Th]", "", "dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc230Th.getName(), "ABS",
            "FN-1", "true", "false", "3", "true", "230Th concentration activity", "false", "false"
        },
        {"", "[226Ra]", "", "dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc226Ra.getName(), "ABS",
            "FN-1", "true", "false", "3", "true", "226Ra concentration activity", "false", "false"
        },
        //
        {"", "[226Ra/", " 230Th]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar226Ra_230Thfc.getName(), "ABS",
            "FN-1&FN-2", "true", "false", "3", "true", "[226Ra/230Th]", "false", "false"
        },
        {"", "226Ra/", "230Th", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r226Ra_230Thfc.getName(), "ABS",
            "FN-2", "false", "false", "3", "true", "226Ra/230Th", "false", "false"
        },
        {"", "Ba", "", "ppm", "getCompositionalMeasureByName", UThCompositionalMeasures.concBa.getName(), "ABS",
            "FN-4", "true", "true", "4", "false", "Ba concentration", "false", "false"
        },
        //
        {"", "[230Th/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_238Udc.getName(), "ABS",
            "FN-1&FN-2", "false", "false", "3", "true", "[230Th/238U] (detrital Th-corr.)", "false", "false"
        },
        {"", "230Th/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_238Udc.getName(), "ABS",
            "FN-2", "false", "false", "3", "true", "230Th/238U (detrital Th-corr.)", "false", "false"
        },
        //
        {"", "", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Udc.getName(), "ABS",
            "", "false", "false", "3", "true", "delta234U (detrital Th-corr.)", "false", "false"
        },
        {"", "[234U/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Udc.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "[234U/238U] (detrital Th-corr.)", "false", "false"
        },
        {"", "234U/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Udc.getName(), "ABS",
            "", "false", "false", "3", "true", "234U/238U (detrital Th-corr.)", "false", "false"
        },
        //
        {"", "", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.date.getName(), "ABS",
            "FN-6", "false", "false", "2", "true", "Date (not detrital Th-corr.)", "false", "false"
        },
        {" BP", "", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateBP.getName(), "ABS",
            "FN-7", "false", "false", "2", "true", "Date BP (not detrital Th-corr.)", "false", "false"
        },
        {"", "", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateCorr.getName(), "ABS",
            "", "false", "false", "2", "true", "Date (detrital Th-corr.)", "false", "false"
        },
        {" BP", "", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateCorrBP.getName(), "ABS",
            "", "false", "false", "2", "true", "Date BP (detrital Th-corr.)", "false", "false"
        },
        //
        {"", "delta234U", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Ui.getName(), "ABS",
            "", "false", "false", "3", "true", "initial delta234U (not detrital Th-corr.)", "false", "false"
        },
        {"[234U/", " 238U]", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Ui.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "initial [234U/238U] (not detrital Th-corr.)", "false", "false"
        },
        {"234U/", "238U", "initial", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Ui.getName(), "ABS",
            "", "false", "false", "3", "true", "initial 234U/238U (not detrital Th-corr.)", "false", "false"
        },
        //
        {"", "delta234U", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Uidc.getName(), "ABS",
            "", "false", "false", "3", "true", "initial delta234U (detrital Th-corr.)", "false", "false"
        },
        {"[234U/", " 238U]", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Uidc.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "initial [234U/238U] (detrital Th-corr.)", "false", "false"
        },
        {"234U/", "238U", "initial", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Uidc.getName(), "ABS",
            "", "false", "false", "3", "true", "initial 234U/238U (detrital Th-corr.)", "false", "false"
        },
        //
        {"rho", "date", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.rhoDate__delta234Ui.getName(), "",
            "", "false", "true", "3", "", "Corr. Coef. date - delta234Ui", "false", "false"
        }
    };

    /**
     *
     */
    public final static Map<String, String> reportTableFootnotes = new HashMap<String, String>();

    static {

        reportTableFootnotes.put(//
                "FN-1", //
                "Square brackets indicate activity ratios calculated from atomic abundances using the decay constants\n"
                + "<lambda238>, <lambda230>, and <lambda226>.");
        reportTableFootnotes.put(//
                "FN-2", //
                "Ratio measured with a tracer calibrated against gravimetric U and Th solutions.");
        reportTableFootnotes.put(//
                "FN-3", //
                "Ratio calibrated to a gravimetric U solution.");
        reportTableFootnotes.put(
                "FN-4",
                "Ba concentrations have an uncertainty of 0.1%.");

        reportTableFootnotes.put(//
                "FN-6", //
                "Uncorrected, closed-system date calculated using the decay constants <lambda230>,\n<lambda234>, and <lambda238>.\nDates reported relative to"
                + " the date of analysis, <dateOfAnalysis>,\nand do not include uncertainties associated with decay constants.");
        reportTableFootnotes.put(//
                "FN-7", //
                "Uncorrected, closed-system date calculated using the decay constants <lambda230>,\n<lambda234>, and <lambda238>.\nDates reported as Before Present (BP),"
                + " where Present is the year 1950 CE.,\nand do not include uncertainties associated with decay constants.");

    }
}
