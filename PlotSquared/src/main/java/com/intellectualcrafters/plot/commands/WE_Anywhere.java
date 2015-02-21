////////////////////////////////////////////////////////////////////////////////////////////////////
// PlotSquared - A plot manager and world generator for the Bukkit API                             /
// Copyright (c) 2014 IntellectualSites/IntellectualCrafters                                       /
//                                                                                                 /
// This program is free software; you can redistribute it and/or modify                            /
// it under the terms of the GNU General Public License as published by                            /
// the Free Software Foundation; either version 3 of the License, or                               /
// (at your option) any later version.                                                             /
//                                                                                                 /
// This program is distributed in the hope that it will be useful,                                 /
// but WITHOUT ANY WARRANTY; without even the implied warranty of                                  /
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                                   /
// GNU General Public License for more details.                                                    /
//                                                                                                 /
// You should have received a copy of the GNU General Public License                               /
// along with this program; if not, write to the Free Software Foundation,                         /
// Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA                               /
//                                                                                                 /
// You can contact us via: support@intellectualsites.com                                           /
////////////////////////////////////////////////////////////////////////////////////////////////////
package com.intellectualcrafters.plot.commands;

import com.intellectualcrafters.plot.PlotSquared;
import com.intellectualcrafters.plot.object.PlotPlayer;
import com.intellectualcrafters.plot.util.MainUtil;
import com.intellectualcrafters.plot.util.bukkit.PWE;

public class WE_Anywhere extends SubCommand {
    public WE_Anywhere() {
        super("weanywhere", "plots.weanywhere", "Force bypass of WorldEdit", "weanywhere", "wea", CommandCategory.DEBUG, true);
    }
    
    @Override
    public boolean execute(final PlotPlayer plr, final String... args) {
        if (PlotSquared.worldEdit == null) {
            MainUtil.sendMessage(plr, "&cWorldEdit is not enabled on this server");
            return false;
        }
        if (Permissions.hasPermission(plr, "plots.worldedit.bypass") && PWE.hasMask(plr)) {
            PWE.removeMask(plr);
            MainUtil.sendMessage(plr, "&6Cleared your WorldEdit mask");
        } else {
            PWE.setMask(plr, plr.getLocation(), true);
            MainUtil.sendMessage(plr, "&6Updated your WorldEdit mask");
        }
        return true;
    }
}
