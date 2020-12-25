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

import mabu.panels.AboutPanel;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Jahed
 */
public class AboutDialog extends JDialog
{
    public AboutDialog()
    {
        initUI();
    }
    
    private void initUI()
    {
        AboutPanel panel = new AboutPanel(this);
        add(panel);
        
        setTitle("About Minecraft Backup & Restore");
        setSize(480, 300);
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}