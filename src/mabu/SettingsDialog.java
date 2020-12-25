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

package mabu;

import mabu.panels.SettingsPanel;

import javax.swing.JDialog;

/**
 *
 * @author Jahed
 */
public class SettingsDialog extends JDialog {

    public SettingsDialog()
    {
        initUI(); // Constructor calls private method initUI to 'Installize User Interface'
    }
    
    private void initUI()
    {
        SettingsPanel panel = new SettingsPanel(this); // Create a SetingsPanel
        add(panel); // Add the settingsPanel to this JDialog
        
        setTitle("All Settings");
        setSize(550, 325);
        setResizable(false);
        setAlwaysOnTop(true); // dialog will be on top of all other windows
        setLocationRelativeTo(null); // set location to the center
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // deletes frome memory but still rebuildable
    }
}
