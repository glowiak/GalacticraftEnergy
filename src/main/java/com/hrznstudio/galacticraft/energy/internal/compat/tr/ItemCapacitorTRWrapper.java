/*
 * Copyright (c) 2021 HRZN LTD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.hrznstudio.galacticraft.energy.internal.compat.tr;

import com.hrznstudio.galacticraft.energy.api.Capacitor;
import com.hrznstudio.galacticraft.energy.compat.tr.TREnergyType;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class ItemCapacitorTRWrapper implements EnergyStorage {
    private final Capacitor capacitor;

    public ItemCapacitorTRWrapper(Capacitor capacitor) {
        this.capacitor = capacitor;
    }

    @Override
    public double getStored(EnergySide energySide) {
        return this.capacitor.getEnergyAs(TREnergyType.INSTANCE);
    }

    @Override
    public void setStored(double v) {
        this.capacitor.setEnergy(this.capacitor.getEnergyType().convertFrom(TREnergyType.INSTANCE, (int)v));
    }

    @Override
    public double getMaxStoredPower() {
        return this.capacitor.getMaxCapacityAs(TREnergyType.INSTANCE);
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.INFINITE; //todo tiers or max I/O
    }
}
