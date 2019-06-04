/*
 * IsochronsSelectorDialog.java
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
package org.earthtime.plots.evolution;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import org.earthtime.UPb_Redux.exceptions.BadLabDataException;
import org.earthtime.beans.ET_JButton;
import org.earthtime.dialogs.DialogEditor;
import org.earthtime.exceptions.ETWarningDialog;
import org.earthtime.plots.evolution.seaWater.SeaWaterInitialDelta234UTableModel;
import org.earthtime.reduxLabData.ReduxLabData;

/**
 *
 * @author James F. Bowring
 */
public class InitialDelta234USeaWaterModelSelectorDialog extends DialogEditor {

    // Fields    
    private SeaWaterInitialDelta234UTableModel seaWaterInitialDelta234UTableModel;
    private boolean showSeaWaterModel;

    /**
     * Creates new form IsochronsSelectorDialog
     *
     * @param parent
     * @param modal
     * @param seaWaterInitialDelta234UTableModel
     */
    public InitialDelta234USeaWaterModelSelectorDialog(//
            java.awt.Frame parent,
            boolean modal,
            SeaWaterInitialDelta234UTableModel seaWaterInitialDelta234UTableModel) {
        super(parent, modal);

        this.seaWaterInitialDelta234UTableModel = seaWaterInitialDelta234UTableModel;

        initComponents();

        initSeaWaterModelChooser();
        SeaWaterModelItemListener seaWaterModelItemListener
                = new SeaWaterModelItemListener();
        seaWaterModelChooser.addItemListener(seaWaterModelItemListener);
        
        showSeaWaterModel = false;
        showSeaWaterCheckBox.setSelected(showSeaWaterModel);

    }

    private void initSeaWaterModelChooser() {

        // set up SeaWaterModelChooser
        seaWaterModelChooser.removeAllItems();
        ArrayList<SeaWaterInitialDelta234UTableModel> seaWaterModels = ReduxLabData.getInstance().getSeaWaterModels();
        for (int i = 0; i < seaWaterModels.size(); i++) {
            seaWaterModelChooser.addItem(seaWaterModels.get(i).getNameAndVersion());
        }

        seaWaterModelChooser.setSelectedIndex(0);
        seaWaterModelChooser.setSelectedItem(seaWaterInitialDelta234UTableModel.getNameAndVersion());
    }

    class SeaWaterModelItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evt) {
            // Get the affected SeaWaterModel
            try {
                SeaWaterInitialDelta234UTableModel model = ReduxLabData.getInstance().getASeaWaterModel((String) evt.getItem());

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    // Item was just selected
                    seaWaterInitialDelta234UTableModel = model;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    // Item is no longer selected
                }
            } catch (BadLabDataException ex) {
                new ETWarningDialog(ex).setVisible(true);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        unitsChoiceButtonGroup = new javax.swing.ButtonGroup();
        buttonsPanel = new javax.swing.JPanel();
        close_button = new ET_JButton();
        initDelta234U_LayeredPane = new javax.swing.JLayeredPane();
        specifyInitDelta234U_label = new javax.swing.JLabel();
        showSeaWaterCheckBox = new javax.swing.JCheckBox();
        seaWaterModelChooser = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Isochron Chooser");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(245, 236, 206));
        setForeground(java.awt.Color.white);
        setName(getTitle());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonsPanel.setBackground(new java.awt.Color(252, 236, 235));
        buttonsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        buttonsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close_button.setForeground(new java.awt.Color(255, 51, 0));
        close_button.setText("Done");
        close_button.setMargin(new java.awt.Insets(0, 1, 0, 1));
        close_button.setPreferredSize(new java.awt.Dimension(140, 23));
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });
        buttonsPanel.add(close_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 3, 270, 25));

        getContentPane().add(buttonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 370, 30));

        initDelta234U_LayeredPane.setBackground(new java.awt.Color(255, 204, 204));
        initDelta234U_LayeredPane.setOpaque(true);

        specifyInitDelta234U_label.setText("Choose Seawater Model");
        initDelta234U_LayeredPane.add(specifyInitDelta234U_label);
        specifyInitDelta234U_label.setBounds(10, 10, 300, 16);

        showSeaWaterCheckBox.setBackground(new java.awt.Color(255, 204, 204));
        showSeaWaterCheckBox.setSelected(true);
        showSeaWaterCheckBox.setText("Show Seawater Model");
        showSeaWaterCheckBox.setOpaque(true);
        showSeaWaterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSeaWaterCheckBoxActionPerformed(evt);
            }
        });
        initDelta234U_LayeredPane.add(showSeaWaterCheckBox);
        showSeaWaterCheckBox.setBounds(70, 190, 190, 23);
        initDelta234U_LayeredPane.add(seaWaterModelChooser);
        seaWaterModelChooser.setBounds(10, 40, 340, 25);

        getContentPane().add(initDelta234U_LayeredPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        close();
    }//GEN-LAST:event_close_buttonActionPerformed

    private void showSeaWaterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSeaWaterCheckBoxActionPerformed
        showSeaWaterModel = !showSeaWaterModel;
    }//GEN-LAST:event_showSeaWaterCheckBoxActionPerformed

    /**
     * @return the seaWaterInitialDelta234UTableModel
     */
    public SeaWaterInitialDelta234UTableModel getSeaWaterInitialDelta234UTableModel() {
        return seaWaterInitialDelta234UTableModel;
    }

    /**
     * @return the showSeaWaterModel
     */
    public boolean isShowSeaWaterModel() {
        return showSeaWaterModel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton close_button;
    private javax.swing.JLayeredPane initDelta234U_LayeredPane;
    private javax.swing.JComboBox<String> seaWaterModelChooser;
    private javax.swing.JCheckBox showSeaWaterCheckBox;
    private javax.swing.JLabel specifyInitDelta234U_label;
    private javax.swing.ButtonGroup unitsChoiceButtonGroup;
    // End of variables declaration//GEN-END:variables

}
