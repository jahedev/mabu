/*
 *  Minecraft Application Backup Utility: A multi-platform backup utility for Minecraft running on java
 *  Copyright (C) 2013 Jahed Hossain
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact Author: jahedev@gmail.com
 */

package mabu.panels;

import mabu.Debug;
import mabu.SettingsDialog;
import mabu.preferences.AppPreferences;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author Jahed
 */
public class SettingsPanel extends javax.swing.JPanel
{

    private AppPreferences appPrefs = new AppPreferences();
    private Debug debug = new Debug();
    private JDialog dialog;
    
    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel(SettingsDialog d)
    {
        dialog = d;
        initComponents();
        updateAvailableSavedWorlds();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        settingsPanelText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        minecraftLocationLabel = new javax.swing.JLabel();
        minecraftLocationField = new javax.swing.JTextField();
        minecraftLocationBrowseButton = new javax.swing.JButton();
        backupLocationText = new javax.swing.JLabel();
        backupLocationField = new javax.swing.JTextField();
        backupLocationBrowseButton = new javax.swing.JButton();
        worldToBackupText = new javax.swing.JLabel();
        worldToBackupComboBox = new javax.swing.JComboBox();
        defaultExtensionText = new javax.swing.JLabel();
        mbfDefaultExtensionRadio = new javax.swing.JRadioButton();
        zipDefaultExtensionRadio = new javax.swing.JRadioButton();
        defaultExtensionFormatInfoText = new javax.swing.JLabel();
        mbfAssociateText = new javax.swing.JLabel();
        mbfAssociateButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        cancelButton = new javax.swing.JButton();
        saveAndCloseButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 300));

        settingsPanelText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        settingsPanelText.setForeground(new java.awt.Color(255, 255, 255));
        settingsPanelText.setText("Settings");

        minecraftLocationLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        minecraftLocationLabel.setForeground(new java.awt.Color(255, 255, 255));
        minecraftLocationLabel.setText("Minecraft Location:");

        minecraftLocationField.setText(appPrefs.getMinecraftLocation());

        minecraftLocationBrowseButton.setText("Browse...");
        minecraftLocationBrowseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                minecraftLocationBrowseButtonActionPerformed(evt);
            }
        });

        backupLocationText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        backupLocationText.setForeground(new java.awt.Color(255, 255, 255));
        backupLocationText.setText("Backup Location:");

        backupLocationField.setText(appPrefs.getBackupLocation());

        backupLocationBrowseButton.setText("Browse...");
        backupLocationBrowseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backupLocationBrowseButtonActionPerformed(evt);
            }
        });

        worldToBackupText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        worldToBackupText.setForeground(new java.awt.Color(255, 255, 255));
        worldToBackupText.setText("World To Backup:");

        worldToBackupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "World 1", "World 2", "World 3" }));

        defaultExtensionText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        defaultExtensionText.setForeground(new java.awt.Color(255, 255, 255));
        defaultExtensionText.setText("Default Extension:");

        mbfDefaultExtensionRadio.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(mbfDefaultExtensionRadio);
        mbfDefaultExtensionRadio.setForeground(new java.awt.Color(255, 255, 255));
        mbfDefaultExtensionRadio.setSelected(true);
        mbfDefaultExtensionRadio.setText(".mbf");

        zipDefaultExtensionRadio.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(zipDefaultExtensionRadio);
        zipDefaultExtensionRadio.setForeground(new java.awt.Color(255, 255, 255));
        zipDefaultExtensionRadio.setText(".zip");

        defaultExtensionFormatInfoText.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        defaultExtensionFormatInfoText.setForeground(new java.awt.Color(255, 255, 255));
        defaultExtensionFormatInfoText.setText("(Format is the same either way as ZIP)");

        mbfAssociateText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mbfAssociateText.setForeground(new java.awt.Color(255, 255, 255));
        mbfAssociateText.setText("Associate Minecraft Backup File (Opens .mbf): ");

        mbfAssociateButton.setText("How To?");
        mbfAssociateButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mbfAssociateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        saveAndCloseButton.setText("Save & Close");
        saveAndCloseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveAndCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mbfAssociateText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mbfAssociateButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAndCloseButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(backupLocationText)
                                .addGap(18, 18, 18)
                                .addComponent(backupLocationField, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backupLocationBrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minecraftLocationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minecraftLocationField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minecraftLocationBrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(settingsPanelText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(defaultExtensionText)
                                        .addGap(18, 18, 18)
                                        .addComponent(mbfDefaultExtensionRadio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(zipDefaultExtensionRadio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(defaultExtensionFormatInfoText)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(worldToBackupText)
                                .addGap(18, 18, 18)
                                .addComponent(worldToBackupComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsPanelText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minecraftLocationLabel)
                    .addComponent(minecraftLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minecraftLocationBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backupLocationText)
                    .addComponent(backupLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backupLocationBrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(worldToBackupText)
                    .addComponent(worldToBackupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultExtensionText)
                    .addComponent(mbfDefaultExtensionRadio)
                    .addComponent(zipDefaultExtensionRadio)
                    .addComponent(defaultExtensionFormatInfoText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbfAssociateText)
                    .addComponent(mbfAssociateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAndCloseButton)
                    .addComponent(cancelButton))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        mbfDefaultExtensionRadio.setSelected(appPrefs.isDefaultExtMBF());
        zipDefaultExtensionRadio.setSelected(!appPrefs.isDefaultExtMBF());
        mbfAssociateButton.setEnabled(!(appPrefs.isMbfAssociated()));
    }// </editor-fold>//GEN-END:initComponents

    private void minecraftLocationBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_minecraftLocationBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_minecraftLocationBrowseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileHidingEnabled(false);
        fileChooser.setDialogTitle("Select the file 'minecraft.jar'");
        fileChooser.setSelectedFile(new File("minecraft.jar"));
        int result = fileChooser.showOpenDialog(this);

        if ((result != JFileChooser.CANCEL_OPTION))
        {
            minecraftLocationField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_minecraftLocationBrowseButtonActionPerformed

    private void backupLocationBrowseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backupLocationBrowseButtonActionPerformed
    {//GEN-HEADEREND:event_backupLocationBrowseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select a location to backup files in");
        int result = fileChooser.showOpenDialog(this);

        if ((result != JFileChooser.CANCEL_OPTION))
        {
            backupLocationField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_backupLocationBrowseButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveAndCloseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAndCloseButtonActionPerformed
    {//GEN-HEADEREND:event_saveAndCloseButtonActionPerformed
        appPrefs.setMinecraftLocation(minecraftLocationField.getText());
        appPrefs.setBackupLocation(backupLocationField.getText());
        appPrefs.setWorldToBackup((String) worldToBackupComboBox.getItemAt(worldToBackupComboBox.getSelectedIndex()));
        appPrefs.setDefaultExtMBF((mbfDefaultExtensionRadio.isSelected() ? true : false));
        appPrefs.setMbfAssociated(!(mbfAssociateButton.isEnabled()));
        appPrefs.savePreferences();

        dialog.dispose();
    }//GEN-LAST:event_saveAndCloseButtonActionPerformed

    private void mbfAssociateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mbfAssociateButtonActionPerformed
    {//GEN-HEADEREND:event_mbfAssociateButtonActionPerformed
        if (Desktop.isDesktopSupported())
        {
            try
            {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("http://google.com"));
            }
            catch (Exception ex)
            {
                debug.printDebugInfo("Error: On open a link: " + ex);
            }
        }
    }//GEN-LAST:event_mbfAssociateButtonActionPerformed

    public final void updateAvailableSavedWorlds() // Updates the list of worlds
    {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        try
        {
            File savesDir = new File(appPrefs.getMinecraftLocation() + "/saves/");

            if (!savesDir.exists())
            {
                comboBoxModel.addElement("Saves directory not found");
                worldToBackupComboBox.setModel(comboBoxModel);
            }
            else
            {
                File savesDirListings[];
                savesDirListings = savesDir.listFiles();

                if (savesDirListings.length != 0)
                {
                    for (int i = 0; i < savesDirListings.length; i++)
                    {
                        if (savesDirListings[i].isDirectory())
                        {
                            comboBoxModel.addElement(savesDirListings[i].getName());
                        }
                        worldToBackupComboBox.setModel(comboBoxModel);
                    }
                }
            }
        } catch (Exception ex)
        {
            debug.printDebugInfo("Error: On updating Worlds To Backup combobox.\n Cause:" + ex + "\n");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backupLocationBrowseButton;
    private javax.swing.JTextField backupLocationField;
    private javax.swing.JLabel backupLocationText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel defaultExtensionFormatInfoText;
    private javax.swing.JLabel defaultExtensionText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton mbfAssociateButton;
    private javax.swing.JLabel mbfAssociateText;
    private javax.swing.JRadioButton mbfDefaultExtensionRadio;
    private javax.swing.JButton minecraftLocationBrowseButton;
    private javax.swing.JTextField minecraftLocationField;
    private javax.swing.JLabel minecraftLocationLabel;
    private javax.swing.JButton saveAndCloseButton;
    private javax.swing.JLabel settingsPanelText;
    private javax.swing.JComboBox worldToBackupComboBox;
    private javax.swing.JLabel worldToBackupText;
    private javax.swing.JRadioButton zipDefaultExtensionRadio;
    // End of variables declaration//GEN-END:variables
}